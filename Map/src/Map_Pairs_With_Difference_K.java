import org.omg.Messaging.SYNC_WITH_TRANSPORT;

import java.sql.SQLIntegrityConstraintViolationException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
// https://www.youtube.com/watch?v=bAM0rffFsQw
// https://leetcode.com/problems/k-diff-pairs-in-an-array/submissions/
// https://practice.geeksforgeeks.org/problems/count-distinct-pairs-with-difference-k1233/1/?category[]=Map&category[]=Map&page=2&query=category[]Mappage2category[]Map#
//
public class Map_Pairs_With_Difference_K {
    public static int TotalPairs(int[] arr, int k) {

        int count = 0;
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<arr.length;i++)
            map.put(arr[i],map.getOrDefault(arr[i],0)+1);
        if(k == 0)
        {
            for (Map.Entry<Integer, Integer> entry : map.entrySet())
            {
                if(entry.getValue()>1)
                    count++;
            }
            return count;
        }
        for (Map.Entry<Integer, Integer> entry : map.entrySet())
        {
            if(map.containsKey(entry.getKey()-k))
                count++;
        }
        return count;



    }

    public static void main(String[] args) {
        int[] array = {1, 5, 4, 1, 2};
        int k = 0;
        System.out.println(TotalPairs(array,k));
    }
}
