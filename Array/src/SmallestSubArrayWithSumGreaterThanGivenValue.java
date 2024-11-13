import java.util.Scanner;

public class SmallestSubArrayWithSumGreaterThanGivenValue {
    public static void main(String[] args) {
        Scanner s=new Scanner(System.in);
        System.out.print("Enter size of array : ");
        int n=s.nextInt();
        long[] arr=new long[n];
        System.out.print("Enter array elements :  ");
        for (int i=0;i<arr.length;i++)
            arr[i]=s.nextLong();
        for(int i=0;i<arr.length;i++)
            System.out.print(arr[i]+"  ");
        System.out.println();
        System.out.print("Enter the Value :  ");
        int k=s.nextInt();
        long result=sb(arr,n,k);
        System.out.println();
        System.out.println("Minimum subarray length is :  "+ result);
    }
    public static long sb(long[] arr,long n,long x)
    {
        long currentsum=0;
        long minlength=n+1;
        int start=0;
        int end=0;
        while (end<n)
        {
            while (currentsum<=x && end<n)
            {
                currentsum+=arr[end++];
            }
            while (currentsum>x && start<n)
            {
                if(end-start<minlength) {
                    minlength=end-start;
                }
                currentsum -= arr[start++];
            }
        }
        return minlength;
    }
}
