//https://practice.geeksforgeeks.org/problems/reach-the-nth-point5433/1
public class Video_23_Reach_the_Nth_Point {
    public static int nthPoint(int n) {
        int p = 1000000007;
        int[] dp = new int[n + 1];
        dp[0] = 1;
        for (int i = 1; i <= n; i++) {
            if (i == 1)
                dp[i] = dp[i - 1] % p;
            else
                dp[i] = (dp[i - 1] % p + dp[i - 2] % p) % p;
        }
        return dp[n];
    }

    public static void main(String[] args) {
        System.out.println(nthPoint(4));
    }
}
