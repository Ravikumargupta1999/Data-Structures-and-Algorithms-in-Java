package Biweekly_Contest_76;

import java.util.Arrays;

public class Find_Closest_Number_to_Zero {
    public int findClosestNumber(int[] nums) {

        int min = Math.abs(nums[0]);
        int res = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (Math.abs(nums[i]) < min) {
                min = Math.abs(nums[i]);
                res = nums[i];
            } else if (Math.abs(nums[i]) == min) {
                res = Math.max(res, nums[i]);
            }
        }
        return res;
    }
}
