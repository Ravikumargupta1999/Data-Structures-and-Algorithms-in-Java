package Day_25_Dynamic_Programming;

public class Edit_Distance {
    // https://practice.geeksforgeeks.org/problems/edit-distance3702/1
    public int editDistance(String word1, String word2) {
        int[][] dp = new int[word1.length() + 1][word2.length() + 1];
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                if (i == 0)
                    dp[i][j] = j;
                else if (j == 0)
                    dp[i][j] = i;
                else {
                    if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                        dp[i][j] = dp[i - 1][j - 1];
                    } else {
                        int replace = dp[i - 1][j - 1];
                        int delete = dp[i - 1][j];
                        int insert = dp[i][j - 1];
                        dp[i][j] = 1 + Math.min(replace, Math.min(delete, insert));
                    }
                }
            }
        }
        return dp[dp.length - 1][dp[0].length - 1];
    }
}
