public class Video_30_Shortest_Common_Supersequence {
    // https://www.youtube.com/watch?v=823Grn4_dCQ
    // https://practice.geeksforgeeks.org/problems/shortest-common-supersequence0322/1
    public static int shortestCommonSupersequence(String X, String Y, int m, int n) {
        return m + n - lcs(m, n, X, Y);
    }

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
