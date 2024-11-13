// https://practice.geeksforgeeks.org/problems/maximum-sum-increasing-subsequence4749/1
// https://www.youtube.com/watch?v=5ToHur2XrA4&t=126s
public class D_Dynamic_Programming_428_Maximum_Sum_Increasing_Subsequences {
    public int maxSumIS(int arr[], int n) {
        int[] dp = new int[n];

        int overAllMax = arr[0];

        dp[0] = arr[0];

        for (int i = 1; i < n; i++) {
            int max = 0;

            for (int j = 0; j < i; j++) {

                if (arr[j] < arr[i]) {
                    max = Math.max(max, dp[j]);
                }
            }

            dp[i] = max + arr[i];
            overAllMax = Math.max(overAllMax, dp[i]);
        }
        return overAllMax;
    }
}
