import java.math.BigInteger;

public class Video_12_Catalan_Numbers {
    //Function to find the nth catalan number.
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
