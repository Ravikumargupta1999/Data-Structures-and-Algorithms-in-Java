// https://practice.geeksforgeeks.org/problems/consecutive-1s-not-allowed1912/1

public class Video_7_Binary_String_With_No_Consecutive_Ones {
    static long countStrings(int n) {
        long mod = 1000000007;
        long[] dp0 = new long[n + 1];
        long[] dp1 = new long[n + 1];
        dp0[1] = 1;
        dp1[1] = 1;
        long p = 1000000007;
        for (int i = 2; i <= n; i++) {

            dp1[i] = (dp0[i - 1] % mod + dp1[i - 1] % mod) % mod;
            dp0[i] = (dp1[i - 1]) % mod;
        }
        return (dp0[n] % mod + dp1[n] % mod) % mod;
    }

    // without extra space
    // https://practice.geeksforgeeks.org/problems/consecutive-1s-not-allowed1912/1
    // expected
    static long function1(int n) {
        long p = 1000000007;
        long zeroend = 1;
        long oneend = 1;
        long summ = zeroend + oneend;
        if (n == 1)
            return summ;
        int i = 2;
        while (i <= n) {

            oneend = zeroend % p;
            zeroend = summ % p;
            summ = zeroend + oneend % p;
            i++;
        }
        System.out.println(summ * summ);
        return summ % p;
    }

    static int fun(int n) {
        int a[] = new int[n];
        int b[] = new int[n];
        a[0] = b[0] = 1;
        for (int i = 1; i < n; i++) {
            a[i] = a[i - 1] + b[i - 1];
            b[i] = a[i - 1];
        }
        return a[n - 1] + b[n - 1];
    }

    public static void main(String[] args) {
        System.out.println(countStrings(43));
    }
}
