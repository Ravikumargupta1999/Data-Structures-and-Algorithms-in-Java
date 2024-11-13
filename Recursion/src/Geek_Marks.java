import org.omg.Messaging.SYNC_WITH_TRANSPORT;

// https://practice.geeksforgeeks.org/problems/geek-and-his-marks-1611824243/0/?problemType=full&page=1&query=problemTypefullpage1

import java.util.Scanner;

public class Geek_Marks {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int t = s.nextInt();
        while (t-- > 0)
        {
            int n = s.nextInt();
            int x = s.nextInt();
            int[] arr = new int[n];

            for(int i=0;i<n;i++)
                arr[i] = s.nextInt();

            int count = 0;
            for(int i=0;i<arr.length;i++)
                if(arr[i] > x)
                    count++;
            System.out.println(count);
        }
    }
}
