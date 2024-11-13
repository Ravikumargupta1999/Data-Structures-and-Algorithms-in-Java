public class Video_30_Kadanes_Algorithm_for_Maximum_Sum_Subarray {
    // https://leetcode.com/problems/maximum-subarray/
    public int maxSubArray(int[] nums) {
        int csum = nums[0];
        int osum = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (csum >= 0)
                csum += nums[i];
            else
                csum = nums[i];
            osum = Math.max(osum, csum);
        }
        return osum;
    }
}
