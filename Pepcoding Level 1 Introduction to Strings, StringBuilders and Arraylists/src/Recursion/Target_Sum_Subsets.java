package Recursion;

public class Target_Sum_Subsets {
    public static void main(String[] args) {
        int[] arr = {3, 4, 1, 3, 5, 7, 8, 9};
        printTargetSum(arr, 0, "", 0, 12);
    }

    public static void printTargetSum(int[] arr, int idx, String set, int sos, int tar) {
        if (idx == arr.length) {
            if (tar == sos)
                System.out.println(set + ".");
            return;
        }
        if( sos > tar)
            return;
        printTargetSum(arr, idx + 1, set + arr[idx] + " ", sos + arr[idx], tar);
        printTargetSum(arr, idx + 1, set, sos, tar);
    }
}
