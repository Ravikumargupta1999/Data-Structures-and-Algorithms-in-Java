public class Video_42_Max_sum_of_M_non_overlapping_subarrays_of_size_K {
    // https://www.geeksforgeeks.org/max-sum-of-m-non-overlapping-subarrays-of-size-k/
    public static void main(String[] args) {
        int arr[] = {3, 2, 100, 1};
        int n = arr.length;
        int m = 2, k = 2;
        int[] pSum = new int[n];
        int sum = 0;
        for (int i = 0; i < k; i++) {
            sum += arr[i];
        }
        pSum[0] = sum;
        for (int i = k, j = 0; i < n; i++, j++) {
            sum += arr[i] - arr[j];
            pSum[i - k + 1] = sum;
        }
        System.out.println(maxSum(arr, 0, m, k, pSum, new int[n][m + 1]));
    }

    public static int maxSum(int[] arr, int idx, int m, int k, int[] pSum, int[][] dp) {
        if (m == 0)
            return 0;
        if (idx >= arr.length)
            return 0;
        if (dp[idx][m] != 0)
            return dp[idx][m];
        int exclude = 0 + maxSum(arr, idx + 1, m, k, pSum, dp);
        int include = pSum[idx] + maxSum(arr, idx + k, m - 1, k, pSum, dp);
        int ans = Math.max(exclude, include);
        dp[idx][m] = ans;
        return ans;
    }
}
