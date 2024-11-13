public class String_86_Longest_Common_Substring {
    // https://www.youtube.com/watch?v=NvmJBCn4eQI
    // https://practice.geeksforgeeks.org/problems/longest-common-substring1452/1
    public static int longestCommonSubstring(String S1, String S2, int m, int n) {
        int[][] dp = new int[m + 1][n + 1];
        int max = 0;
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                char c1 = S1.charAt(i - 1);
                char c2 = S2.charAt(j - 1);
                if (c1 != c2)
                    dp[i][j] = 0;
                else
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                if (max < dp[i][j])
                    max = dp[i][j];
            }
        }
        return max;
    }
}
