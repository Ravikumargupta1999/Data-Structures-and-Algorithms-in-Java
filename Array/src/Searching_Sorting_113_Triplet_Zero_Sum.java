import java.util.Arrays;

public class Searching_Sorting_113_Triplet_Zero_Sum {
    // https://practice.geeksforgeeks.org/problems/find-triplets-with-zero-sum/1#
    public boolean findTriplets(int arr[], int n) {
        Arrays.sort(arr);
        for (int i = 0; i < n; i++) {
            if (isPair(arr, i + 1, n - 1, - arr[i]))
                return true;
        }
        return false;
    }

    boolean isPair(int[] arr, int low, int high, int x) {
        while (low < high) {
            if ((arr[low] + arr[high]) < x)
                low++;
            else if ((arr[low] + arr[high]) > x)
                high--;
            else
                return true;
        }
        return false;
    }

    public static boolean threeSum(int[] arr) {
        Arrays.sort(arr);
        boolean count = false;
        for (int i = 0; i < arr.length - 2; i++) {

            int j = i + 1;
            int k = arr.length - 1;
            while (j < k) {
                if (arr[(int) i] + arr[(int) j] + arr[(int) k] > 0)
                    k--;
                else if (arr[(int) i] + arr[(int) j] + arr[(int) k] < 0) {

                    j++;
                } else {
                    count = true;
                    break;
                }
            }
        }
        return count;
    }

}
