public class Recursion10 {
    public static void main(String[] args) {
        System.out.println(countZeros(6783, 0));
    }

    static int countZeros(int n, int count) {
        if (n == 0)
            return count;
        if (n % 10 == 0) {
            return countZeros(n / 10, count + 1);
        } else
            return countZeros(n / 10, count);
    }
}
