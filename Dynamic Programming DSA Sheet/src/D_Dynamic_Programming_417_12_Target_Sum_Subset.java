// https://www.youtube.com/watch?v=Hw6Ygp3JBYw&list=PL_z_8CaSLPWekqhdCPmFohncHwz8TY2Go&index=12
// https://practice.geeksforgeeks.org/problems/target-sum-1626326450/1
public class D_Dynamic_Programming_417_12_Target_Sum_Subset {

    static int findTargetSumWays(int[] arr, int N, int target) {
        int sumOfArray = 0;
        for (int i = 0; i < N; i++)
            sumOfArray += arr[i];
        int s1 = (target + sumOfArray);
        if (s1 % 2 != 0)
            return 0;
        s1 = s1 / 2;
        return countOfSubsetSum(arr, N, s1);
    }

    static int countOfSubsetSum(int[] arr, int n, int sum) {
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
