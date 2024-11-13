public class D_Dynamic_Programming_434_Largest_Square_Formed_In_A_Matrix {
    // https://practice.geeksforgeeks.org/problems/largest-square-formed-in-a-matrix0806/1
    // https://www.youtube.com/watch?v=UagRoA3C5VQ
    static int maxSquare(int n, int m, int matrix[][]) {
        int max = 0;
        int[][] dp = new int[n][m];
        for (int i = dp.length - 1; i >= 0; i--) {
            for (int j = dp[0].length - 1; j >= 0; j--) {
                if (matrix[i][j] == 0)
                    continue;
                if (i == n - 1 || j == m - 1) {
                    dp[i][j] = matrix[i][j];
                } else {
                    int right = dp[i][j + 1];
                    int diagonal = dp[i + 1][j + 1];
                    int bottom = dp[i + 1][j];

                    int min = Math.min(right, diagonal);
                    min = Math.min(min, bottom);

                    dp[i][j] = min + 1;
                }

                max = Math.max(max, dp[i][j]);
            }
        }
        return max;
    }

    // https://practice.geeksforgeeks.org/problems/largest-square-in-a-binary-matrix-with-at-most-k-1s-for-multiple-queries/1/

}
