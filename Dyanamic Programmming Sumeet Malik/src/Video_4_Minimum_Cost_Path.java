//https://leetcode.com/problems/minimum-path-sum/submissions/
public class Video_4_Minimum_Cost_Path {
    public int minPathSum(int[][] grid) {
        int[][] dp = new int[grid.length][grid[0].length];
        for (int i = grid.length - 1; i >= 0; i--) {
            for (int j = grid[0].length - 1; j >= 0; j--) {
                if (i == grid.length - 1 && j == grid[0].length - 1)
                    dp[i][j] = grid[i][j];
                else if (i == grid.length - 1)
                    dp[i][j] = grid[i][j] + dp[i][j + 1];
                else if (j == grid[0].length - 1)
                    dp[i][j] = grid[i][j] + dp[i + 1][j];
                else
                    dp[i][j] = Math.min(grid[i][j] + dp[i + 1][j], grid[i][j] + dp[i][j + 1]);
            }
        }
        return dp[0][0];
    }
}
