import java.util.Arrays;

public class D_Dynamic_Programming_422_Maximize_The_Cut_Segments {
    // https://practice.geeksforgeeks.org/problems/cutted-segments1642/1
    // https://www.youtube.com/watch?v=O0N4xn38Ncg
    public int maximizeCuts(int n, int x, int y, int z) {
        int[] dp = new int[n + 1];
        Arrays.fill(dp, -1);
        dp[n] = 1 + Math.max(fun(n - x, x, y, z, dp), Math.max(fun(n - y, x, y, z, dp), fun(n - z, x, y, z, dp)));
        if (dp[n] < 0)
            return 0;
        return dp[n];
    }

    public int fun(int n, int x, int y, int z, int[] dp) {
        if (n < 0)
            return -1000000000;
        if (n == 0)
            return 0;
        if (dp[n] != -1)
            return dp[n];

        return dp[n] = 1 + Math.max(fun(n - x, x, y, z, dp), Math.max(fun(n - y, x, y, z, dp), fun(n - z, x, y, z, dp)));

    }
}
