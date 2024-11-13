public class D_Dynamic_Programming_443_Count_Balanced_Binary_Trees_of_Height_h {
    // https://practice.geeksforgeeks.org/problems/bbt-counter4914/1
    public static long count(int h) {
        int MOD = 1000000007;
        long[] dp = new long[h + 1];

        // base cases
        dp[0] = 1;
        dp[1] = 1;

        for (int i = 2; i <= h; ++i)
            dp[i] = (dp[i - 1] * ((2 * dp[i - 2]) % MOD + dp[i - 1]) % MOD) % MOD;

        return dp[h];
    }

}
