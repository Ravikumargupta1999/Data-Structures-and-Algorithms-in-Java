public class Array_22_Best_Time_to_Buy_And_Sell_Stock {
//    https://www.youtube.com/watch?v=34WE6kwq49U

    // TC : O(n^2)
    // SC : O(1)
    public static int maxProfit1(int[] arr) {
        int n = arr.length;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {

                if (arr[j] - arr[i] > 0) {
                    if (arr[j] - arr[i] > max)
                        max = arr[j] - arr[i];
                }
            }
        }
        if (max == Integer.MIN_VALUE)
            return 0;
        return max;
    }

    // TC : O(n)
    // SC : O(n)
    public int maxProfit2(int[] prices) {
        int[] nextMax = new int[prices.length];
        nextMax[prices.length - 1] = prices[prices.length - 1];
        for (int i = prices.length - 2; i >= 0; i--) {
            nextMax[i] = Math.max(prices[i], nextMax[i + 1]);
        }
        int max = 0;
        for (int i = 0; i < prices.length; i++) {
            max = Math.max(max, nextMax[i] - prices[i]);
        }
        return max;

    }

    public int maxProfit3(int[] prices) {
        int max = 0;
        int min = prices[0];
        for (int i = 0; i < prices.length; i++) {
            min = Math.min(min,prices[i]);
            max = Math.max(max, prices[i]-min);
        }
        return max;
    }
}
