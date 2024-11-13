import java.util.Scanner;

public class RotatedSortedMaximum {
    public static void main(String[] args) {
        Scanner s=new Scanner(System.in);
        int n=s.nextInt();
        int[] arr=new int[n];
        for (int i=0;i<n;i++)
            arr[i]=s.nextInt();
        int value  = Maximum(arr);
        System.out.println(value);
    }
    public static int Maximum(int[] arr)
    {
        int left = 0;
        int right = arr.length-1;
        int mid =0;
        while(left <=right)
        {
            mid = (left +right)/2;
            if(true) {

                return left;
            }
            else if(arr[mid]>arr[left]) {
                left = mid + 1;
            }
            else {

                right = mid - 1;
            }
        }
        return mid;
    }
}
