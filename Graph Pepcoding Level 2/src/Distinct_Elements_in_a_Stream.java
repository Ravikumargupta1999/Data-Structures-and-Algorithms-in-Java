import java.util.ArrayList;
import java.util.HashMap;
// https://practice.geeksforgeeks.org/problems/distinct-elements-in-a-stream1557/0/?category#
public class Distinct_Elements_in_a_Stream {
    ArrayList<Integer> Solution(int arr[], int n)
    {
        HashMap<Integer,Integer> map = new HashMap<>();
        ArrayList<Integer> ans = new ArrayList<>();
        for(int i=0;i<n;i++)
        {
            if(arr[i] >= 0)
            {
                map.put(arr[i],map.getOrDefault(arr[i],0)+1);
                ans.add(map.size());
            }
            else
            {
                int val = -arr[i];
                if(map.containsKey(val))
                {

                    int count = map.get(val);
                    if(count != 1)
                    {
                        map.put(val,count-1);
                    }
                    else
                    {
                        map.remove(val);
                    }
                }
                ans.add(map.size());
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] arr = {1,2,-2,-1,5};
        Distinct_Elements_in_a_Stream a= new Distinct_Elements_in_a_Stream();
        System.out.println(a.Solution(arr,arr.length));
    }
}
//5
//        1 2 -2 -1 5
//
//
//
//        Your Output:
//        1 2 2 2 3
//
//        Expected Output:
//        1 2 1 0 1
