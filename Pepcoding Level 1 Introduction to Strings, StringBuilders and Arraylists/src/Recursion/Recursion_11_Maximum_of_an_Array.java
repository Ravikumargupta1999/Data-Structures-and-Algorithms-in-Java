package Recursion;

public class Recursion_11_Maximum_of_an_Array {
    public static void main(String[] args) {
        int[] arr = {57, 77, 22, 45, 89, 90};
        System.out.println(maximumElement(arr, 0));
    }

    public static int maximumElement(int[] arr, int idx) {
        if (idx == arr.length - 1) {
            return arr[idx];
        }
        return Math.min(arr[idx], maximumElement(arr, idx + 1));
    }
}
