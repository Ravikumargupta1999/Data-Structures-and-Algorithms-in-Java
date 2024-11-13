package Biweekly_Contest_78;

import java.util.PriorityQueue;

public class Number_of_Ways_to_Split_Array {
    public int waysToSplitArray(int[] nums) {
        int[] right = new int[nums.length];
        int[] left = new int[nums.length];
        left[0] = nums[0];
        right[nums.length - 1] = nums[nums.length - 1];

        for (int i = 1; i < nums.length; i++) {
            left[i] = nums[i] + left[i - 1];
        }
        for (int j = nums.length - 2; j >= 0; j--) {
            right[j] = nums[j] + right[j + 1];
        }
        int count = 0;

        for (int i = 0; i < nums.length - 1; i++) {
            if (left[i] >= right[i + 1] )
                count++;
        }
        return count;
    }
}
