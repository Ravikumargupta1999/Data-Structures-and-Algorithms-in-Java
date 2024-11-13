public class Array_22_Best_Time_To_Buy_And_Sell_Stock_II {
    // https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/submissions/
    // https://www.youtube.com/watch?v=Q7v239y-Tik
    public int maxProfit1(int[] prices) {
        int buyingDay = 0;
        int sellingDay = 0;
        int profit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] >= prices[i - 1]) {
                sellingDay++;
            } else {
                profit += (prices[sellingDay] - prices[buyingDay]);
                buyingDay = i;
                sellingDay = i;
            }
        }
        profit += (prices[sellingDay] - prices[buyingDay]);
        return profit;
    }

    // https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/submissions/
    // Calculate Increasing value
    public int maxProfit(int[] prices) {
        int profit = 0;
        for (int i = 1; i < prices.length; i++)
            if (prices[i] >= prices[i - 1])
                profit += (prices[i] - prices[i - 1]);
        return profit;
    }
}
