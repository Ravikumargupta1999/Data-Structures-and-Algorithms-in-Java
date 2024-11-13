import java.util.Scanner;

public class Fibonacci {
    public static int fibonacciSeries(int n) {
        if (n == 1)
            return 0;
        if (n == 2)
            return 1;
        int value2 = fibonacciSeries(n - 1);
        int value1 = fibonacciSeries(n - 2);
        return value1 + value2;
    }

    public static void printFibSeries(int n) {
        System.out.print(0 + " ");
        if (n == 1)
            return;
        System.out.print(1 + " ");
        if (n == 2)
            return;
        int f1 = 0;
        int f2 = 1;
        for (int i = 3; i <= n; i++) {
            System.out.print((f1 + f2) + " ");
            int temp = f1;
            f1 = f2;
            f2 = f2 + temp;
        }
        System.out.print("\n");

    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println(fibonacciSeries(s.nextInt()));
        printFibSeries(s.nextInt());
    }
}
