public class D_Dynamic_Programming_417_8_Equal_Subset_Partition {

//    https://leetcode.com/problems/partition-equal-subset-sum/submissions/897475111/

    public boolean canPartition(int[] nums) {
        return equalPartition1(nums,nums.length) == 1 ? true : false;
    }


    // https://practice.geeksforgeeks.org/problems/subset-sum-problem2014/1
    // https://www.youtube.com/watch?v=UmMh7xp07kY&list=PL_z_8CaSLPWekqhdCPmFohncHwz8TY2Go&index=8
    public int equalPartition1(int[] arr, int n) {
        int sum = 0;
        for (int i = 0; i < arr.length; i++)
            sum += arr[i];
        return sum % 2 != 0 ? 0 : TargetSumSubset(arr, n, sum / 2);
    }

    public  int TargetSumSubset(int[] arr, int n, int sum) {
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
        return dp[n][sum] ? 1 : 0;
    }



    //    https://practice.geeksforgeeks.org/problems/equal-sum0810/1
    String equilibrium(int arr[], int n) {
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }
        int leftSum = 0;
        for (int i = 0; i < arr.length; i++) {

            if (sum - arr[i] == leftSum)
                return "YES";
            sum -= arr[i];
            leftSum += arr[i];
        }
        return "NO";
    }
}
