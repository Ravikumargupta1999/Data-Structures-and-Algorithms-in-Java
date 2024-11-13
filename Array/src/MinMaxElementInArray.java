
// Maximum and Minimum Element in an array
// T(n) = O(n)

import java.util.Scanner;

public class MinMaxElementInArray {
    static int min;
    static int max;

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = s.nextInt();
        System.out.print("Array is :  ");
        for (int i = 0; i < n; i++)
            System.out.print(arr[i] + "  ");
        Min_max(arr);
        System.out.println("");
        System.out.println("Minimum Value is : " + min);
        System.out.println("Maximum Value is : " + max);
    }

    public static void Min_max(int[] arr) {
        if (arr.length == 1) {
            min = max = arr[0];
        }
        if (arr.length > 1) {
            if (arr[0] < arr[1]) {            //1
                min = arr[0];
                max = arr[1];
            } else {
                min = arr[1];
                max = arr[0];
            }
            for (int i = 2; i < arr.length; i++) {    //  2(n-2)
                if (arr[i] < min)
                    min = arr[i];
                else if (arr[i] > max)
                    max = arr[i];
            }
        }

    }
}
// Total no of  Comparison is 2(n-2)+1