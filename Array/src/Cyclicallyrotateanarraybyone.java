import java.util.Scanner;

public class Cyclicallyrotateanarraybyone {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n1 = s.nextInt();

        long[] arr = new long[n1];
        for (int i = 0; i < arr.length; i++)
            arr[i] = s.nextLong();

        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + "  ");
        }
        System.out.println();
        rotate(arr, arr.length);
        System.out.println();
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + "  ");
        }


    }

    public static void rotate(long arr[], long n) {
        long temp2 = arr[arr.length - 1];
        long temp = arr[0];
        long temp1;
        for (int i = 0; i < arr.length - 1; i++) {
            temp1 = arr[i + 1];
            arr[i + 1] = temp;
            temp = temp1;
        }
        arr[0] = temp2;


    }
}
