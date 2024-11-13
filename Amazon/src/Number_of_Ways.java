
//https://practice.geeksforgeeks.org/problems/count-of-sum-of-consecutives3741/1

public class Number_of_Ways {
    static int getCount(int n) {
        int count = 0;
        for (int k = 1; k * (k + 1) < 2 * n; k++) {
            double f = (double) ((1.0 * n - (k * (k + 1)) / 2) / (k + 1));
            if (f - (int) f == 0.0)
                count++;
        }
        return count;
    }

    static int countConsecutive(int N) {

        int count = 0;
        for (int L = 1; L * (L + 1) < 2 * N; L++) {
            double a = (double) ((1.0 * N - (L * (L + 1)) / 2) / (L + 1));
            if (a - (int) a == 0.0)
                count++;
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(countConsecutive(24587906));
        System.out.println(getCount(24587906));
    }
}
