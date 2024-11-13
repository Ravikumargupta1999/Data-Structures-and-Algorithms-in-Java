import java.util.HashMap;

public class Array30_Elements_That_Appear_More_Than_N_divide_K_Times {
    public static int countOccurance(int[] arr, int n, int k)
    {
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i =0;i<n;i++)
        {
            if(map.containsKey(arr[i]))
            {
                map.put(arr[i],map.get(arr[i])+1);
            }
            else
            {
                map.put(arr[i],1);
            }
        }
        int count = 0;
        int value = n/k;
        for(int i=0;i<n;i++)
        {
            if(map.containsKey(arr[i]))
            {
                if(map.get(arr[i])>value)
                {
                    count++;
                    map.put(arr[i],0);
                }
            }
        }
        return count;
    }
}
