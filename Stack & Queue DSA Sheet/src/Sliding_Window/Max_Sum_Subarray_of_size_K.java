package Sliding_Window;

import java.util.ArrayList;
//https://practice.geeksforgeeks.org/problems/max-sum-subarray-of-size-k5313/1/?category[]=sliding-window&category[]=sliding-window&page=1&query=category[]sliding-windowpage1category[]sliding-window

public class Max_Sum_Subarray_of_size_K {
    static int maximumSumSubarray(int K, ArrayList<Integer> Arr, int n){
        int max = Integer.MIN_VALUE;
        int sum = 0;
        int idx = 0;
        for(int i=0;i<n;i++){
            if( i < K-1){
                sum += Arr.get(i);
            }
            else {
                sum += Arr.get(i);
                max= Math.max(sum,max);
                sum  -=  Arr.get(idx++);
            }
        }
        return max;
    }
}
