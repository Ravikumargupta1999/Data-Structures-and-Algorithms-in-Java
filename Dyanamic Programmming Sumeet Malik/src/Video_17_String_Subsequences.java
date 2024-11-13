//https://practice.geeksforgeeks.org/problems/find-number-of-times-a-string-occurs-as-a-subsequence3020/1
// https://www.youtube.com/watch?v=YbanXpPqW1g
public class Video_17_String_Subsequences {
    static int countWays(String a, String b) {
        int m = a.length();
        int n = b.length();
        int[][] dp = new int[m + 1][n + 1];

        for (int i = 0; i <= n; ++i)
            dp[0][i] = 0;
        for (int i = 0; i <= m; ++i)
            dp[i][0] = 1;
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (a.charAt(i - 1) == b.charAt(j - 1))
                    dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];

                else
                    dp[i][j] = dp[i - 1][j];
            }
        }

        return dp[m][n];
    }


}
