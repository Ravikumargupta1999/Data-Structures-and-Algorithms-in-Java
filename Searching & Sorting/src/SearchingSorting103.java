import java.util.Scanner;

public class SearchingSorting103 {
    public static void main(String[] args) {
        Scanner s=new Scanner(System.in);
        int n=s.nextInt();
        int[] arr=new int[n];
        for (int i=0;i<n;i++)
            arr[i]=s.nextInt();
        int target = s.nextInt();
        int value  = Maximum(arr,n,target);
        System.out.println(value);
    }
    public static int Maximum(int[] arr,int n,int k)
    {
        int left = 0;
        int right = arr.length-1;
        int mid =0;
        while(left <=right)
        {
            mid = (left+ right)/2;
            if(arr[mid] == k)
            {
                System.out.println("Hello 1\n");
                return mid;
            }
            else if(arr[mid]>=arr[left])
            {
                System.out.println("Hello 2\n");
                if(k <= arr[mid] && k >=arr[left])
                    right = mid -1;
                else
                    left = mid +1;
            }
            else
            {
                System.out.println("Hello 3\n");
                if(k >= arr[mid] && k <= arr[right])
                    left = mid +1;
                else
                    right = mid - 1;

            }
        }
        return -1;
    }
}
