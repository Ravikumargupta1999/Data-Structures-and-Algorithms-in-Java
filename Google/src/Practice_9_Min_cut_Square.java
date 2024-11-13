import java.util.ArrayList;
import java.util.Arrays;

public class Practice_9_Min_cut_Square {
    //https://practice.geeksforgeeks.org/problems/min-cut-square3303/1/?company[]=Google&company[]=Google&difficulty[]=1&page=2&query=company[]Googledifficulty[]1page2company[]Google

    int solve(int m, int n, int[][] dp) {

        if (m == n)

            return 1;

        if (m < 0 || n < 0)

            return Integer.MAX_VALUE;

        if (dp[m][n] != Integer.MAX_VALUE)

            return dp[m][n];

        for (int i = 1; i < m; i++)

            dp[m][n] = Math.min(dp[m][n], solve(i, n, dp) + solve(m - i, n, dp));

//        int temp2 = Integer.MAX_VALUE;

        for (int i = 1; i < n; i++)

            dp[m][n] = Math.min(dp[m][n], solve(m, i, dp) + solve(m, n - i, dp));

        return dp[m][n];

    }

    int minCut(int M, int N) {

        int[][] dp = new int[M + 1][N + 1];
        for (int[] temp : dp)
            Arrays.fill(temp, Integer.MAX_VALUE);


        return solve(M, N, dp);


    }
}
