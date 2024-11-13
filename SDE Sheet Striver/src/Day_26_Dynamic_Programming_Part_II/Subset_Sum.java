package Day_26_Dynamic_Programming_Part_II;

public class Subset_Sum {
    public boolean canPartition(int[] arr) {
        int n = arr.length;
        int sum = 0;
        for (int i = 0; i < arr.length; i++)
            sum += arr[i];
        if (sum % 2 != 0)
            return false;
        else {
            return TargetSumSubset(arr, n, sum / 2);
        }
    }

    static boolean TargetSumSubset(int[] arr, int n, int sum) {
        boolean[][] dp = new boolean[n + 1][sum + 1];
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                if (i == 0 && j == 0)
                    dp[i][j] = true;
                else if (i == 0)
                    dp[i][j] = false;
                else if (j == 0)
                    dp[i][j] = true;
                else {
                    if (dp[i - 1][j]) {
                        dp[i][j] = true;
                    } else {
                        int val = arr[i - 1];
                        if (j >= val) {
                            if (dp[i - 1][j - val]) {
                                dp[i][j] = true;
                            }
                        }
                    }
                }
            }
        }
        return dp[arr.length][sum];
    }
}
