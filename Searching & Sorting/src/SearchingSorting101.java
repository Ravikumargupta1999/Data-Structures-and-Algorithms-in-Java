import java.util.ArrayList;
import java.util.Scanner;

public class SearchingSorting101 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        long[] arr = new long[n];
        for(int i=0; i<n;i++)
            arr[i] = s.nextLong();
        int k = s.nextInt();
      ArrayList<Long> al = find(arr,n,k);
        System.out.println(al);
    }
    public static ArrayList<Long> find(long[] arr, int n, int x)
    {
        int lo =0;
        int hi = n-1;
        long fi = -1;
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
       // System.out.println(fi);
        lo =0;
        hi = n-1;
        long li = -1;
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
       // System.out.println(li);
        ArrayList<Long> al = new ArrayList<>();
        al.add(fi);
        al.add(li);
     return al;
    }
}
