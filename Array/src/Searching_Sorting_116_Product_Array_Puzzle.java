

public class Searching_Sorting_116_Product_Array_Puzzle {
    // https://practice.geeksforgeeks.org/problems/product-array-puzzle4525/1
    public static long[] productPuzzle(int[] arr, int n) {
        long[] result = new long[n];
        long[] right = new long[n];
        right[arr.length - 1] = arr[arr.length - 1];
        for (int i = arr.length - 2; i >= 0; i--) {
            right[i] = right[i + 1] * arr[i];
        }
        long left = 1;
        for (int i = 0; i < arr.length - 1; i++) {
            result[i] = left * right[i + 1];
            left *= arr[i];
        }
        result[arr.length - 1] = left;
        return result;
    }

    public static void main(String[] args) {
        int[] arr = {};
        long[] arr1 = productPuzzle(arr, arr.length);
    }
}
