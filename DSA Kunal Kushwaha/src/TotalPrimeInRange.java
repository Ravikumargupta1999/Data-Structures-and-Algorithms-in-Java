public class TotalPrimeInRange {
    public static void main(String[] args) {
        System.out.println("Total Prime : "+totalPrime(283));
    }

    public static int totalPrime(int n) {
        int count = 0;
        for (int i = 1; i <= n; i++) {
            if (checkPrime(i)) {
                count++;
                System.out.println(i + "  : Prime");
            }
            else
                System.out.println(i + "  : Not Prime");
        }
        return count;
    }

    public static boolean checkPrime(int n) {
        if (n == 1)
            return false;
        int c = 2;
        while (c * c <= n) {
            if (n % c == 0)
                return false;
            c++;
        }
        return true;
    }
}
