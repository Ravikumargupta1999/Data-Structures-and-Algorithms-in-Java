import java.util.Arrays;
//Done
public class Array17_Merge_Sort {
//    Done
    // https://practice.geeksforgeeks.org/problems/merge-two-sorted-arrays-1587115620/1
    public static void merge(int[] arr1, int[] arr2, int n, int m) {
        int i = 0;
        int j = 0;
        while (i < n && j < m) {
            if (arr1[i] <= arr2[j])
                i++;
            if (arr1[i] > arr2[j]) {
                int temp = arr1[i];
                arr1[i] = arr2[j];
                arr2[j] = temp;
                i++;
                temp = j;

                while (j < m - 1) {
                    if (arr2[j] > arr2[j + 1]) {
                        int temp1 = arr2[j + 1];
                        arr2[j + 1] = arr2[j];
                        arr2[j] = temp1;
                    }
                    j++;
                }
                j = temp;
            }

        }
        for (int k = 0; k < n; k++)
            System.out.print(arr1[k] + "  ");
        System.out.println();
        for (int k = 0; k < m; k++)
            System.out.print(arr2[k] + "  ");
        System.out.println();
    }
    // Approach 2 optimized Approach
    public void merge1(int[] arr1, int[] arr2, int n, int m) {
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
