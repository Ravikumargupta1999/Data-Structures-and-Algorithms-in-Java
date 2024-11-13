package Two;

public class Ugly_Number_II {
    // https://www.youtube.com/watch?v=Lj68VJ1wu84
    // https://leetcode.com/problems/ugly-number-ii/submissions/
    public int nthUglyNumber(int n) {
        int[] dp = new int[n + 1];
        dp[1] = 1;
        int p2 = 1;
        int p3 = 1;
        int p5 = 1;
        for (int i = 2; i <= n; i++) {
            int f1 = 2 * dp[p2];
            int f2 = 3 * dp[p3];
            int f3 = 5 * dp[p5];

            int min = Math.min(f1, Math.min(f2, f3));
            dp[i] = min;
            if (min == f1) {
                p2++;
            }
            if (min == f2) {
                p3++;
            }
            if (min == f3) {
                p5++;
            }
        }
        return dp[n];
    }
}
