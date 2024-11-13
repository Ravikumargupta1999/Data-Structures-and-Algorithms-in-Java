public class D_Dynamic_Programming_457_4_Best_Time_to_Buy_and_Sell_Stocks_With_Cool_Down_Infinite_Transactions {
    // https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-cooldown/
    // https://www.youtube.com/watch?v=GY0O57llkKQ&list=PL-Jc9J83PIiG8fE6rj9F5a6uyQ5WPdqKy&index=33
    public int maxProfit(int[] arr) {
        int n = arr.length;
        int bsp = -arr[0];
        int ssp = 0;
        int csp = 0;
        for (int i = 1; i < n; i++) {
            int temp1 = bsp;
            int temp2 = ssp;
            bsp = Math.max(bsp, csp - arr[i]);
            ssp = Math.max(ssp, arr[i] + temp1);
            csp = Math.max(csp, temp2);
        }
        return ssp;
    }
}
