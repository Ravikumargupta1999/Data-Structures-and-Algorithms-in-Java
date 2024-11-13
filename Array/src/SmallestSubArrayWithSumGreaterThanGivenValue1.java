import java.util.Scanner;

public class SmallestSubArrayWithSumGreaterThanGivenValue1 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.print("Enter size of array : ");
        int n = s.nextInt();
        long[] arr = new long[n];
        System.out.print("Enter array elements :  ");
        for (int i = 0; i < arr.length; i++)
            arr[i] = s.nextLong();
        for (int i = 0; i < arr.length; i++)
            System.out.print(arr[i] + "  ");
        System.out.println();
        System.out.print("Enter the Value :  ");
        int k = s.nextInt();
        long result = smallestsubarray(arr, n, k);
        System.out.println();
        System.out.println("Minimum subarray length is :  " + result);
    }
    public static long smallestsubarray(long[] arr,long n,long x)
    {

        long minlength=n+1;

        for(int i=0;i<n;i++)
        {
            long currentsum=arr[i];
            if(currentsum>x)
                return 1;
            System.out.println();
            for(int j=i+1;j<n;j++)
            {
                System.out.print(j+" ");
                currentsum+=arr[j];
                if(currentsum>x &&(j-i+1)<minlength)
                    minlength=j-i+1;
            }
        }
        return minlength;
    }
}