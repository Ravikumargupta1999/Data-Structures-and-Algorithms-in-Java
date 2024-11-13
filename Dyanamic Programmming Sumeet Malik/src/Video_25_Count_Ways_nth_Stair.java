public class Video_25_Count_Ways_nth_Stair {
    public static long nthStair(int n) {
        int p = 1000000007;
        int[] dp = new int[n + 1];
        dp[0] = 1;
        for (int i = 1; i <= n; i++) {
            if (i == 1) dp[i] = dp[i - 1] % p;
            else dp[i] = (dp[i - 1] % p + dp[i - 2] % p) % p;
        }
        return dp[n];


    }


    public static void main(String[] args) {
        System.out.println(nthStair(4));
    }
}
