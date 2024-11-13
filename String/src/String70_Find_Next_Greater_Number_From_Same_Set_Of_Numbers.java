import java.util.ArrayList;
import java.util.List;

public class String70_Find_Next_Greater_Number_From_Same_Set_Of_Numbers {
    // https://practice.geeksforgeeks.org/problems/next-permutation5226/1
    // https://www.youtube.com/watch?v=LuLCLgMElus&t=434s
    static List<Integer> nextPermutation(int n, int arr[]) {
        int index = -1;
        int i = arr.length - 2;
        while (i >= 0 && arr[i] >= arr[i + 1])
            i--;
        if (i >= 0) {
            int j = arr.length - 1;
            while (arr[j] <= arr[i])
                j--;
            swap(arr, i, j);
        }
        reverse(arr, i + 1, arr.length - 1);
        List<Integer> al = new ArrayList<>();
        for (int l = 0; l < arr.length; l++) {
            al.add(arr[l]);
        }
        return al;
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
