public class D_Dynamic_Programming_445_Smallest_Sum_Contiguous_SubArray {

    // https://practice.geeksforgeeks.org/problems/smallest-sum-contiguous-subarray/1
    static int smallestSumSubArray(int a[], int size) {
        int min = Integer.MAX_VALUE;
        int currSum = 0;
        for (int val : a) {

            if (currSum < 0) {
                currSum += val;
            } else {
                currSum = val;
            }

            min = Math.min(min, currSum);
        }
        return min;
    }
}
