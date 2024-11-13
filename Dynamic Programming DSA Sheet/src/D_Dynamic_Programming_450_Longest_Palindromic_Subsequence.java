// https://practice.geeksforgeeks.org/problems/longest-palindromic-subsequence-1612327878/1/#
// https://www.youtube.com/watch?v=RiNzHfoA2Lo
public class D_Dynamic_Programming_450_Longest_Palindromic_Subsequence {

    public static int longestPalindromic(String str) {
        int[][] dp = new int[str.length()][str.length()];
        for (int g = 0; g < dp.length; g++) {
            for (int i = 0, j = g; j < dp.length; j++, i++) {
                if (g == 0) {
                    dp[i][j] = 1;
                } else if (g == 1) {
                    char ch1 = str.charAt(i);
                    char ch2 = str.charAt(j);
                    dp[i][j] = ch1 == ch2 ? 2 : 1;
                } else {
                    char ch1 = str.charAt(i);
                    char ch2 = str.charAt(j);
                    if (ch1 == ch2) {
                        dp[i][j] = 2 + dp[i + 1][j - 1];
                    } else {
                        dp[i][j] = Math.max(dp[i][j - 1], dp[i + 1][j]);
                    }
                }
            }
        }
        return dp[0][str.length() - 1];
    }
}
