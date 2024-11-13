public class FibonacciSum {
    public static long fibSum(long n)
    {
        if (n == 0 || n == 1)
            return n;
        long p = 1000000007;
        long value1 = fibSum(n-1)%p;
        long value2 = fibSum(n-2)%p;
        return (value1+value1)%p;
    }
    public static void main(String[] args) {
        long l = 9;
        System.out.println(fibSum(l));
    }
}
