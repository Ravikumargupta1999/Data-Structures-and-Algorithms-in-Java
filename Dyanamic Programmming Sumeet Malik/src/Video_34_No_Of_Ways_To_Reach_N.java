public class Video_34_No_Of_Ways_To_Reach_N {
    public int countWays(int arr[], int m, int n) {
        int[] dp = new int[n + 1];
        int p = 1000000007;

        dp[0] = 1;

        for (int step = 1; step <= n; step++) {

            for (int temp : arr) {
                if (temp <= step) {
                    int rstep = step - temp;
                    int val = (dp[rstep] % p);
                    dp[step] = (dp[step] % p + val % p) % p;
                }
            }
        }

        return dp[n];
    }


}
