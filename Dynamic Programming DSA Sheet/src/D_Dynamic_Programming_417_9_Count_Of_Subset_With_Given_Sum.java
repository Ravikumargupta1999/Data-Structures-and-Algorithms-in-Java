public class D_Dynamic_Programming_417_9_Count_Of_Subset_With_Given_Sum {
    // https://practice.geeksforgeeks.org/problems/perfect-sum-problem5633/1#
    // https://www.youtube.com/watch?v=F7wqWbqYn9g&list=PL_z_8CaSLPWekqhdCPmFohncHwz8TY2Go&index=9
    public int perfectSum(int arr[], int n, int sum) {
        int p = 1000000007;
        int[][] dp = new int[n + 1][sum + 1];
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                if (i == 0 && j == 0) {
                    dp[i][j] = 1;
                } else if (i == 0) {
                    dp[i][j] = 0;
                }
                // if you also initialize j == 0 then dp[i][j] == 1 then it wont work for multiple duplicate cases;
                else {
                    if (arr[i - 1] <= j) {
                        dp[i][j] = (dp[i - 1][j] % p + dp[i - 1][j - arr[i - 1]] % p) % p;
                    } else {
                        dp[i][j] = dp[i - 1][j] % p;
                    }
                }
            }
        }
        return dp[n][sum];
    }
}
