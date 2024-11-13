public class Array31_Best_Time_To_Buy_And_Sell_Stocks_3_With_Transaction_Fee_and_Infinite_Transactions {
    // https://www.youtube.com/watch?v=pTQB9wbIpfU&list=PL-Jc9J83PIiG8fE6rj9F5a6uyQ5WPdqKy&index=32
    // https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-transaction-fee/
    public int maxProfit(int[] prices, int fee) {
        int bsp = -prices[0];
        int ssp = 0;

        for (int i = 1; i < prices.length; i++) {
            int temp = bsp;
            bsp = Math.max(bsp, ssp - prices[i]);
            ssp = Math.max(ssp, prices[i] + temp - fee);
        }
        return ssp;
    }
}
