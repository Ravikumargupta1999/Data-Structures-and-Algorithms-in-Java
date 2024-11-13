public class D_Dynamic_Programming_417_1_Target_Sum_Subset_Sumit_Malik {

    // https://practice.geeksforgeeks.org/problems/subset-sum-problem-1611555638/1
    // youtube.com/watch?v=tRpkluGqINc
    static Boolean isSubsetSum(int N, int arr[], int target){
        // code here

        boolean[][] dp = new boolean[N + 1][target + 1];

        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {

                if (i == 0 && j == 0) {
                    dp[i][j] = true;
                } else if (i == 0) {
                    dp[i][j] = false;
                } else if (j == 0) {
                    dp[i][j] = true;
                }else {
                    if (dp[i - 1][j]) {
                        dp[i][j] = true;
                    } else {
                        if (arr[i - 1] <= j)
                            dp[i][j] = dp[i-1][j - arr[i - 1]];
                    }
                }
            }
        }
        return dp[N][target];
    }
}
