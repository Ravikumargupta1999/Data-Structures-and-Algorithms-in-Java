public class D_Dynamic_Programming_449_Equal_Subset_Sum {
    // https://practice.geeksforgeeks.org/problems/subset-sum-problem2014/1
    // https://www.youtube.com/watch?v=UmMh7xp07kY&list=PL_z_8CaSLPWekqhdCPmFohncHwz8TY2Go&index=8
    static int equalPartition(int N, int arr[]) {
        int sum = 0;
        for (int v : arr)
            sum += v;
        return sum % 2 != 0 ? 0 : TargetSumSubset(arr, N, sum / 2);
    }

    public static int TargetSumSubset(int[] arr, int n, int sum) {
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
                    if (dp[i - 1][j] == true) {
                        dp[i][j] = true;
                    } else {
                        int val = arr[i - 1];
                        if (j >= val) {
                            if (dp[i - 1][j - val] == true) {
                                dp[i][j] = true;
                            }
                        }
                    }
                }
            }
        }
        return dp[arr.length][sum] == true ? 1 : 0;
    }
}
