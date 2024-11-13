package Time_And_Space_Complexity;

import java.util.Arrays;
import java.util.Scanner;

public class Merge_Two_Sorted_Array {
    public static int[] mergeTwoSortedArrays(int[] arr1, int[] arr2) {
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
            System.out.print(arr[i]+"  ");
        }
        System.out.print("\n\n\n");
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scn.nextInt();
        }
        int m = scn.nextInt();
        int[] b = new int[m];
        for (int i = 0; i < m; i++) {
            b[i] = scn.nextInt();
        }
        int[] mergedArray = mergeTwoSortedArrays(a, b);
        print(mergedArray);
    }
}
