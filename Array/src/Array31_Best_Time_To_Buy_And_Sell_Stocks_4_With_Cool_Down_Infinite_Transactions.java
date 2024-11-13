public class Array31_Best_Time_To_Buy_And_Sell_Stocks_4_With_Cool_Down_Infinite_Transactions {
    // https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-cooldown/submissions/
    // https://www.youtube.com/watch?v=GY0O57llkKQ&list=PL-Jc9J83PIiG8fE6rj9F5a6uyQ5WPdqKy&index=33
    public int maxProfit(int[] prices) {
        int bsp = -prices[0];
        int csp = 0;
        int ssp = 0;
        for (int i = 1; i < prices.length; i++) {
            int temp1 = bsp;
            int temp2 = ssp;
            bsp = Math.max(bsp,csp-prices[i]);
            ssp = Math.max(ssp,prices[i] + temp1);
            csp = Math.max(csp,temp2);
        }
        return ssp;
    }
}
