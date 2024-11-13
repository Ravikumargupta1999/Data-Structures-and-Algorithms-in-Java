package Day_1_Arrays;

public class Kadanes_Algorithm {
    //https://leetcode.com/problems/maximum-subarray/submissions/
    public int maxSubArray(int[] nums) {
        int currSum = 0;
        int overAllMax = Integer.MIN_VALUE;
        for (int val : nums) {

            if (currSum > 0) {
                currSum += val;
            }else {
                currSum = val;
            }
            overAllMax = Math.max(overAllMax,currSum);
        }
        return overAllMax;
    }
}
