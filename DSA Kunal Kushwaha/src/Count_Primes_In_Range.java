import java.util.Arrays;

public class Count_Primes_In_Range {
    public static void main(String[] args) {
        System.out.println(countPrimes(1, 10));
    }
//https://practice.geeksforgeeks.org/problems/count-primes-in-range1604/1#
    static int countPrimes(int l, int r) {
        boolean[] arr = new boolean[r + 1];
        int count = 0;
        for (int i = 2; i <= r; i++) {
            if (!arr[i]) {
                for (int j = i * 2; j <= r; j += i)
                    arr[j] = true;
            }
        }
        if (l < 2) {
            for (int j = 2; j <= r; j++) {
                if (!arr[j])
                    count++;
            }
        } else {
            for (int j = 2; j <= r; j++) {
                if (!arr[j])
                    count++;
            }
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
