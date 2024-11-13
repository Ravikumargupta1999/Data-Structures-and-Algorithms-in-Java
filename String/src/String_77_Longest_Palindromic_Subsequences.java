public class String_77_Longest_Palindromic_Subsequences {
    // https://www.youtube.com/watch?v=RiNzHfoA2Lo&t=82s
    // https://practice.geeksforgeeks.org/problems/longest-palindromic-subsequence-1612327878/0/?fbclid=IwAR0j1_z07XBVRVud1cFc21M2dLQFUXz0QWrJJt4DMsEJMnc7UcJ9Af1LDao
    public int longestPalindromicSubsequence(String s) {
        int[][] dp = new int[s.length()][s.length()];
        for (int g = 0; g < s.length(); g++) {
            for (int i = 0, j = g; j < s.length(); i++, j++) {
                char ch1 = s.charAt(i);
                char ch2 = s.charAt(j);
                if (g == 0) {
                    dp[i][j] = 1;
                } else if (g == 1) {
                    dp[i][j] = ch1 == ch2 ? 2 : 1;
                } else {
                    if (ch1 == ch2) {
                        dp[i][j] = 2 + dp[i + 1][j - 1];
                    } else {
                        dp[i][j] = Math.max(dp[i][j - 1], dp[i + 1][j]);
                    }
                }
            }
        }
        return dp[0][s.length() - 1];

    }
}
