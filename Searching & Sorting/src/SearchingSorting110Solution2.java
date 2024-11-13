import org.omg.Messaging.SYNC_WITH_TRANSPORT;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class SearchingSorting110Solution2 {
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
        for(int i=0;i<arr.length;i++)
        {
            int y = arr[i] + k;
            int low =0;
            int high = arr.length-1;
            while(low<=high)
            {
                int mid = (low+high)/2;
                if(arr[mid] == y)
                    return true;
                else if(arr[mid]>=y)
                    high = mid -1;
                else
                    low = mid +1;
            }

        }
        return false;
    }
}
