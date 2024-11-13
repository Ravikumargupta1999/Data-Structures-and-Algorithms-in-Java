public class D_Dynamic_Programming_446_Unbounded_Knapsack {
    // https://practice.geeksforgeeks.org/problems/knapsack-with-duplicate-items4201/1#
    // https://www.youtube.com/watch?v=jgps7MXtKRQ
    public static int knapSack(int W, int wt[], int val[], int n) {
        int[] dp = new int[W + 1];
        dp[0] = 0;
        for (int i = 1; i < dp.length; i++) {
            int max = 0;
            for (int j = 0; j < wt.length; j++) {
                if (wt[j] <= i) {
                    int remBagCapacity = i - wt[j];
                    int remBagValue = dp[remBagCapacity];
                    int totBagValue = remBagValue + val[j];
                    if (totBagValue > max) {
                        max = totBagValue;
                    }
                }

            }
            dp[i] = max;
        }
        return dp[W];
    }
}
