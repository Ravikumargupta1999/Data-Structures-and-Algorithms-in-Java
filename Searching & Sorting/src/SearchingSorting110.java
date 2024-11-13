import org.omg.Messaging.SYNC_WITH_TRANSPORT;

import java.util.Arrays;
import java.util.Scanner;

public class SearchingSorting110 {
    public static void main(String[] args) {
        Scanner s=new Scanner(System.in);
        int n=s.nextInt();
        int[] arr=new int[n];
        for (int i=0;i<n;i++)
            arr[i] = s.nextInt();
        int k = s.nextInt();
        boolean value = PairDifference(arr,n,k);
        System.out.println(value);
    }
    public static boolean PairDifference(int[] arr,int n,int k)
    {
        Arrays.sort(arr);
        int i=0;
        int j=1;
        while (i<n && j<n)
        {
            if( arr[j]-arr[i] ==k)
                return true;
            else if(arr[j]-arr[i] < k)
                j++;
            else
                i++;

        }
        return false;
    }
}
