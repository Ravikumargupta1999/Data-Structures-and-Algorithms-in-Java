import java.util.Arrays;

// https://www.youtube.com/watch?v=kqdoUDVXFik&t=203s
// https://practice.geeksforgeeks.org/problems/array-removals/1
public class D_Dynamic_Programming_440_Minimum_removals_from_array_to_make_max_minus_min_less_than_or_Equal_to_K {

    int removals(int[] arr, int n, int k) {
        Arrays.sort(arr);
        int[][] dp = new int[n][n];

        for (int[] temp : dp) {
            Arrays.fill(temp, -1);
        }

        return minimumRemovals(arr, 0, n - 1, k, dp);
    }

    int minimumRemovals(int[] arr, int i, int j, int k, int[][] dp) {
        if (i >= j) {
            return 0;
        }

        if (arr[j] - arr[i] <= k) {
            return 0;
        }
        if (dp[i][j] != -1) {
            return dp[i][j];
        }
        return dp[i][j] = 1 + Math.min(minimumRemovals(arr, i + 1, j, k, dp), minimumRemovals(arr, i, j - 1, k, dp));

    }

}
