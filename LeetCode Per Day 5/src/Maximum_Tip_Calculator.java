import java.util.Arrays;

public class Maximum_Tip_Calculator {
    // Recursion
    long maxTip(int[] a, int[] b, int n, int x, int y) {
        // code here
        long[][] dp = new long[x + 1][y + 1];
        for (long[] temp : dp)
            Arrays.fill(temp, -1);
        return findMax(a, b, dp, n - 1, x, y);
    }

    public long findMax(int[] a, int[] b, long[][] dp, int n, int x, int y) {
        if (n < 0)
            return 0;
        if (dp[x][y] != -1)
            return dp[x][y];
        if (x > 0 && y > 0)
            return dp[x][y] = Math.max(a[n] + findMax(a, b, dp, n - 1, x - 1, y), b[n] + findMax(a, b, dp, n - 1, x, y - 1));
        else if (x > 0)
            return dp[x][y] = a[n] + findMax(a, b, dp, n - 1, x - 1, y);
        else
            return dp[x][y] = b[n] + findMax(a, b, dp, n - 1, x, y - 1);
    }

    // Greedy

}
