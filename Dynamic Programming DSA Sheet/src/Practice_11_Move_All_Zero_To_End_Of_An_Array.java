import java.util.ArrayList;
import java.util.Arrays;

public class Practice_11_Move_All_Zero_To_End_Of_An_Array {

//    // order won't be preserved
//    void pushZerosToEnd(int[] arr, int n) {
//        int i = 0;
//
//        int j = n - 1;
//
//        while (i < j) {
//            while (i < j && arr[i] != 0)
//                i++;
//            while (j > i && arr[j] == 0)
//                j--;
////            if (i < j && arr[i] == 0) {
//            swap(arr, i, j);
//            j--;
//        }
//    }
//
//}
//
//    void pushZerosToEndOfTheArray(int[] arr, int n) {
//        int i = n - 1;
//        int j = n - 1;
//
//        while (i < j) {
//            while (i >= 0 && arr[i] != 0)
//                i--;
//            while (j >= 0 && arr[j] == 0)
//                j--;
//            if (arr[i] == 0) {
//                swap(arr, i, j);
//                j--;
//            }
//        }
//    }
//
//    void swap(int[] arr, int i, int j) {
//        int temp = arr[i];
//        arr[i] = arr[j];
//        arr[j] = temp;
//    }
//
//    public static void pushArrayToEnd(int[] arr, int n) {
//        ArrayList<Integer> list = new ArrayList<>();
//
//        for (int val : arr)
//            if (val != 0)
//                list.add(val);
//
//
//        for (int i = 0, j = 0; i < n; i++, j++) {
//            arr[i] = j < list.size() ? list.get(j) : 0;
//        }
//    }

    void fun(int[] arr, int n) {
        int nonZero = 0;
        for (int j = 0; j < n; j++) {
            if (arr[j] != 0) {
                swap(arr, j, nonZero);
                nonZero++;
            }
        }
    }

    void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }


}
//20
//        15 12 0 0 0 2 2 19 6 17 16 20 0 2 16 0 10 0 14 15
//        Your Code's output is:
//        15 12 15 14 10 2 2 19 6 17 16 20 16 2 0 0 0 0 0 0
//        It's Correct output is:
//        15 12 2 2 19 6 17 16 20 2 16 10 14 15 0 0 0 0 0 0
//        Output Difference
