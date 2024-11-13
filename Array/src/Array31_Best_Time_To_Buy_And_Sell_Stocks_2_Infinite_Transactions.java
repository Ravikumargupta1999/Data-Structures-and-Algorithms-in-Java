public class Array31_Best_Time_To_Buy_And_Sell_Stocks_2_Infinite_Transactions {
    // https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/submissions/
    public int maxProfit(int[] prices) {
        int buyingDay = 0;
        int sellingDay = 0;
        int profit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] >= prices[i - 1])
                sellingDay++;
            else {
                profit += (prices[sellingDay] - prices[buyingDay]);
                sellingDay = buyingDay = i;
            }
        }
        profit += (prices[sellingDay] - prices[buyingDay]);
        return profit;
    }
}
