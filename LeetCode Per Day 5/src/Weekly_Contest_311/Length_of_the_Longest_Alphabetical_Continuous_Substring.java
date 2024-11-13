package Weekly_Contest_311;

public class Length_of_the_Longest_Alphabetical_Continuous_Substring {
    public int longestContinuousSubstring(String s) {
        String s1 = "abcdefghijklmnopqrstuvwxyz";
        return longestCommonSubstr(s,s1,s.length(),s1.length());
    }
    int longestCommonSubstr(String S1, String S2, int m, int n){
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
