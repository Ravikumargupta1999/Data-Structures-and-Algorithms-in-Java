//https://practice.geeksforgeeks.org/problems/nth-fibonacci-number1335/1
public class Video_1_Fibonacci_GFG {
    static long nthFibonacci(long n) {
        long[] dp = new long[(int) n + 1];
        long p = 1000000007;
        dp[0] = 0;
        dp[1] = 1;
        for (long i = 2; i < n + 1; i++) {
            long a = dp[(int) i - 1] % p;
            long b = dp[(int) i - 2] % p;
            long c = (a + b) % p;
            dp[(int) i] = c % p;
        }
        return dp[(int) n];
    }

    public static void main(String[] args) {
        System.out.println(nthFibonacci(1000));
    }
}
