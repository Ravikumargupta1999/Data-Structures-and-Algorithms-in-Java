package Recursion;

import java.util.Arrays;

public class Recursion_13_Last_Index_of_Occurrence {
    public static void main(String[] args) {
        int[] arr = {1, 3, 5, 6, 7, 2, 3, 4, 6};
        System.out.println("Array Length : "+arr.length);
        System.out.println("Array : "+ Arrays.toString(arr));
        System.out.println(lastFirstOccurrence(arr, 0, 1));
    }

    public static int lastFirstOccurrence(int[] arr, int idx, int val) {
        if (idx == arr.length - 1) {
            if (arr[idx] == val)
                return idx;
            return -1;
        }
        int last = lastFirstOccurrence(arr, idx + 1, val);
        if (last != -1)
            return last;
        if(arr[idx] == val)
            return idx;
        return -1;
    }
}
