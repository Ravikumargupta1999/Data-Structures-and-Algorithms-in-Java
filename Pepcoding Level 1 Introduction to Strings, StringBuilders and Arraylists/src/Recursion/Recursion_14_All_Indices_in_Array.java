package Recursion;

import java.util.Arrays;

public class Recursion_14_All_Indices_in_Array {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 1};
        System.out.println(Arrays.toString(findAllIndex(arr, 0, 1, 0)));
    }

    public static int[] findAllIndex(int[] arr, int idx, int val, int count) {
        if (idx == arr.length)
            return new int[count];

        if (arr[idx] == val) {
            int[] ans = findAllIndex(arr, idx + 1, val, count + 1);
            ans[count] = idx;
            return ans;
        } else {
            int[] ans = findAllIndex(arr, idx + 1, val, count);
            return ans;
        }
    }
}
