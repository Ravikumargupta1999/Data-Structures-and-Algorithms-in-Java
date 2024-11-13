public class D_Dynamic_Programming_436_Min_Cost_Path_Sum {

    // https://practice.geeksforgeeks.org/problems/path-in-matrix3805/1
    public static int maximumPath(int[][] mat, int n) {

        int[][] dp = new int[n][n];

        if (n == 1)
            return mat[0][0];

        for (int i = n - 1; i >= 0; i--) {
            for (int j = 0; j < n; j++) {

                if (i == n - 1) {
                    dp[i][j] = mat[i][j];
                } else if (j == 0) {
                    int m1 = dp[i + 1][j];
                    int m2 = dp[i + 1][j + 1];

                    dp[i][j] = mat[i][j] + Math.max(m1, m2);
                } else if (j == n - 1) {
                    int m1 = dp[i + 1][j];
                    int m2 = dp[i + 1][j - 1];

                    dp[i][j] = mat[i][j] + Math.max(m1, m2);
                } else {
                    int m1 = dp[i + 1][j];
                    int m2 = dp[i + 1][j + 1];
                    int m3 = dp[i + 1][j - 1];


                    dp[i][j] = mat[i][j] + Math.max(m1, Math.max(m2, m3));
                }
            }
        }
        int res = 0;
        for (int j = 0; j < n; j++) {
            res = Math.max(res, dp[0][j]);
        }
        return res;
    }
}
