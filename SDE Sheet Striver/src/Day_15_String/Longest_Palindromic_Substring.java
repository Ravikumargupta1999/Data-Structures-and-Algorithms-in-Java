package Day_15_String;

public class Longest_Palindromic_Substring {
    public String longestPalindrome(String s) {
        int n = s.length();
        String res = "";

        boolean[][] dp = new boolean[n][n];
        for (int g = 0; g < dp.length; g++) {
            for (int i = 0, j = g; i < n && j < n; i++, j++) {
                if (g == 0)
                    dp[i][j] = true;
                else if (g == 1) {
                    if (s.charAt(i) == s.charAt(j)) {
                        dp[i][j] = true;
                    } else {
                        dp[i][j] = false;
                    }
                } else {
                    if (s.charAt(i) == s.charAt(j)) {
                        dp[i][j] = dp[i + 1][j - 1];
                    } else {
                        dp[i][j] = false;
                    }
                }
                if (dp[i][j]) {
                    res = s.substring(i, j + 1);
                }
            }
        }
        return res;
    }
}
