public class Array31_Best_Time_to_Buy_And_Sell_Stocks_1_One_Transaction_Allowed {
    // https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
    public int maxProfit(int[] prices) {
        int max = 0;
        int min = prices[0];
        for (int i = 0; i < prices.length; i++) {
            min = Math.min(min,prices[i]);
            max = Math.max(max, prices[i]-min);
        }
        return max;
    }
}
