public class D_Dynamic_Programming_417_11_Count_the_number_of_subset_with_a_given_difference {

    // https://www.youtube.com/watch?v=ot_XBHyqpFc&list=PL_z_8CaSLPWekqhdCPmFohncHwz8TY2Go&index=11

    static int countSubsetDifference(int[] arr, int N, int target) {
        // code here
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
        int[][] dp = new int[n + 1][sum + 1];
        for (int i = 0; i < sum + 1; i++)
            dp[0][i] = 0;
        for (int i = 0; i < n + 1; i++)
            dp[i][0] = 1;

        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < sum + 1; j++) {
                if (arr[i - 1] <= j)
                    dp[i][j] = dp[i - 1][j - arr[i - 1]] + dp[i - 1][j];
                else
                    dp[i][j] = dp[i - 1][j];
            }
        }
        return dp[n][sum];
    }
}
