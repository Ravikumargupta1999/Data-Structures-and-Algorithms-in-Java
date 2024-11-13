public class String_86_Longest_Common_Subsequence {
    // https://practice.geeksforgeeks.org/problems/longest-common-subsequence-1587115620/1
    // https://www.youtube.com/watch?v=0Ql40Llp09E&t=75s
    static int lcs(int x, int y, String s1, String s2) {
        int[][] dp = new int[s1.length() + 1][s2.length() + 1];
        for (int i = s1.length() - 1; i >= 0; i--) {
            for (int j = s2.length() - 1; j >= 0; j--) {
                char ch1 = s1.charAt(i);
                char ch2 = s2.charAt(j);
                if (ch1 == ch2)
                    dp[i][j] = 1 + dp[i + 1][j + 1];
                else
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j + 1]);
            }
        }
        return dp[0][0];
    }

    // Space Optimized Solution
    // TC : O(n^2)
    // SC : O(n)
    static int lcs1(int x, int y, String s1, String s2) {
        int[][] dp = new int[s1.length() + 1][s2.length() + 1];
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
        return Math.max(dp[0][0],dp[1][0]);
    }

}
