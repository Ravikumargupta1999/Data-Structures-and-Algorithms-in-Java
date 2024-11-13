import java.util.Scanner;

public class Array6_Reverse__Array_Using_Recursion {
//    Done
    // https://practice.geeksforgeeks.org/problems/reverse-an-array/0
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int t = s.nextInt();
        while (t-- > 0) {
            int n = s.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < arr.length; i++)
                arr[i] = s.nextInt();
            // System.out.print("Array         :  ");
            // printArray(arr);
            reverse(arr, 0, arr.length - 1);
            // System.out.print("Reverse array :  ");
            printArray(arr);
        }
    }

    public static void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++)
            System.out.print(arr[i] + " ");
        System.out.println("");
    }

    public static void reverse(int[] arr, int start, int end) {
        if (start >= end)
            return;

        int temp = arr[start];
        arr[start] = arr[end];
        arr[end] = temp;
        reverse(arr, start + 1, end - 1);
    }

    //    https://leetcode.com/problems/reverse-string/submissions/860322427/
    public void reverseString(char[] s) {
        for (int i = 0; i < s.length / 2; i++) {
            char temp = s[i];
            s[i] = s[s.length - 1 - i];
            s[s.length - 1 - i] = temp;
        }
    }
}
