public class Reverse_Integer {
    public static int reverse(int n) {
        boolean negative = false;
        if (n < 0) {
            negative = true;
            n *= (-1);
        }
        long reverse = 0;
        while (n > 0) {
            reverse = (reverse * 10) + (n % 10);
            n /= 10;
        }
        if (reverse > Integer.MAX_VALUE)
            return 0;
        return negative ? (int) (-1 * reverse) : (int) reverse;

    }

    public static void main(String[] args) {
        System.out.println(reverse(-123));
    }
}
