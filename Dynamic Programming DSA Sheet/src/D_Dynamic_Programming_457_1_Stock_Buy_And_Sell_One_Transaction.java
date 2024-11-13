public class D_Dynamic_Programming_457_1_Stock_Buy_And_Sell_One_Transaction {
    // https://www.youtube.com/watch?v=4YjEHmw1MX0&list=PL-Jc9J83PIiG8fE6rj9F5a6uyQ5WPdqKy&index=30
    // https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
    public int maxProfit(int[] prices) {
        int buyDay = prices[0];
        int profit = 0;
        for (int val : prices) {
            buyDay = Math.min(buyDay, val);
            profit = Math.max(profit, val - buyDay);
        }
        return profit;
    }
}
