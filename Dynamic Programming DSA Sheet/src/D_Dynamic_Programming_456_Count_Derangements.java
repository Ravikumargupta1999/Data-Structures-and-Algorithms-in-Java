public class D_Dynamic_Programming_456_Count_Derangements {
    // https://www.youtube.com/watch?v=NW-BLDQHFXk&t=884s
    // https://practice.geeksforgeeks.org/problems/dearrangement-of-balls0918/1
    // https://www.codingninjas.com/codestudio/problems/count-derangements_873861?topList=top-amazon-coding-interview-questions&leftPanelTab=1
    public static long countDearrengement(int n) {
        long mod = 1000000007;
        long val1 = 0;
        if (n == 1)
            return val1;
        long val2 = 1;
        if (n == 2)
            return val2;
        for (long i = 3; i <= n; i++) {
            long current = ((i - 1) % mod) * ((val1) % mod + (val2) % mod);
            val1 = (val2) % mod;
            val2 = (current) % mod;
        }
        return val2;
    }

    // TC : O(n)
    // SC : O(n)
    public static int countDearrangement1(int n) {
        int[] dp = new int[n + 1];
        dp[1] = 0;
        dp[2] = 1;
        for (int i = 3; i <= n; i++) {
            dp[i] = (i - 1) * (dp[i - 1] + dp[i - 2]);
        }
        return dp[n];
    }
}
