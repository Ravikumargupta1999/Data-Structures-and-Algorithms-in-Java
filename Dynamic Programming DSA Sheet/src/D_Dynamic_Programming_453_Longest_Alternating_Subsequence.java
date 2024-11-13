public class D_Dynamic_Programming_453_Longest_Alternating_Subsequence {
    // TLE
    // TC : O(n^2)
    // SC : O(n)
    // https://www.youtube.com/watch?v=UogHvfQ3e18
    // https://practice.geeksforgeeks.org/problems/longest-alternating-subsequence5951/1#
    public int alternatingMaxLength(int[] arr) {
        int n = arr.length;
        int[][] dp = new int[2][n];
        for (int i = 0; i < n; i++)
            dp[0][i] = dp[1][i] = 1;

        int res = 1;


        for (int i = 1; i < n; i++) {
            int upperMax = 0;
            int lowerMax = 0;
            for (int j = 0; j < i; j++) {
                if (arr[j] > arr[i]) {
                    upperMax = Math.max(upperMax, dp[0][j]);
                }

                if (arr[j] < arr[i]) {
                    lowerMax = Math.max(lowerMax, dp[1][j]);
                }

            }

            dp[0][i] += lowerMax;
            dp[1][i] += upperMax;

            res = Math.max(res, Math.max(dp[0][i], dp[1][i]));
        }

        return res;
    }

    // TC : O(n)
    // SC : O(1)
    public static int alternatingMaxLength1(int[] arr) {
        int n = arr.length;
        int inc = 1;
        int dec = 1;
        for (int i = 1; i < n; i++) {
            if (arr[i] > arr[i - 1]) {
                inc = dec + 1;
            } else if (arr[i] < arr[i - 1]) {
                dec = inc + 1;
            }
        }

        // Return the maximum length
        return Math.max(inc, dec);
    }

}
