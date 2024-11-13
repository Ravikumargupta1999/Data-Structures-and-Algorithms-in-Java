package Day_2_Arrays;

import java.util.Arrays;

public class Merge_Sorted_Array {
    // https://leetcode.com/problems/merge-sorted-array/submissions/
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1;
        int j = 0;

        while (i >= 0 && j < n) {
            if (nums1[i] >= nums2[j]) {
                int temp = nums1[i];
                nums1[i] = nums2[j];
                nums2[j] = temp;
                i--;
                j++;
            } else {
                break;
            }
        }

        Arrays.sort(nums1);
        Arrays.sort(nums2);

        for (j = m, i = 0; j < (m + n) && i < n; j++, i++) {
            nums1[j] = nums2[i];
        }
    }

    // https://www.codingninjas.com/codestudio/problems/1214628?topList=striver-sde-sheet-problems&utm_source=striver&utm_medium=website&leftPanelTab=1
    public static int[] ninjaAndSortedArrays(int arr1[], int arr2[], int n, int m) {
        int[] res = new int[m + n];

        int i = 0;
        int j = 0;
        int k = 0;
        while (i < n && j < m) {
            if (arr1[i] < arr2[j]) {
                res[k++] = arr1[i++];

            } else {
                res[k++] = arr2[j++];
            }
        }
        while (i < n) {
            res[k++] = arr1[i++];

        }
        while (j < m) {
            res[k++] = arr2[j++];

        }
        return res;
    }
}
