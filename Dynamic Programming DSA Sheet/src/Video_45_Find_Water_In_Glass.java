public class Video_45_Find_Water_In_Glass {
    // https://practice.geeksforgeeks.org/problems/champagne-overflow2636/1#
    static double waterOverflow(int k, int r, int c) {
        double[][] dp = new double[k + 1][k + 1];
        dp[0][0] = k;
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j <= i; j++) {
                if (dp[i][j] > 1.0) {
                    double spare = dp[i][j] - 1.0;
                    dp[i][j] = 1.0;
                    dp[i + 1][j] += spare / 2.0;
                    dp[i + 1][j + 1] += spare / 2.0;
                }
            }
        }
        int d = (int) dp[r-1][c-1];
        return d;
    }

    public static void main(String[] args) {
        System.out.println(waterOverflow(3, 2, 1));
    }
}
