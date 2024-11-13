import java.util.concurrent.TimeUnit;

public class Fibonacci_Recursively {
    public static int nthFibonacci(int n)
    {
        if( n < 2) {
//            System.out.println(n);
            return n;
        }
       // System.out.println(n);
        return nthFibonacci(n-2) + nthFibonacci(n-1);
    }
    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();

        /* … The code being measured starts … */

        int val = nthFibonacci(6);


        /* … The code being measured ends … */

        long endTime = System.currentTimeMillis();

        long timeElapsed = endTime - startTime;
        System.out.println(val);

        System.out.println("Execution time in seconds: " + timeElapsed/1000);
    }
}
