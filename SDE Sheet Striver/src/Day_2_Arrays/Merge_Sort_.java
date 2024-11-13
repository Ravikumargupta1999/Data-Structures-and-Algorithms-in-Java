package Day_2_Arrays;

import java.util.Arrays;

public class Merge_Sort_ {
    // https://practice.geeksforgeeks.org/problems/merge-sort/1
    void mergeSort(int arr[], int l, int r) {
        mergeSort_(arr, l, r);
    }

    public int[] mergeSort_(int[] arr, int start, int end) {
        if (start == end) {
            return new int[]{arr[start]};
        } else {
            int mid = (start + end) / 2;
            int[] left = mergeSort_(arr, start, mid);
            int[] right = mergeSort_(arr, mid + 1, end);
            int[] mergeArray = merge(arr, left, right, start);
            return mergeArray;
        }

    }

    public int[] merge(int[] arr, int[] left, int[] right, int st) {

        int[] temp = new int[left.length + right.length];
        int k = 0;
        int i = 0;
        int j = 0;
        while (i < left.length && j < right.length) {
            if (left[i] < right[j]) {
                temp[k++] = left[i++];
            } else {
                temp[k++] = right[j++];
            }
        }
        while (i < left.length) {
            temp[k++] = left[i++];
        }
        while (j < right.length) {
            temp[k++] = right[j++];
        }

        for (i = 0; i < temp.length; i++) {
            arr[st++] = temp[i];
        }
        return temp;
    }
}
