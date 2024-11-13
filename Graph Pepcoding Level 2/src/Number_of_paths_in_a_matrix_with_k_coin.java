public class Number_of_paths_in_a_matrix_with_k_coin {
    long[][][] dp = new long[101][101][101];
// https://practice.geeksforgeeks.org/problems/number-of-paths-in-a-matrix-with-k-coins2728/1/?company[]=Amazon&company[]=Amazon&difficulty[]=1&page=11&query=company[]Amazondifficulty[]1page11company[]Amazon#
    long func(int n, int i, int j, int k, int[][] arr) {
        if (k < 0)
            return 0;

        if (i > n || j > n) {
            return 0;
        }

        if (dp[i][j][k] != -1) {
            return dp[i][j][k];
        }
        if (i == n && j == n) {
            if (k == arr[i][j]) {
                return 1;
            }
            return 0;
        }
        return dp[i][j][k] = func(n, i + 1, j, k - arr[i][j], arr) + func(n, i, j + 1, k - arr[i][j], arr);
    }
    long numberOfPath(int n, int K, int[][] arr) {
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp.length; j++) {
                for (int k = 0; k < dp.length; k++) {
                    dp[i][j][k] = -1;
                }
            }
        }
        return func(n - 1, 0, 0, K, arr);
    }
}
