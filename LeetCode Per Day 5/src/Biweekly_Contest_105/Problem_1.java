package Biweekly_Contest_105;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Problem_1 {
    public int buyChoco(int[] prices, int money) {
        Arrays.sort(prices);
        if (prices.length < 2)
            return money;
        if (prices[0] + prices[1] <= money) {
            return money - (prices[0] + prices[1]);
        }
        return money;
    }

    public static long maxStrength(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        long res = 1;
        long minNeg = Integer.MIN_VALUE;
        long countPos = 0;
        long countZero = 0;
        long countNeg = 0;
        for (int num : nums) {
            if (num == 0) {
                countZero++;
                continue;
            }
            res = res * num;
            if (num < 0) {
                minNeg = Math.max(minNeg, num);
                countNeg++;
            } else {
                countPos++;
            }
        }
        if (countPos == nums.length) {
            return res;
        } else if (countNeg == nums.length) {
            if (countNeg % 2 == 0)
                return res;
            else
                return res / minNeg;
        } else if (countZero == nums.length) {
            return 0;
        }


        if (countPos != 0 && countNeg != 0 && countZero != 0) {
            if (countNeg % 2 != 0) {
                return res / minNeg;
            }
            return res;
        }
        if (countPos != 0 && countNeg != 0) {
            if (countNeg % 2 != 0) {
                return res / minNeg;
            }
            return res;
        }
        if (countPos != 0 && countZero != 0){
            return res;
        }
        if(countNeg == 1)
            return 0;
        if (countNeg % 2 != 0) {
            return res / minNeg;
        }
        return res;

    }

    public static void main(String[] args) {
        int[] arr = {0,-1};
        System.out.println(maxStrength(arr));
    }
}
