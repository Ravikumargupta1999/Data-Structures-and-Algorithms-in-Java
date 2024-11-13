import java.util.Arrays;
import java.util.Scanner;

//https://practice.geeksforgeeks.org/problems/minimize-the-heights3351/1
// https://www.youtube.com/watch?v=VFKgBh164HI
class Array14_Minimize_height_II {
    // Brute Force Recursion;
    // TC : O(2^n)
    static int ans = Integer.MAX_VALUE;

    static int getMinDiff1(int[] arr, int n, int k) {
        solution(arr, 0, n, k, Integer.MIN_VALUE, Integer.MAX_VALUE);
        return ans;
    }

    public static void solution(int[] arr, int index, int n, int k, int min, int max) {
        if (index == arr.length) {
            ans = Math.min(max - min, ans);
            return;
        }
        min = Math.min(arr[index] + k, min);
        max = Math.max(arr[index] + k, max);
        solution(arr, index + 1, n, k, Math.min(arr[index] + k, min), Math.max(arr[index] + k, max));
        solution(arr, index + 1, n, k, Math.min(arr[index] - k, min), Math.max(arr[index] - k, max));


    }


    static int getMinDiff(int[] arr, int n, int k) {
        if (n == 1)
            return 0;

        int r = 0;
        Arrays.sort(arr);
        r = arr[n - 1] - arr[0];
        for (int i = 1; i < n; i++) {
            int max = Math.max(arr[i - 1] + k, arr[n - 1] - k);
            int min = Math.min(arr[i] - k, arr[0] + k);
            if (min < 0)
                continue;
            r = Math.min(r, max - min);

        }
        return r;
    }
}
