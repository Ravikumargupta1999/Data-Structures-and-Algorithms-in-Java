public class D_Dynamic_Programming_457_3_Best_Time_to_Buy_and_Sell_Stock_with_Transaction_Fee {
    // https://www.youtube.com/watch?v=pTQB9wbIpfU&list=PL-Jc9J83PIiG8fE6rj9F5a6uyQ5WPdqKy&index=32
    // https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-transaction-fee/
    public static int maxProfit(int[] arr, int fee) {
        int n = arr.length;
        int bsp = -arr[0];
        int ssp = 0;
        for (int i = 1; i < n; i++) {
            int temp = bsp;
            bsp = Math.max(bsp, ssp - arr[i]);
            ssp = Math.max(ssp, arr[i] + temp - fee);
            System.out.println(i + "   " + bsp + "    " + ssp);
        }
        return ssp;
    }

    public static void main(String[] args) {
        int[] arr = {10, 15, 17, 20, 16, 18, 22, 20, 22, 20, 23, 25};
        System.out.println(maxProfit(arr, 3));
    }

}
