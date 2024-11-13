package Language_Fundamental.Literals;

import java.util.Arrays;

public class Array_Decleration {
    public static void main(String[] args) {
        int[] arr = {10,34,016};
        System.out.println(arr);
        for(int val : arr)
        {
            System.out.print(val+"  ");
        }
        System.out.println("\n\n");
        System.out.println(Arrays.toString(args));
//        int[] arr = {10,34,08};
//        System.out.println(arr);
    }
}
