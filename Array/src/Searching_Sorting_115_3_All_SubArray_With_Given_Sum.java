import java.util.HashMap;




public class Searching_Sorting_115_3_All_SubArray_With_Given_Sum {

     // https://practice.geeksforgeeks.org/problems/subarrays-with-sum-k/1/
    // https://practice.geeksforgeeks.org/problems/subarray-range-with-given-sum2804/1
    public static int subArraysSum(int[] arr, int n, int sum) {
        HashMap<Integer, Integer> prevSum = new HashMap<>();

        int res = 0;

        int currSum = 0;

        for (int i = 0; i < n; i++) {


            currSum += arr[i];

            if (currSum == sum)
                res++;
            if (prevSum.containsKey(currSum - sum))
                res += prevSum.get(currSum - sum);

            Integer count = prevSum.get(currSum);
            if (count == null)
                prevSum.put(currSum, 1);
            else
                prevSum.put(currSum, count + 1);
        }

        return res;

    }


}
