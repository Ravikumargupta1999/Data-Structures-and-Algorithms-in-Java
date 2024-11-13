public class D_Dynamic_Programming_411_0_1_Unbounded_Knapsack_0_1 {
    // https://practice.geeksforgeeks.org/problems/knapsack-with-duplicate-items4201/1
    // https://www.youtube.com/watch?v=jgps7MXtKRQ
    static int knapSack(int n, int W, int[] value, int[] weight) {
        int[] dp = new int[W + 1];
        for (int i = 1; i < dp.length; i++) {
            int max = Integer.MIN_VALUE;
            for (int j = 0; j < n; j++) {
                if (weight[j] <= i)
                    max = Math.max(max, value[j] + dp[i - weight[j]]);
            }
            dp[i] = max == Integer.MIN_VALUE ? 0 : max;
        }
        return dp[W];
    }

}
