import java.util.ArrayList;
import java.util.Arrays;

public class Video_55_Maximum_Alternating_Subsequence_Sum {
    // https://www.youtube.com/watch?v=JmRKB4dDU_0
    // https://leetcode.com/problems/maximum-alternating-subsequence-sum/


//    public long maxAlternatingSum(int[] nums) {
//        ArrayList<Long> res = new ArrayList<>();
//        res.add(Long.MIN_VALUE);
//        findMaxSum(nums, 0, true, 0, res);
//        return res.get(0);
//    }
//
//    public void findMaxSum(int[] arr, int index, boolean flag, long sum, ArrayList<Long> res) {
//        if (index == arr.length) {
//            res.set(0, Math.max(res.get(0), sum));
//            System.out.println(sum);
//            return;
//        }
//        long newSum = flag ? sum + arr[index] : sum - arr[index];
//        findMaxSum(arr, index + 1, !flag, newSum, res);
//        findMaxSum(arr, index + 1, flag, sum, res);
//    }


    long[][] dp;

    long help(int i, int flag, int[] nums) {
        if (i == nums.length)
            return 0;
        if (dp[i][flag] != Long.MIN_VALUE)
            return dp[i][flag];

        long val1 = help(i + 1, flag, nums);
        long val2 = 0;
        if (flag == 1)
            val2 += nums[i];
        else
            val2 -= nums[i];
        val2 += help(i + 1, 1 - flag, nums);
        return dp[i][flag] = Math.max(val1, val2);
    }

    public long maxAlternatingSum(int[] nums) {
        dp = new long[nums.length + 1][2];
        for (int i = 0; i < dp.length; i++) {
            dp[i][0] = dp[i][1] = Long.MIN_VALUE;
        }
        return help(0,1,nums);
    }


}
