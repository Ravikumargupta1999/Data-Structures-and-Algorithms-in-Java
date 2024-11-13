// https://practice.geeksforgeeks.org/problems/0-1-knapsack-problem0945/1
// https://www.youtube.com/watch?v=bUSaenttI24&t=639s
public class D_Dynamic_Programming_411_0_1_Knapsack {
    static int knapSack(int W, int wt[], int val[], int n)
    {
        int[][] dp = new int[n + 1][W + 1];


        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                int val1 = dp[i - 1][j];

                int val2 = j - wt[i - 1] >= 0 ? val[i - 1] + dp[i - 1][j - wt[i - 1]] : 0;

                dp[i][j] = Math.max(val1, val2);
            }
        }
        return dp[n][W];
    }

}
