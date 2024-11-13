package Biweekly_Contest_87;

import java.util.Arrays;

public class Smallest_Subarrays_With_Maximum_Bitwise_OR {
    public static void main(String[] args) {
        System.out.println(8 ^ 10);
        int[] arr = {8, 10, 8};
        System.out.println(Arrays.toString(smallestSubarrays(arr)));
    }

    public static int[] smallestSubarrays(int[] nums) {

        int[] res = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            int max = nums[i];
            int xor = nums[i];
            int size = 1;
            for (int j = i + 1; j < nums.length; j++) {
                xor = xor | nums[j];
                if (xor > max) {
                    max = xor;
                    size = j - i + 1;
                }
            }
            res[i] = size;

        }
        return res;
    }
}
