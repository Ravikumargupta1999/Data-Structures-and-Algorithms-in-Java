import org.omg.Messaging.SYNC_WITH_TRANSPORT;

import java.util.Arrays;
import java.util.Scanner;

public class Array_In_JAVA {
    public static void main(String[] args) {
//        int[] arr1 = new int[4];
//        for(int i=0;i<arr1.length;i++)
//            System.out.print(arr1[i]+"  ");
//        System.out.println(" ");
//
//        char[] arr2 = new char[4];
//        for(int i=0;i<arr2.length;i++)
//            System.out.print(arr2[i]+"  ");
//        System.out.println(" ");
//
//        String[] arr3 = new String[4];
//        for(int i=0;i<arr3.length;i++)
//            System.out.print(arr3[i]+"  ");
//        System.out.println(" ");
//
//        double[] arr4 = new double[4];
//        for(int i=0;i<arr3.length;i++)
//            System.out.print(arr4[i]+"  ");
//        System.out.println(" ");
//
//        int Null = 45;
//        System.out.print(Null);

        System.out.print("\n\n");

        Scanner s= new Scanner(System.in);
        int[]  Arr = new int[5];
        for(int i=0;i<Arr.length;i++)
            Arr[i] = s.nextInt();
        for(int i=0;i<Arr.length;i++)
            System.out.print(Arr[i]+" ");
        System.out.println(" ");

        for(int val : Arr)
            System.out.print(val+" ");
        System.out.print("\n");
        System.out.println(Arrays.toString(Arr));
        String s1 = Arrays.toString(Arr);



    }
}
