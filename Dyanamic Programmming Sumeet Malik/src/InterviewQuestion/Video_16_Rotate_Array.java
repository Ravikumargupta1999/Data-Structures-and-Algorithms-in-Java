package InterviewQuestion;

public class Video_16_Rotate_Array {
    // Anti clockwise or left d times
    // https://practice.geeksforgeeks.org/problems/rotate-array-by-n-elements-1587115621/0
    static void rotateArr(int[] arr, int d, int n) {
        d = d % n;
        reverse(arr, 0, d - 1);
        reverse(arr, d, n - 1);
        reverse(arr, 0, n - 1);
    }

    // Clockwise or right
    // https://leetcode.com/problems/rotate-array/submissions/
    public void rotate(int[] arr, int d) {
        int n = arr.length;
        d = d % n;
        reverse(arr, 0, n - d - 1);
        reverse(arr, n - d, n - 1);
        reverse(arr, 0, n - 1);
    }

    public static void reverse(int[] arr, int left, int right) {
        while (left < right) {
            int temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            left++;
            right--;
        }
    }
}
