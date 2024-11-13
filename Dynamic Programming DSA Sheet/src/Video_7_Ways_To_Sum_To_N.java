public class Video_7_Ways_To_Sum_To_N {
    // https://practice.geeksforgeeks.org/problems/ways-to-sum-to-n5759/1?page=4&company[]=Amazon&category[]=Dynamic%20Programming&sortBy=submissions

    public int countWays(int arr[], int m, int n) {
        int mod = 1000000007;
        int[] dp = new int[n + 1];
        dp[0] = 1;
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < m; j++) {
                int val = arr[j];

                if (val <= i) {
                    dp[i] = ((dp[i] % mod) + (dp[i - val] % mod)) % mod;
                }
            }
        }
        return dp[n] % mod;
    }
}
