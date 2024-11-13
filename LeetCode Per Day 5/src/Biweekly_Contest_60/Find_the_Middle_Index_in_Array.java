package Biweekly_Contest_60;

public class Find_the_Middle_Index_in_Array {
    public int findMiddleIndex(int[] nums) {
        int leftSum = 0;
        int rightSum = 0;
        for (int num : nums)
            rightSum += num;

        for (int i = 0; i < nums.length; i++) {
            rightSum -= nums[i];
            if(leftSum == rightSum)
                return i;
            leftSum += nums[i];
        }
        return -1;
    }
}
