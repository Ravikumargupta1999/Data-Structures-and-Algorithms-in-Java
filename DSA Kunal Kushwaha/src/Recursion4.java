public class Recursion4 {
    public static void main(String[] args) {
        System.out.println(factorial(16));
    }

    public static long factorial(int n) {
        if (n == 1)
            return 1;
        return n + factorial(n - 1);
    }
}
