import java.util.Scanner;

public class PalindromicArray {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < arr.length; i++)
            arr[i] = s.nextInt();
        int output = palinArray(arr, n);
        System.out.println(output);


    }

    public static int palinArray(int[] a, int n) {
        int i;
        for (i = 0; i < a.length; i++) {
            int n1, r, sum = 0, temp;
            n1 = a[i];
            temp = n1;
            while (n1 > 0) {
                r = n1 % 10;
                sum = (sum * 10) + r;
                n1 = n1 / 10;
            }
            if (temp == sum)
                System.out.println(a[i] + " is palindrom");
            else
                System.out.println(a[i] + " is  not palindrom");

            if (temp != sum)
                break;
        }
        if (i > a.length - 1)
            return 1;
        else
            return 0;
    }
}
