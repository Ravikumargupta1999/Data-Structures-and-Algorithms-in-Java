package Recursion;

public class Recursion_5_Logarithmic_Power {
    // Program for power of x^n
    public static int powerOfX(int x, int n) {
        if (n == 1)
            return x;
        int val = powerOfX(x, n / 2);
        if (n % 2 == 0)
            return val * val;
        return val * val * x;
    }
    // https://practice.geeksforgeeks.org/problems/power-of-numbers-1587115620/1#
    // TC : O(log n)

    long power(int n,int x)
    {
        long val = 1000000007;
        if (x == 1) {
            return n;
        }
        long res = power(n, x / 2) %  val ;
        if (x % 2 == 0) {
            return (res*res) % val;
        }
        return ( ((res*res) % val)* (n)) % val;
    }

}
