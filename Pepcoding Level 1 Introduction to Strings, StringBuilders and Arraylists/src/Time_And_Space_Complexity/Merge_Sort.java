package Time_And_Space_Complexity;

import java.util.Scanner;

public class Merge_Sort {
    public static int[] mergeSort(int[] arr, int lo, int hi) {
        if (lo == hi)
            return new int[]{arr[lo]};
        int mid = lo + (hi - lo) / 2;
        int[] left = mergeSort(arr, lo, mid);
        int[] right = mergeSort(arr, mid + 1, hi);
        int[] res = mergeTwoSortedArrays(left, right);
        return res;
    }

    public static int[] mergeTwoSortedArrays(int[] arr1, int[] arr2) {
        System.out.println("Merging these two arrays ");
        System.out.print("left array -> ");
        print(arr1);
        System.out.print("right array -> ");
        print(arr2);
        System.out.print("\n\n");
        int[] arr = new int[arr1.length + arr2.length];
        int i = 0;
        int j = 0;
        int k = 0;
        while (i < arr1.length && j < arr2.length) {
            if (arr1[i] < arr2[j]) {
                arr[k++] = arr1[i++];
            } else {
                arr[k++] = arr2[j++];
            }
        }
        while (i < arr1.length) {
            arr[k++] = arr1[i++];
        }
        while (j < arr2.length) {
            arr[k++] = arr2[j++];
        }
        return arr;
    }


    public static void print(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scn.nextInt();
        }
        int[] sa = mergeSort(arr, 0, arr.length - 1);
        System.out.print("Sorted Array -> ");
        print(sa);
    }


}
