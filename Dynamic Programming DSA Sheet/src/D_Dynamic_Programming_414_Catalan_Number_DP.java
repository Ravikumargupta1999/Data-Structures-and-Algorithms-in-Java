import java.math.BigInteger;

// https://www.youtube.com/watch?v=eUw9A1wsFg8
public class D_Dynamic_Programming_414_Catalan_Number_DP {

    public static int getCatalan(int n) {
        long dp[] = new long[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            int l = 0, r = i - 1;
            while (l <= i - 1) {
                dp[i] = (dp[i] + (dp[l] * dp[r])) % 1000000007;
                l++;
                r--;
            }
        }
        return (int) dp[n] % 1000000007;
    }

    // https://practice.geeksforgeeks.org/problems/nth-catalan-number0817/0?category%5B%5D=Dynamic%20Programming&difficulty%5B%5D=0&page=1&query=category%5B%5DDynamic%20Programmingdifficulty%5B%5D0page1
    public static BigInteger findCatalan(int n) {
        BigInteger[] dp = new BigInteger[n + 1];
        dp[0] = new BigInteger("1");
        dp[1] = new BigInteger("1");
        for (int i = 2; i < dp.length; i++) {
            for (int j = 0; j < i; j++) {
                BigInteger a = dp[j].multiply(dp[i - j - 1]);
                if (dp[i] == null)
                    dp[i] = a;
                else {
                    BigInteger b = dp[i].add(a);
                    dp[i] = b;
                }
            }
        }
        return dp[n];
    }
}
