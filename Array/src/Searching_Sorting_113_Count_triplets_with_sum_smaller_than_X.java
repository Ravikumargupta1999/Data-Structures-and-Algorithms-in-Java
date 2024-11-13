import java.util.Arrays;

public class Searching_Sorting_113_Count_triplets_with_sum_smaller_than_X {
    // https://practice.geeksforgeeks.org/problems/count-triplets-with-sum-smaller-than-x5549/1
    public static long threeSum(long[] arr, int target) {
        Arrays.sort(arr);
        long count = 0;
        for (int i = 0; i < arr.length - 2; i++) {

            long j = i + 1;
            long k = arr.length - 1;
            while (j < k) {
                if (arr[(int) i] + arr[(int) j] + arr[(int) k] >= target)
                    k--;
                else {
                    count += (k - j);
                    j++;
                }
            }

        }
        return count;
    }


}
