package Day_25_Dynamic_Programming;

public class Maximum_Sum_Increasing_Subsequence {
    public int maxSumIS(int[] arr, int n) {
        int[] dp = new int[n];
        dp[0] = arr[0];
        int res = arr[0];
        for (int i = 1; i < n; i++) {
            int max = 0;
            for (int j = 0; j < i; j++) {
                if(arr[j] < arr[i])
                    max = Math.max(max, dp[j]);
            }
            dp[i] = arr[i] + max;
            res = Math.max(res, dp[i]);
        }
        return res;
    }
}
