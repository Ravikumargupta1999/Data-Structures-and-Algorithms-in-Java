import java.sql.Array;
import java.util.Arrays;

public class Max_Circular_Sub_Array {
    // Approach 2
    static int circularSubArraySum(int[] arr, int n) {
        if (allNegative(arr, n)) {
            return Minimum(arr);
        }
        System.out.println("h");
        int sum = 0;
        for (int v : arr)
            sum += v;
        return sum - minimumSumSubArray(arr);
    }

    public static boolean allNegative(int[] arr, int n) {
        int negative = 0;
        for (int v : arr) {
            if (v < 0)
                negative++;
        }
        return n == negative;
    }

    public static int Minimum(int[] arr) {
        int min = Integer.MAX_VALUE;
        for (int v : arr)
            min = Math.min(min, v);
        return min;
    }

    public static int minimumSumSubArray(int[] arr) {
        int min_ending_here = 2147483647;

        // to store the minimum value encountered
        // so far
        int min_so_far = 2147483647;

        // traverse the array elements
        for (int i = 0; i < arr.length; i++) {

            // if min_ending_here > 0, then it could
            // not possibly contribute to the
            // minimum sum further
            if (min_ending_here > 0)
                min_ending_here = arr[i];

                // else add the value arr[i] to
                // min_ending_here
            else
                min_ending_here += arr[i];

            // update min_so_far
            min_so_far = Math.min(min_so_far,
                    min_ending_here);
        }

        return min_so_far;
    }
}
