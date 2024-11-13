package Weekly_Contest_318;

import java.util.HashMap;

public class Maximum_Sum_of_Distinct_Subarrays_With_Length_K {
    public static long maximumSubarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();


        long sum = 0;
        long res = 0;

        for (int i = 0; i < k - 1; i++) {
            sum += nums[i];
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        for (int i = k - 1; i < nums.length; i++) {
            sum += nums[i];
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);

            if(map.size() == k)
                res = Math.max(res,sum);

            sum -= nums[i-k+1];

            if(map.get(nums[i-k+1]) == 1)
                map.remove(nums[i-k+1]);
            else
                map.put(nums[i-k+1],map.get(nums[i-k+1])-1);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {9,4,9};
        int k = 1;
        System.out.println(maximumSubarraySum(nums,k));
    }
}
