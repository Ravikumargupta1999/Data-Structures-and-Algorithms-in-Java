// https://practice.geeksforgeeks.org/problems/allocate-minimum-number-of-pages0937/1#

public class Allocate_Minimum_Number_Pages {
    public static int findPages(int[] arr,int n,int k)
    {

        int max = arr[0];
        for(int i = 1;i< n;i++)
            if(arr[i] > max)
                max = arr[i];

        int sum = arr[0];
        for(int i=1 ;i<n;i++)
            sum += arr[i];
        int start = max;
        int end = sum;
        int result = -1;
        System.out.println(start +"  "+ end);

        while (start <= end)
        {
            int mid = start + (end - start)/2;
            if(isValid(arr,n,k,mid) == true)
            {
                result = mid;
                end = mid-1;
            }
            else
            {
                start = mid + 1;
            }
        }
        return result;
    }
    public static  boolean isValid(int[] arr,int n,int k,int max)
    {
        int stu = 1;
        int sum = 0;
        for(int i = 0;i<n;i++)
        {
            sum += arr[i];
            if(sum > max)
            {
                stu++;
                sum = arr[i];
            }
            if(stu > k)
                return false;
        }
        return true;
    }
    public static void main(String[] args) {
        int[] arr = {15,17,20};
        System.out.println(findPages(arr,arr.length,3));
    }
}
