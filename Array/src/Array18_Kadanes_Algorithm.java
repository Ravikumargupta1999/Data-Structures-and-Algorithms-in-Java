import java.util.Scanner;
// https://practice.geeksforgeeks.org/problems/merge-two-sorted-arrays-1587115620/1
public class Array18_Kadanes_Algorithm {
    //
    int maxSubarraySum(int arr[], int n){

        int meh=0;
        int mef=Integer.MIN_VALUE;
        for(int i=0;i<n;i++)
        {
            meh=meh+arr[i];
            if(meh<arr[i])
                meh=arr[i];
            if(mef<meh)
                mef=meh;
        }
        return mef;

    }

    // https://www.youtube.com/watch?v=VMtyGnNcdPw
    int maxSubarraySum1(int arr[], int n){
        int csum = arr[0];
        int osum = arr[0];
        for(int i =1;i<n;i++)
        {
            if(csum>0)
            {
                csum+=arr[i];
            }
            else
            {
                csum = arr[i];
            }
            if(csum>osum)
                osum = csum;
        }
        // Your code here
        return osum;
    }
}
