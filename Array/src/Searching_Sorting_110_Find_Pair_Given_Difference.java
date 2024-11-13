
import java.util.Arrays;

public class Searching_Sorting_110_Find_Pair_Given_Difference {
  // https://www.youtube.com/watch?v=XGrXiVi7Ces&t=249s
    public static boolean PairDifference(int[] arr, int n, int k) {
        Arrays.sort(arr);
        int i = 0;
        int j = 1;
        while (i < n && j < n) {
            if (arr[j] - arr[i] == k)
                return true;
            else if (arr[j] - arr[i] < k)
                j++;
            else
                i++;

        }
        return false;
    }
    // https://practice.geeksforgeeks.org/problems/find-pair-given-difference1559/1
    public boolean findPair(int[] arr, int n, int k) {
        Arrays.sort(arr);
        for (int i = 0; i < arr.length; i++) {
            int y = arr[i] + k;
            int low = 0;
            int high = arr.length - 1;
            while (low <= high) {
                int mid = (low + high) / 2;
                if (arr[mid] == y)
                    return true;
                else if (arr[mid] >= y)
                    high = mid - 1;
                else
                    low = mid + 1;
            }

        }
        return false;
    }
}
