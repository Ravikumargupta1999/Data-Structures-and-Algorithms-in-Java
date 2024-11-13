package Day_1_Arrays;

public class Best_Time_to_Buy_and_Sell_Stock {
    // https://leetcode.com/problems/best-time-to-buy-and-sell-stock/submissions/
    public int maxProfit(int[] prices) {
        int res = 0;
        int min = Integer.MIN_VALUE;

        for (int price : prices) {

            if (min == Integer.MIN_VALUE)
                min = price;
            if (price < min)
                min = price;
            res = Math.max(res, price - min);
        }
        return res;
    }
}
