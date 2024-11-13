public class D_Dynamic_Programming_418_Friends_Pairing {
    // https://practice.geeksforgeeks.org/problems/friends-pairing-problem5425/1
    // https://www.youtube.com/watch?v=SHDu0Ufjyk8
    // TC : O(n)
    // SC : O(n)
    public static long countFriendsPairings(int n) {
        if (n == 0)
            return 0;
        if (n == 1)
            return 1;
        long[] dp = new long[n + 1];
        dp[1] = 1;
        dp[2] = 2;

        for (int i = 3; i <= n; i++) {
            dp[i] = (dp[i - 1] + (dp[i - 2] * (i - 1))) % 1000000007;
        }

        return dp[n] % 1000000007;
    }

    // TC : O(n)
    // SC : O(1)
    public static long countFriendsPairings1(int n) {
        if (n <= 2)
            return n;
        long a = 1;
        long b = 2;
        long c = 0;
        int p = 1000000007;
        for (long i = 3; i <= n; i++) {
            c = ((b % p) + ((i - 1) * a) % p) % p;
            a = b;
            b = c;
        }
        return c;
    }
}
