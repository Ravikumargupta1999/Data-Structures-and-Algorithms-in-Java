import java.util.Arrays;


public class Array20_Next_Permutation {
    public static void main(String[] args) {
        int[] arr = {6,5,1,2,4,7};
        NextPermutation(arr);
        System.out.println(Arrays.toString(arr));
    }
    // https://practice.geeksforgeeks.org/problems/next-permutation5226/1
    // https://leetcode.com/problems/next-permutation/
    // https://www.youtube.com/watch?v=LuLCLgMElus&t=433s
    public static void NextPermutation(int[] arr) {
        int i = arr.length - 2;
        while (i >= 0 && arr[i] >= arr[i + 1]) {
            i--;
        }
        if (i >= 0) {
            int j = arr.length - 1;
            while (arr[j] <= arr[i])
                j--;
            swap(arr, i, j);
        }
        reverse(arr, i + 1, arr.length - 1);

    }

    static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    static void reverse(int[] arr, int i, int j) {
        while (i < j)
            swap(arr, i++, j--);

    }
}
