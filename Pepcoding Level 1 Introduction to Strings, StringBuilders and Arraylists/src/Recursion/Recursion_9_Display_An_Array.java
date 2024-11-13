package Recursion;

public class Recursion_9_Display_An_Array {
    public static void main(String[] args) {
        int[] arr = {57, 77, 22, 45, 89, 90};
        display(arr, 0);
        System.out.println("\n\n");
    }

    public static void display(int[] arr, int idx) {
        if (idx == arr.length)
            return;
        System.out.print(arr[idx] + "  ");
        display(arr, idx + 1);
    }
}
