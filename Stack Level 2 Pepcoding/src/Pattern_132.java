import java.util.HashMap;
import java.util.HashSet;
import java.util.Stack;
import java.util.TreeSet;
//https://leetcode.com/problems/132-pattern/
public class Pattern_132 {

    // T(C) : O(nlog(n))
    public static boolean find132pattern(int[] arr) {
        if(arr.length < 3 )
            return false;
        TreeSet<Integer> set = new TreeSet<>();
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i=2;i<arr.length;i++)
        {
            if(map.containsKey(arr[i]))
                map.put(arr[i],map.get(arr[i])+1);
            else
                map.put(arr[i],1);
        }
        int j = arr[1];
        int min = arr[0];
        for(int i=2;i<arr.length;i++)
        {
            set.add(arr[i]);
        }
        for(int i=1;i<arr.length-1;i++)
        {
            j = arr[i];
            int k  = 0;

            if(set.higher(min) != null) {
                k = set.higher(min);
//                System.out.println(min+"  "+j+"  "+k);
            }
            else {
                if(j < min)
                    min = j;
                set.remove(arr[i+1]);
                map.put(arr[i+1],map.get(arr[i+1])-1);
                if(map.get(arr[i+1])>=1)
                    set.add(arr[i+1]);
                continue;
            }
            if(k < j)
                return true;
            if(j < min)
                min = j;
            set.remove(arr[i+1]);
            map.put(arr[i+1],map.get(arr[i+1])-1);
            if(map.get(arr[i+1])>=1)
                set.add(arr[i+1]);
        }
        return false;
    }
    // T(C) : O(nlog(n))
    public static boolean find132pattern1(int[] arr) {
        int[] min = new int[arr.length];
        min[0] = arr[0];
        for(int i=1;i<arr.length;i++)
            min[i] = Math.min(min[i-1],arr[i]);
        Stack<Integer> st = new Stack<>();
        boolean found = false;
        for(int j= arr.length-1;j>=0;j--)
        {
            while (st.size()>0 && st.peek()<=min[j])
                st.pop();
            if(st.size()>0 && st.peek() < arr[j])
            {
                found = true;
                break;
            }
            st.push(arr[j]);
        }
        return found;
    }

    public static void main(String[] args) {
      int[] arr= {1,4,0,-1,-2,-3,-1,-2};
      System.out.println(find132pattern1(arr));

    }
}
