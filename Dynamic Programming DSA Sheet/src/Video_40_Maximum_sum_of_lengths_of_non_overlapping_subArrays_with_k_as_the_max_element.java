public class Video_40_Maximum_sum_of_lengths_of_non_overlapping_subArrays_with_k_as_the_max_element {
    // https://practice.geeksforgeeks.org/problems/sum-of-lengths-of-non-overlapping-subarrays2237/1
    long calculateMaxSumLength(long[] arr, int n, int k) {
        long ans = 0; // final sum of lengths
        int count = 0;
        int flag = 0;
        for (int i = 0; i < n; ) {
            count = 0;
            flag = 0;
            while (i < n && arr[i] <= k) {
                count++;
                if (arr[i] == k)
                    flag = 1;
                i++;
            }
            if (flag == 1)
                ans += count;
            while (i < n && arr[i] > k)
                i++;
        }
        return ans;
    }
}
