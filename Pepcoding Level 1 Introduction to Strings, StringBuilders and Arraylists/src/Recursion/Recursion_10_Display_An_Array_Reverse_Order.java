package Recursion;

public class Recursion_10_Display_An_Array_Reverse_Order {
    public static void main(String[] args) {
        int[] arr = {57,77,22,45,89,90};
        displayReverse(arr,0);
        System.out.println("");
    }
    public static void displayReverse(int[] arr,int idx)
    {
        if( idx == arr.length)
            return;
        displayReverse(arr,idx+1);
        System.out.print(arr[idx]+"  ");
    }
}
