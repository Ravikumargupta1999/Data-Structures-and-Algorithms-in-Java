import java.util.Arrays;

public class Greedy_246_Buy_Maximum_Stocks_if_i_stocks_can_be_bought_on_i_the_day {

    // https://www.youtube.com/watch?v=lr5uTrdUQhM&t=263s
    // https://www.geeksforgeeks.org/buy-maximum-stocks-stocks-can-bought-th-day/
    // https://practice.geeksforgeeks.org/problems/buy-maximum-stocks-if-i-stocks-can-be-bought-on-i-th-day/1/
    // https://www.codingninjas.com/codestudio/problems/buy-maximum-stocks-if-i-stocks-can-be-bought-on-i-th-day_1169470?leftPanelTab=2
    public static int buyMaximumProducts(int n, int amount, int[] prices) {
        int[][] arr = new int[n][2];

        for (int i = 0; i < n; i++) {
            arr[i] = new int[]{prices[i], i + 1};
        }

        Arrays.sort(arr, (a, b) -> {
            return a[0] - b[0];
        });


        int totalStocks = 0;

        for (int[] stock : arr) {

            int price = stock[0];
            int availableStocks = stock[1];

            if (price * availableStocks <= amount) {
                totalStocks += availableStocks;
                amount -= (price * availableStocks);
            } else {
                totalStocks += (amount / price);
                return totalStocks;
            }
        }
        return totalStocks;
    }
}
