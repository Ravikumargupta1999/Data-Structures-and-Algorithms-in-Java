import java.util.Arrays;

public class D_Dynamic_Programming_439_Minimum_cost_to_fill_given_weight_in_a_bag {
    // Recursion
    static int min = Integer.MAX_VALUE;

    public static int minimumCost(int[] cost, int N, int W) {
        findCost(cost, 0, N, W, 0);
        return min;
    }

    public static void findCost(int[] cost, int index, int n, int W, int ans) {
        // System.out.println(index+"    "+W+"    "+ans);
        if (W == 0) {
            min = Math.min(min, ans);
            return;
        }
        if (index == n)
            return;
        if (cost[index] != -1 && W - (index + 1) >= 0) {
            findCost(cost, index, n, W - (index + 1), ans + cost[index]);
        }
        findCost(cost, index + 1, n, W, ans);
    }

    // Memoization
    static int helper(int cost[], int n, int w, int i, int[][] dp) {
        if (i >= n && w == 0)
            return 0;
        if (i >= n)
            return (int) 1e9;
        if (dp[i][w] != -1)
            return dp[i][w];
        if (cost[i] == -1) {
            return dp[i][w] = helper(cost, n, w, i + 1, dp);
        }
        if (i + 1 <= w) {
            return dp[i][w] = Math.min(cost[i] + helper(cost, n, w - (i + 1), i, dp), helper(cost, n, w, i + 1, dp));

        } else {
            return dp[i][w] = helper(cost, n, w, i + 1, dp);
        }

    }

    static int minimumCost2(int cost[], int N, int W) {
        int[][] dp = new int[N + 1][W + 1];
        for (int[] a : dp)
            Arrays.fill(a, -1);
        return helper(cost, N, W, 0, dp);
    }

    // Dynamic Programming
    // Same as Unbounded Knapsack
    // Sumit Malik
    // https://practice.geeksforgeeks.org/problems/minimum-cost-to-fill-given-weight-in-a-bag1956/1
    public int minimumCost1(int cost[], int n,int W)
    {
        int[] value = new int[n];
        for (int i = 0; i < n; i++)
            value[i] = i + 1;

        int[] dp = new int[W + 1];

        Arrays.fill(dp, -1);

        dp[0] = 0;

        for (int i = 1; i < dp.length; i++) {

            int minCost = Integer.MAX_VALUE;
            for (int j = 0; j < value.length; j++) {

                if (cost[j] == -1  || value[j] > i)
                    continue;

                if (dp[i - value[j]] != -1)
                    minCost = Math.min(minCost, cost[j] + dp[i - value[j]]);
            }
            if(minCost != Integer.MAX_VALUE)
                dp[i] = minCost;
        }
        return dp[W];
    }
}
