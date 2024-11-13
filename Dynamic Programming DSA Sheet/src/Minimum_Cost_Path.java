public class Minimum_Cost_Path {
    public int minimumCostPath(int[][] arr) {
        int[][] dp = new int[arr.length][arr[0].length];
        for (int i = arr.length - 1; i >= 0; i--) {
            for (int j = arr[0].length - 1; j >= 0; j++)
                if (i == dp.length - 1 && j == dp[0].length - 1)
                    dp[i][j] = arr[i][j];
                else if (i == dp.length - 1 && j == 0)
                    dp[i][j] = Math.min(dp[i][j + 1], dp[i - 1][j]) + arr[i][j];
                else if (i == 0 && j == dp[0].length - 1)
                    dp[i][j] = Math.min(dp[i + 1][j], dp[i][j - 1]) + arr[i][j];
                else if (i == 0 && j == 0)
                    dp[i][j] = Math.min(dp[i + 1][j], dp[i][j + 1]) + arr[i][j];
                else if (i == dp.length - 1)
                    dp[i][j] = Math.min(dp[i][j + 1], dp[i - 1][j]) + arr[i][j];
                else if (j == dp[0].length - 1)
                    dp[i][j] = Math.min(dp[i + 1][j], dp[i][j - 1]) + arr[i][j];
                else if (i == 0)
                    dp[i][j] = Math.min(dp[i][j + 1], dp[i + 1][j]) + arr[i][j];
                else if (j == 0)
                    dp[i][j] = Math.min(dp[i + 1][j], dp[i][j + 1]) + arr[i][j];
                else
                    dp[i][j] = Math.min(Math.min(dp[i + 1][j], dp[i][j + 1]), Math.min(dp[i - 1][j], dp[i][j - 1])) + arr[i][j];
        }
        return dp[0][0];
    }


}
