package Day_25_Dynamic_Programming;

public class Longest_Common_Subsequence {
    public int longestCommonSubsequence(String s1, String s2) {
        int x = s1.length();
        int y = s2.length();
        int[][] dp = new int[x + 1][y + 1];
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {

                char ch1 = s1.charAt(i - 1);
                char ch2 = s2.charAt(j - 1);

                if (ch1 == ch2)
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                else
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);

            }
        }
        return dp[x][y];
    }

    static int lcs(int x, int y, String s1, String s2) {
        int[][] dp = new int[2][s2.length() + 1];
        for (int i = s1.length() - 1; i >= 0; i--) {
            for (int j = s2.length() - 1; j >= 0; j--) {
                char ch1 = s1.charAt(i);
                char ch2 = s2.charAt(j);
                if (ch1 == ch2)
                    dp[(i) % 2][j] = 1 + dp[(i + 1) % 2][j + 1];
                else
                    dp[(i) % 2][j] = Math.max(dp[(i + 1) % 2][j], dp[(i) % 2][j + 1]);
            }
        }
        return Math.max(dp[0][0], dp[1][0]);
    }
}
