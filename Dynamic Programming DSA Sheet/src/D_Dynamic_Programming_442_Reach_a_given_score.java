public class D_Dynamic_Programming_442_Reach_a_given_score {
    // https://practice.geeksforgeeks.org/problems/reach-a-given-score-1587115621/1#
    public long count(int n) {
        long[] longArray = {3, 5, 10};
        long[] dp = new long[(int) n + 1];
        dp[0] = 1;
        for (long i = 0; i < longArray.length; i++) {
            for (long j = longArray[(int) i]; j < dp.length; j++) {
                dp[(int) j] += dp[(int) (j - longArray[(int) i])];
            }
        }
        return dp[(int) n];
    }
}
