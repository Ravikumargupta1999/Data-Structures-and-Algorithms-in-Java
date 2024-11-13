import java.util.ArrayList;
import java.util.HashMap;

public class Count_distinct_elements_in_every_window {
    static ArrayList<Integer> countDistinct(int arr[], int n, int k)
    {
        HashMap<Integer,Integer> map = new HashMap<>();

        for(int i = 0 ;i<k;i++)
            map.put(arr[i],map.getOrDefault(arr[i],0)+1);
        ArrayList<Integer> al = new ArrayList<>();
        if(n == k)
        {
            al.add(map.size());
            return al;
        }
        al.add(map.size());
        System.out.println(0+"  "+map);
        for(int i = 1; i < n-k+1;i++)
        {

            if(map.get(arr[i-1]) > 1)
                map.put(arr[i-1],map.get(arr[i-1])-1);
            else
                map.remove(arr[i-1]);
            System.out.println(k+i-1);
            if(map.containsKey(arr[k+i-1]))
                map.put(arr[k+i-1],map.get(arr[k+i-1])+1);
            else
                map.put(arr[k+i-1],1);

            System.out.print(i+"  "+map+"   ");
            System.out.print(arr[i]+"  "+arr[k+i-1]+"   ");
            al.add(map.size());
            System.out.println(k+i-1);

        }
        return al;
    }

    public static void main(String[] args)
    {

        int N = 7, K =4;
        int A[] = {1,2,1,3,4,2,3};
        System.out.println(countDistinct(A,N,K));
    }
}
