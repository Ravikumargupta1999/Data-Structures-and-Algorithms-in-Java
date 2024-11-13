public class D_Dynamic_Programming_423_Longest_Common_Subsequence {
    // https://www.youtube.com/watch?v=0Ql40Llp09E&t=1712s
    public static int LongestCommonSubsequences(String s1, String s2) {
        int[][] dp = new int[s1.length() + 1][s2.length() + 1];
        for (int i = dp.length - 2; i >= 0; i--) {
            for (int j = dp[0].length - 2; j >= 0; j--) {
                char c1 = s1.charAt(i);
                char c2 = s2.charAt(j);
                if (c1 == c2)
                    dp[i][j] = 1 + dp[i + 1][j + 1];
                else
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j + 1]);
            }
        }
        return dp[0][0];
    }

    // https://www.youtube.com/watch?v=Esx-TxF5PSo
    static int lcs(int x, int y, String s1, String s2) {
        int[][] dp = new int[x + 1][y + 1];
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = 0;
                } else {
                    char ch1 = s1.charAt(i - 1);
                    char ch2 = s2.charAt(j - 1);

                    if (ch1 == ch2)
                        dp[i][j] = 1 + dp[i - 1][j - 1];
                    else
                        dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[x][y];
    }
}
