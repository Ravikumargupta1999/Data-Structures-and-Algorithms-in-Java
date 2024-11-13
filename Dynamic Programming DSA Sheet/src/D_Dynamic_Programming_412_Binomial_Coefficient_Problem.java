public class D_Dynamic_Programming_412_Binomial_Coefficient_Problem {
    // https://practice.geeksforgeeks.org/problems/ncr1019/1#
    // https://www.youtube.com/watch?v=WP6qUluheoc
    static int nCr(int n, int r) {
        int p = 1000000007;
        if (n < r)
            return 0;
        if (n == r)
            return 1;
        int[][] dp = new int[n + 1][n + 1];
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j <= i; j++) {
                if (j == 0 || i == j) {
                    dp[i][j] = 1;
                } else {
                    dp[i][j] = (dp[i - 1][j] % p + dp[i - 1][j - 1] % p) % p;
                }
            }
        }

        return dp[n][r];
    }

    public static void main(String[] args) {
        System.out.println(nCr(10, 8));
    }
}
// 58460583
// 58460583