public class Video_13_Dyck_Path {
    // https://practice.geeksforgeeks.org/problems/dyck-path1028/1#
    // catalan number
    static Long dyckPaths(int n) {
        long[] dp = new long[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            int l = 0;
            int r = i - 1;
            while (l <= i - 1) {
                dp[i] += (dp[l] * dp[r]);
                l++;
                r--;
            }
        }

        return dp[n];
    }
}
