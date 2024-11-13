public class D_Dynamic_Programming_457_2_Best_Time_to_Buy_and_Sell_Stock_Infinite_Transactions {
    // https://www.youtube.com/watch?v=HWJ9kIPpzXs&list=PL-Jc9J83PIiG8fE6rj9F5a6uyQ5WPdqKy&index=31
    // https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/submissions/
    public int maxProfit(int[] prices) {
        int buyingDay = 0;
        int sellingDay = 0;
        int profit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] >= prices[i - 1]) {
                sellingDay++;
            } else {
                profit += prices[sellingDay] - prices[buyingDay];
                buyingDay = i;
                sellingDay = i;
            }
        }
        profit += prices[sellingDay] - prices[buyingDay];
        return profit;
    }

    public int maxProfit1(int[] prices) {
        int profit = 0;
        for (int i = 1; i < prices.length; i++) {
            if(prices[i] >= prices[i-1])
                profit += (prices[i] - prices[i-1]);
        }
        return profit;
    }
}