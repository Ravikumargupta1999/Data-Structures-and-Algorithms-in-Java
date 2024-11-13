package CodeChef;

// https://leetcode.com/problems/maximal-square/
public class Maximal_Square {
    public int maximalSquare(char[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        int[][] dp = new int[n][m];
        int max = 0;

        for (int i = n - 1; i >= 0; i--) {

            for (int j = m - 1; j >= 0; j--) {
                int res = 0;
                if (i == n - 1 || j == m - 1) {
                    res = matrix[i][j] == '1' ? 1 : 0;
                } else {
                    if (matrix[i][j] == '1') {
                        int a = dp[i + 1][j];
                        int b = dp[i + 1][j + 1];
                        int c = dp[i][j + 1];
                        res = 1 + Math.min(a,Math.min(b,c));
                    }
                }
                dp[i][j] = res;
                max = Math.max(max,res);
            }
        }
        return max*max;
    }
}
