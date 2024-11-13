import java.util.Arrays;

public class Searching_Sorting_114_Merged_Two_Sorted_Array {
    // https://practice.geeksforgeeks.org/problems/merge-two-sorted-arrays5135/1
    public static void Merge(int[] arr1, int[] arr2, int n, int m) {
        int i = n - 1;
        int j = 0;
        while (i >= 0 && j < m) {
            if (arr1[i] >= arr2[j]) {
                int temp = arr2[j];
                arr2[j] = arr1[i];
                arr1[i] = temp;
                i--;
                j++;
            } else
                break;
        }
        Arrays.sort(arr1);
        Arrays.sort(arr2);
    }
}
