public class Video_24_Largest_zigzag_sequence {
    // https://practice.geeksforgeeks.org/problems/largest-zigzag-sequence5416/1
    static int zigzagSequence(int n, int mat[][]){
        int[][] dp = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0)
                    dp[i][j] = mat[i][j];
                else {
                    int max = 0;
                    for (int k = 0; k < n; k++) {
                        if (k == j)
                            continue;
                        max = Math.max(max, dp[i - 1][k]);
                    }
                    dp[i][j] = mat[i][j] + max;
                }
            }
        }

        int res = 0;
        for (int i = 0; i < n; i++)
            res = Math.max(res, dp[n - 1][i]);
        return res;
    }

}
