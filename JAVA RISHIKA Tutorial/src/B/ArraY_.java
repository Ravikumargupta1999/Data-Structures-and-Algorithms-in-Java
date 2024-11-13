package B;

import java.util.Arrays;

public class ArraY_ {
    public static void main(String[] args) {

        int[] arr = {10, 45, 34, 28};
        int n = arr.length;
        print(arr);
        Arrays.sort(arr);
        print(arr);

    }
    public static void print(int[] arr){
        System.out.println("\n");

        for(int val : arr)
            System.out.print(val+"\t");

        System.out.println("");
    }
}

