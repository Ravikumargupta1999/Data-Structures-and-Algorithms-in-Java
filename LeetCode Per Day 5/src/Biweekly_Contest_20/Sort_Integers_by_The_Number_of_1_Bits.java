package Biweekly_Contest_20;

import java.util.Arrays;

public class Sort_Integers_by_The_Number_of_1_Bits {
    public int[] sortByBits(int[] arr) {
        int[][] res = new int[arr.length][2];
        for (int i = 0; i < arr.length; i++) {
            res[i] = new int[]{i, arr[i]};
        }
        Arrays.sort(res, (a, b) -> {
            if (setBits(a[1]) != setBits(b[1]))
                return setBits(a[1]) - setBits(b[1]);
            return a[1] - b[1];
        });
        for (int i = 0; i < arr.length; i++) {
            arr[i] = res[i][1];
        }
        return arr;
    }

    int setBits(int n) {
        int counter = 0;
        while (n != 0) {
            int rightMostSetBit = (n & -n);
            n -= rightMostSetBit;
            counter++;
        }
        return counter;
    }
}
