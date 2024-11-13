public class D_Dynamic_Programming_467_Maximum_profit_by_buying_and_selling_a_share_at_most_k_times {
    // https://practice.geeksforgeeks.org/problems/maximum-profit4657/1
    static int maxProfit(int k, int n, int arr[]) {
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
}
