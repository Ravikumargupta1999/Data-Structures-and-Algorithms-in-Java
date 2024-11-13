public class D_Dynamic_Programming_419_Goldmine_Problem {
    // https://practice.geeksforgeeks.org/problems/gold-mine-problem2608/1/#
    // https://www.youtube.com/watch?v=hs0lilfJ7C0
    static int maxGold(int n, int m, int arr[][]) {
        if (n == 1 && m == 1) {
            return arr[0][0];
        } else if (n == 1) {
            int sum = 0;
            for (int i = 0; i < m; i++) {
                sum += arr[0][i];
            }
            return sum;
        } else if (m == 1) {
            int sum = Integer.MIN_VALUE;
            for (int i = 0; i < n; i++) {
                sum = Math.max(sum, arr[i][0]);
            }
            return sum;
        }

        int[][] dp = new int[n][m];

        // wrong traversal
//        for (int i = dp.length - 1; i >= 0; i--) {
//
//            for (int j = dp[0].length - 1; j >= 0; j--) {
        for (int j = arr[0].length - 1; j >= 0; j--) {

            for (int i = arr.length - 1; i >= 0; i--) {
                if (j == arr[0].length - 1) {
                    dp[i][j] = arr[i][j];
                } else if (i == 0) {
                    int val1 = dp[i][j + 1];
                    int val2 = dp[i + 1][j + 1];
                    dp[i][j] = arr[i][j] + Math.max(val1, val2);
                } else if (i == n - 1) {
                    int val1 = dp[i][j + 1];
                    int val2 = dp[i - 1][j + 1];
                    dp[i][j] = arr[i][j] + Math.max(val1, val2);
                } else {
                    int val1 = dp[i - 1][j + 1];
                    int val2 = dp[i][j + 1];
                    int val3 = dp[i + 1][j + 1];
                    dp[i][j] = arr[i][j] + Math.max(val1, Math.max(val2, val3));
                }
            }
        }

        int result = dp[0][0];
        for (int i = 0; i < n; i++) {
            result = Math.max(result, dp[i][0]);
        }
        return result;
    }
}
