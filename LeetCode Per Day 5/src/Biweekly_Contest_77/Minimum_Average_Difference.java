package Biweekly_Contest_77;

public class Minimum_Average_Difference {
    public int minimumAverageDifference(int[] nums) {
        int min = Integer.MAX_VALUE;
        int index = -1;
        int rightSum = 0;
        for (int num : nums)
            rightSum += num;
        int n = nums.length;
        int leftSum = 0;
        for (int i = 0; i < n; i++) {
            leftSum += nums[i];
            rightSum -= nums[i];
            int curr = 0;
            if (i != n - 1)
                curr = Math.abs((leftSum / (i + 1)) - (rightSum / (n - (i + 1))));
            else
                curr = Math.abs(leftSum /(i+1));
            if (curr < min) {
                min = curr;
                index = i;
            }
        }
        return index;
    }
}
