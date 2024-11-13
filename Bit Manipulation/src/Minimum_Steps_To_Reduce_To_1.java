public class Minimum_Steps_To_Reduce_To_1 {
    public int minSteps(int n)
    {
        int[] dp = new int[n + 1];

        dp[1] = 0;

        for (int i = 2; i <= n; i++) {
            int min = dp[i - 1];

            if (i % 2 == 0) {
                min = Math.min(min, dp[i / 2]);
            }
            if (i % 3 == 0) {
                min = Math.min(min, dp[i / 3]);
            }
            dp[i] = min + 1;
        }

        return dp[n];
    }
    public static void main(String[] args) {

    }
}
