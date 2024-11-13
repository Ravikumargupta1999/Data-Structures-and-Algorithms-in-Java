import java.util.Scanner;

public class Video_1_Fibonacci {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int fibSuum = fib(n);
        System.out.println("Sum of  " + n + " fibonacci series : " + fibSuum + " .");
    }

    public static int fib(int n) {
        if (n == 0 || n == 1)
            return n;
        //System.out.println(" Hello "+n);
        return fib(n - 1) + fib(n - 2);
    }
}
