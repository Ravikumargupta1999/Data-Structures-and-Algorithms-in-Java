import java.util.ArrayList;
import java.util.Scanner;

public class  NumberOfOccurrence {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int[] arr = new int[n];
        for(int i=0; i<n;i++)
            arr[i] = s.nextInt();
        int k = s.nextInt();
        int al = count(arr,n,k);
        System.out.println(al);
    }
    public static int count(int[] arr, int n,int x)
    {
        int lo =0;
        int hi = n-1;
        int fi = -1;
        while (lo <= hi)
        {
            int mid = (lo + hi)/2;
            if(x>arr[mid])
                lo = mid +1 ;
            else if(x<arr[mid])
                hi = mid -1;
            else
            {
                fi = mid;
                hi = mid -1;
            }
        }

        lo =0;
        hi = n-1;
        int li = -1;
        while (lo <= hi)
        {
            int mid = (lo + hi)/2;
            if(x>arr[mid])
                lo = mid +1 ;
            else if(x<arr[mid])
                hi = mid -1;
            else
            {
                li = mid;
                lo = mid +1;
            }
        }

        if(li+fi<0)
            return 0;
        return li-fi+1;
    }
}
