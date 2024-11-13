import java.util.HashMap;

public class Video_28_Subarray_Sum_Equals_K {
    // https://practice.geeksforgeeks.org/problems/subarrays-with-sum-k/1/
    // https://leetcode.com/problems/subarray-sum-equals-k/submissions/
    public int subarraySum(int[] arr, int target) {
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
}
