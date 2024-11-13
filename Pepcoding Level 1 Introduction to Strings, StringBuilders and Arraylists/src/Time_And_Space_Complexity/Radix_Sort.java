package Time_And_Space_Complexity;

import java.util.Scanner;

public class Radix_Sort {
    public static void radixSort(int[] arr) {
        int max = Integer.MIN_VALUE;
        for (int val : arr)
            max = Math.max(max, val);
        int exp = 1;
        while (exp <= max) {
            countSort(arr, exp);
            exp *= 10;
        }
    }

    public static void countSort(int[] arr, int exp) {

        int[] freqArray = new int[10];

        for (int i = 0; i < arr.length; i++) {
            freqArray[arr[i] / exp % 10]++;
        }
        for (int i = 1; i < freqArray.length; i++) {
            freqArray[i] = freqArray[i] + freqArray[i - 1];
        }

        int[] ans = new int[arr.length];

        for (int i = arr.length - 1; i >= 0; i--) {
            int pos = freqArray[arr[i] / exp % 10] - 1;
            ans[pos] = arr[i];
            freqArray[arr[i] / exp % 10]--;
        }
        for (int i = 0; i < arr.length; i++) {
            arr[i] = ans[i];
        }
        System.out.print("After sorting on " + exp + " place -> ");
        print(arr);
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
        radixSort(arr);
        print(arr);
    }
}
