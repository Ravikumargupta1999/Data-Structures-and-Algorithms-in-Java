package Day_25_Dynamic_Programming;

public class Matrix_Chain_Multiplication {
    static int matrixMultiplication(int n, int arr[]) {
        int[][] dp = new int[n - 1][n - 1];
        for (int g = 0; g < dp.length; g++) {
            for (int i = 0, j = g; j < dp.length; i++, j++) {
                if (g == 0)
                    dp[i][j] = 0;
                else if (g == 1) {
                    // dp[i][j] = arr[i] * arr[j] * arr[j + 1];
                    dp[i][j] = arr[i] * arr[i + 1] * arr[i + 2];
                } else {
                    int min = Integer.MAX_VALUE;
                    for (int k = i; k < j; k++) {
                        int lc = dp[i][k];
                        int rc = dp[k + 1][j];
                        int mc = arr[i] * arr[k + 1] * arr[j + 1];
                        // int mc = arr[i] * arr[j] * arr[j + 1]; // bawal macha doge
                        int tc = lc + rc + mc;
                        min = Math.min(min, tc);
                    }
                    dp[i][j] = min;
                }

            }
        }
        return dp[0][dp.length - 1];
    }
}
