package Biweekly_Contest_73;

import java.util.ArrayList;
import java.util.Arrays;

public class Sort_the_Jumbled_Numbers {
//    [9,8,7,6,5,4,3,2,1,0]
//            [0,1,2,3,4,5,6,7,8,9]
//    Output: [0,9,8,7,6,5,4,3,2,1]
//    Expected: [9,8,7,6,5,4,3,2,1,0]
    public static void main(String[] args) {
        int[] mapping = {9,8,7,6,5,4,3,2,1,0};
        int[] nums = {0,1,2,3,4,5,6,7,8,9};
        System.out.println(new Sort_the_Jumbled_Numbers().sortJumbled(mapping, nums));
    }

    public int[] sortJumbled(int[] mapping, int[] nums) {
        int[][] arr = new int[nums.length][2];
        for (int i = 0; i < nums.length; i++) {
            arr[i] = new int[]{nums[i], mappedValue(mapping, nums[i])};
        }
        Arrays.sort(arr,(a,b)->{
            if(a[1] == b[1])
                return a[1];
            return a[1]-b[1];
        });


        for (int i = 0; i < nums.length; i++) {
            System.out.println(arr[i][0]);
            nums[i] = arr[i][0];
        }
        System.out.println(Arrays.toString(nums));

        return nums;
    }

    public int mappedValue(int[] mapping, int num) {
        int temp = num;
        int val = 0;
        while (num > 0) {
            int lastDigit = num % 10;
            num = num / 10;
            val = val * 10 + mapping[lastDigit];
        }
        val = reverse(val);
        System.out.println(temp + "   " + val);
        return val;
    }

    public int reverse(int x) {
        int ans = 0;
        while (x != 0) {

            int digit = x % 10;
            if ((ans > Integer.MAX_VALUE / 10) || (ans < Integer.MIN_VALUE / 10)) {
                return 0;
            }
            ans = ans * 10 + digit;
            x = x / 10;
        }
        return ans;
    }
}
