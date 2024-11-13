public class Video_17_Ways_of_Polygon_Triangulation {
    static long noOfWays(int n) {
        if (n < 2)
            return 0;
        n = n - 2;
        if (n < 2)
            return 1;
        long[] dp = new long[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i < dp.length; i++) {
            int l = 0;
            int r = i - 1;
            while (l <= i - 1) {

                dp[i] += dp[l] * dp[r];
                l++;
                r--;
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        System.out.println(noOfWays(10));
    }
}
