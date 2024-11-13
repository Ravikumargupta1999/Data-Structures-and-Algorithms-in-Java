public class Video_11_Perfect_Squares_Dynamic_Programming {
    // https://leetcode.com/problems/perfect-squares/
//    https://practice.geeksforgeeks.org/problems/get-minimum-squares0538/1
    public int numSquares(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        if (n < 2)
            return n;
        for (int i = 2; i <= n; i++) {
            int min = Integer.MAX_VALUE;
            for (int j = 1; j * j <= i; j++) {
                min = Math.min(dp[i - (j * j)], min);
            }
            dp[i] = min + 1;
        }
        return dp[n];
    }
}
