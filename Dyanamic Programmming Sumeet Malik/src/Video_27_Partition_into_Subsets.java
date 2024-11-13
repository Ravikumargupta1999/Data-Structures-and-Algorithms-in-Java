public class Video_27_Partition_into_Subsets {
    public static int countWays(int n, int k) {
        if (n < k)
            return 0;
        if (n == k)
            return 0;
        if (n == 0)
            return 0;

        int[][] dp = new int[k + 1][n + 1];
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                if (i == 0 || j == 0)
                    dp[i][j] = 0;
                else if (i == 1)
                    dp[i][j] = 1;
                else if (j < i)
                    dp[i][j] = 0;
                else if (i == j)
                    dp[i][j] = 1;
                else
                    dp[i][j] = i * dp[i][j - 1] + dp[i - 1][j - 1];
            }
        }
        return dp[k][n];
    }

    public static void main(String[] args) {
        int n = 5;
        int k = 2;
        System.out.println(countWays(n, k));
    }
}
