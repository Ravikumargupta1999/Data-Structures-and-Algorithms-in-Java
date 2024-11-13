import java.util.ArrayList;
import java.util.HashMap;

public class Video_28_Subarray_With_Given_Sum {
    // https://practice.geeksforgeeks.org/problems/subarray-with-given-sum-1587115621/1/#
    static ArrayList<Integer> subarraySum(int[] arr, int n, int target)
    {
        ArrayList<Integer> list = new ArrayList<>();
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        map.put(0, -1);
        int ans = 0;
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            if (map.containsKey(sum - target)) {
                list.add(map.get(sum-target)+2);
                list.add(i+1);
                return list;
            }
            map.put(sum, i);
        }
        list.add(-1);
        return list;
    }
}
