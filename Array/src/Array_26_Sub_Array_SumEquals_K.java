import java.util.ArrayList;
import java.util.HashMap;


// Done


public class Array_26_Sub_Array_SumEquals_K {
    // https://leetcode.com/problems/subarray-sum-equals-k/submissions/
//    https://practice.geeksforgeeks.org/problems/subarrays-with-sum-k/1/
    public static int subArrayExists(int[] arr, int target) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        map.put(0, 1);
        int ans = 0;
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            if (map.containsKey(sum - target)) {
                ans += map.get(sum - target);
            }
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return ans;
    }

    // https://practice.geeksforgeeks.org/problems/subarray-with-given-sum-1587115621/1/
    static ArrayList<Integer> subArraySum(int[] arr, int n, int target) {
        ArrayList<Integer> list = new ArrayList<>();
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        map.put(0, -1);
        int ans = 0;
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            if (map.containsKey(sum - target)) {
                list.add(map.get(sum - target) + 2);
                list.add(i + 1);
                return list;
            }
            map.put(sum, i);
        }
        list.add(-1);
        return list;
    }
}

