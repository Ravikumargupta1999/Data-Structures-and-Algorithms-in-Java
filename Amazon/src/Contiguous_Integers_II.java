import java.util.HashMap;

//https://practice.geeksforgeeks.org/problems/consecutive-array-elements2711/1
public class Contiguous_Integers_II {
    boolean areConsecutives(long arr[], int n)
    {
        HashMap<Long,Integer> set = new HashMap<>();
        for(int i=0;i<n;i++)
            set.put(arr[i],set.getOrDefault(arr[i],0)+1);
        long min = Long.MAX_VALUE;
        long max = Long.MIN_VALUE;
        if(set.size() != n)
            return false;
        for(int i=0;i<n;i++)
        {
            if(arr[i] <min)
                min = arr[i];
            if(arr[i] > max)
                max = arr[i];
        }
        for(long i= min ;i <= max;i++)
        {
            if(set.containsKey(i) == false)
                return false;
        }
        return true;
    }
}
