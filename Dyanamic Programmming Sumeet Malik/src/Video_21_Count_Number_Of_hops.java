//https://practice.geeksforgeeks.org/problems/count-number-of-hops-1587115620/1/?category[]=Dynamic%20Programming&category[]=Dynamic%20Programming&difficulty[]=0&page=1&query=category[]Dynamic%20Programmingdifficulty[]0page1category[]Dynamic%20Programming
public class Video_21_Count_Number_Of_hops {
    static long countWays(int n) {
        long mod = 1000000007;
        long[] dp = new long[n + 1];
        dp[0] = 1;
        for (int i = 1; i <= n; i++) {
            if (i == 1)
                dp[i] = dp[i - 1] % mod;
            else if (i == 2)
                dp[i] = (dp[i - 1] % mod) + (dp[i - 2] % mod);
            else
                dp[i] = (dp[i - 1] % mod + dp[i - 2] % mod + dp[i - 3] % mod) % mod;

        }

        return dp[n] % mod;
    }

    static long countWays1(int n) {

        long one = 1;
        if (n == 1)
            return one;
        long two = 2;
        if (n == 2)
            return two;
        long three = 4;
        if (n == 3)
            return three;
        long p = 1000000007;

        long result = one + two + three;
        for (int i = 4; i <= n; i++) {

            result = (one % p + two % p + three % p) % p;
            one = two;
            two = three;
            three = result;
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(countWays(7));
    }
}
