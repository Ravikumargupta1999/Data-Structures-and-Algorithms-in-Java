package Biweekly_Contest_75;

import java.util.ArrayList;
import java.util.Arrays;

public class Find_Triangular_Sum_of_anArray {
    public static int triangularSum(int[] nums) {
        int n = nums.length;

        while (n-- > 1) {

            for (int i = 0; i < n ; i++) {
                int temp = nums[i] + nums[i + 1];
                nums[i] = temp % 10;
            }
//            System.out.println(Arrays.toString(nums));
        }
//        System.out.println(Arrays.toString(nums));
        return nums[0];
    }

    public static void main(String[] args) {
        int[] arr = {1};
        System.out.println(triangularSum(arr));
    }
}
