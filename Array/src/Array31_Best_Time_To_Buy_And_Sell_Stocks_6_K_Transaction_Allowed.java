public class Array31_Best_Time_To_Buy_And_Sell_Stocks_6_K_Transaction_Allowed {

    // https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iv/
    // TC : O(n^2 k)
    // SC : O(nk)
    public int maxProfit(int k, int[] prices) {
        if (prices.length == 0) {
            return 0;
        }
        int[][] dp = new int[k + 1][prices.length];
        for (int t = 1; t <= k; t++) {
            for (int d = 1; d < prices.length; d++) {
                int max = dp[t][d - 1];

                for (int pd = 0; pd < d; pd++) {
                    int a = dp[t - 1][pd];
                    int b = prices[d] - prices[pd];
                    max = Math.max(max, a + b);
                }
                dp[t][d] = max;

            }
        }
        return dp[k][prices.length - 1];
    }
    // https://www.youtube.com/watch?v=3YILP-PdEJA&list=PL-Jc9J83PIiG8fE6rj9F5a6uyQ5WPdqKy&index=35
    public int maxProfit2(int k, int[] prices) {
        if(prices.length == 0){
            return 0;
        }
        int n = prices.length;
        int[][] dp = new int[k + 1][n];
        for (int transaction = 1; transaction <= k; transaction++) {
            int max = Integer.MIN_VALUE;
            for (int days = 1; days < n; days++) {
                if (dp[transaction - 1][days - 1] - prices[days - 1] > max)
                    max = dp[transaction - 1][days - 1] - prices[days - 1];
                if (max + prices[days] > dp[transaction][days - 1]) {
                    dp[transaction][days] = max + prices[days];
                } else {
                    dp[transaction][days] = dp[transaction][days - 1];
                }
            }
        }
        return dp[k][n - 1];
    }
}
