package Two;

import java.sql.Array;
import java.util.Arrays;
// https://practice.geeksforgeeks.org/problems/max-circular-subarray-sum-1587115620/1/#
// https://leetcode.com/problems/maximum-sum-circular-subarray/submissions/
// Tech Dose
public class Max_Circular_Sub_Array {

    static int circularSubarraySum(int a[], int n) {
        int count = 0;
        int least_negative = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            if (a[i] < 0) {
                count++;
                if (a[i] > least_negative)
                    least_negative = a[i];
            }

        }
        if (n == count)
            return least_negative;
        int max_sum_kadanes = maxSubarraySum(a, n);

        int array_sum = 0;
        for (int i = 0; i < n; i++)
            array_sum += a[i];


        for (int i = 0; i < n; i++) {
            a[i] = -a[i];
        }

        //System.out.println(array_sum);
        int max_sum = maxSubarraySum(a, n);
        // System.out.println(max_sum);
        return Math.max(((array_sum) + (max_sum)), max_sum_kadanes);
    }

    static int maxSubarraySum(int arr[], int n) {
        int csum = arr[0];
        int osum = arr[0];
        for (int i = 1; i < n; i++) {
            if (csum > 0) {
                csum += arr[i];
            } else {
                csum = arr[i];
            }
            if (csum > osum)
                osum = csum;
        }

        return osum;
    }

    public static void main(String[] args) {
        int[] arr = {8, -8, 9, -9, 10, -11, 12};
        System.out.println(circularSubarraySum(arr, arr.length));
    }
}
