import java.util.Arrays;

public class D_Dynamic_Programming_435_Maximum_sum_of_pairs_with_specific_difference {
    // https://www.youtube.com/watch?v=yDZGsjc007Y
    // https://practice.geeksforgeeks.org/problems/pairs-with-specific-difference1533/1
    public static int maxSumPairWithDifferenceLessThanK(int arr[], int n, int k) {
        Arrays.sort(arr);
        reverse(arr);
        int i = 0;
        int sum = 0;
        while (i < n - 1) {
            int temp = Math.abs(arr[i] - arr[i + 1]);
            if (temp < k) {
                sum += (arr[i] + arr[i + 1]);
                i += 2;
            } else
                i++;
        }
        return sum;
    }

    public static void reverse(int[] arr) {
        int l = 0;

        while (l < arr.length - 1 - l) {
            int temp = arr[l];
            arr[l] = arr[arr.length - 1 - l];
            arr[arr.length - 1 - l] = temp;
            l++;
        }
    }
}
