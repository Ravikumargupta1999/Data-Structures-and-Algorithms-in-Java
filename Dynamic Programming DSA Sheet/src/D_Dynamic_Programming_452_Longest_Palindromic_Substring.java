public class D_Dynamic_Programming_452_Longest_Palindromic_Substring {
    // https://leetcode.com/problems/longest-palindromic-substring/submissions/
    public String longestPalindrome(String s) {
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        int start = 0;
        int end = 0;
        for (int g = 0; g < dp.length; g++) {
            for (int i = 0, j = g; j < dp[0].length; j++, i++) {
                if (g == 0) {
                    dp[i][j] = true;
                } else if (g == 1) {
                    char ch1 = s.charAt(i);
                    char ch2 = s.charAt(j);
                    dp[i][j] = ch1 == ch2 ? true : false;
                } else {
                    char ch1 = s.charAt(i);
                    char ch2 = s.charAt(j);
                    dp[i][j] = ch1 == ch2 ? dp[i + 1][j - 1] : false;
                }

                if (dp[i][j]) {
                    start = i;
                    end = j;
                }
            }
        }
        return s.substring(start, end + 1);
    }
}
