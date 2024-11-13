import java.util.Arrays;

public class Greedy_257_Minimum_sum_of_absolute_difference_of_pairs_of_two_arrays {
    // https://practice.geeksforgeeks.org/problems/minimum-sum-of-absolute-differences-of-pairs/1/
    static long findMinSum(long a[], long b[], long n) {
        // Sort both arrays
        Arrays.sort(a);
        Arrays.sort(b);

        // Find sum of absolute differences
        long sum = 0;
        for (int i = 0; i < n; i++)
            sum = sum + Math.abs(a[i] - b[i]);

        return sum;
    }

    // Driver code
    public static void main(String[] args) {
        // Both a[] and b[] must be of same size.
        long a[] = {4, 1, 8, 7};
        long b[] = {2, 3, 6, 5};
        int n = a.length;
        System.out.println(findMinSum(a, b, n));
    }
}
