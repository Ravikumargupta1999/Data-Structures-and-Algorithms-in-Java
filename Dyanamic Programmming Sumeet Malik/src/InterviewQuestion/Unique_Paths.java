package InterviewQuestion;

public class Unique_Paths {
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m + 1][n + 1];
        for (int i = m; i >= 1; i--) {
            for (int j = n; j >= 1; j--) {
                if (i == m && j == n) {
                    dp[i][j] = 1;
                } else if (i == m) {
                    dp[i][j] = dp[i][j + 1];
                } else if (j == n) {
                    dp[i][j] = dp[i + 1][j];
                } else {
                    dp[i][j] = dp[i][j + 1] + dp[i + 1][j];
                }
            }
        }
        return dp[1][1];
    }
}
