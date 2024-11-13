import org.omg.Messaging.SYNC_WITH_TRANSPORT;

import java.util.Scanner;

public class RotateAnArray {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int t = s.nextInt();
        int m = 0;
        while (m < t) {
            int n = s.nextInt();
            int[] arr = new int[n];
            int k = s.nextInt();
            for (int i = 0; i < n; i++)
                arr[i] = s.nextInt();
            int j = 0;

            while (j < k) {
                int temp1 = 0;
                int temp2 = arr[arr.length - 1];
                for (int i = arr.length - 1; i > 0; i--) {
                    temp1 = arr[i - 1];
                    arr[i - 1] = temp2;
                    temp2 = temp1;
                }
                arr[arr.length - 1] = temp2;
                j++;
            }
            for (int i = 0; i < arr.length; i++)
                System.out.print(arr[i] + " ");
            System.out.println("");

        }
        m++;
    }
}
