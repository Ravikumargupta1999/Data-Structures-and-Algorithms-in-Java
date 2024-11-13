public class D_Dynamic_Programming_417_7_Subset_Sum_Problem {
//    https://practice.geeksforgeeks.org/problems/subset-sum-problem-1611555638/1/
    // youtube.com/watch?v=tRpkluGqINc
    // https://www.youtube.com/watch?v=_gPcYovP7wc&list=PL_z_8CaSLPWekqhdCPmFohncHwz8TY2Go&index=7


    public static boolean TargetSumSubset(int[] arr, int n, int sum) {
        boolean[][] dp = new boolean[n + 1][sum + 1];

        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                if (i == 0 && j == 0) {
                    dp[i][j] = true;
                } else if (i == 0) {
                    dp[i][j] = false;
                } else if (j == 0) {
                    dp[i][j] = false;
                } else {
                    boolean flag = j - arr[i - 1] >= 0 ? dp[i - 1][j - arr[i - 1]] : false;
                    dp[i][j] = dp[i - 1][j] || flag;
                }
            }
        }
        return dp[n][sum];
    }



}
