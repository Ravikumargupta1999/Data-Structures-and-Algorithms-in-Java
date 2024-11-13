package Time_And_Space_Complexity;

import java.util.Arrays;

public class Target_Sum_Pair {
    public static void targetSumPair(int[] arr, int target) {
        Arrays.sort(arr);
        int i = 0;
        int j = arr.length - 1;
        while (i < j) {
            int sum = arr[i] + arr[j];
            if (sum == target) {
                System.out.println(arr[i] + ", " + arr[j]);
                i++;
                j--;
            } else if (sum > target) {
                j--;
            } else {
                i++;
            }
        }
    }
}
