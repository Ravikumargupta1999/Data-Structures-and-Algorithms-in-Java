public class Prime_Number_Recursion {
    static boolean isPrime(int n) {
        if (n == 0 || n == 1)
            return false;
        return checkPrime(n, 2);
    }

    static boolean checkPrime(int n, int c) {
        if (c * c > n)
            return true;
        if (n % c == 0)
            return false;
        return checkPrime(n, c + 1);
    }

    public static void main(String[] args) {
        System.out.println(isPrime(173));
    }
}
