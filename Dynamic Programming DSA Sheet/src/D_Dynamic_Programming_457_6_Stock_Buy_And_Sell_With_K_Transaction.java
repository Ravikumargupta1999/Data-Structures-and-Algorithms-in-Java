public class D_Dynamic_Programming_457_6_Stock_Buy_And_Sell_With_K_Transaction {
    // https://practice.geeksforgeeks.org/problems/maximum-profit4657/1#
    // https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iv/submissions/
    public static int stockBuySell(int[] arr, int n, int k) {
        int[][] dp = new int[k + 1][n];
        for (int t = 1; t <= k; t++) {
            for (int d = 1; d < arr.length; d++) {
                int max = dp[t][d - 1];
                for (int pd = 0; pd < d; pd++) {
                    int p_til_lm_1 = dp[t - 1][pd];
                    int p_t_t_h = arr[d] - arr[pd];
                    if (p_t_t_h + p_til_lm_1 > max)
                        max = p_t_t_h + p_til_lm_1;
                }
                dp[t][d] = max;
            }
        }
        return dp[k][n - 1];

    }

    public static int stockBuySell1(int[] arr, int n, int k) {
        int[][] dp = new int[k + 1][n];
        if (n == 0)
            return 0;
        for (int t = 1; t <= k; t++) {
            int max = Integer.MIN_VALUE;
            for (int d = 1; d < arr.length; d++) {
                if (dp[t - 1][d - 1] - arr[d - 1] > max)
                    max = dp[t - 1][d - 1] - arr[d - 1];
                if (max + arr[d] > dp[t][d - 1])
                    dp[t][d] = max + arr[d];
                else
                    dp[t][d] = dp[t][d - 1];
            }
        }
        return dp[k][n - 1];

    }
}