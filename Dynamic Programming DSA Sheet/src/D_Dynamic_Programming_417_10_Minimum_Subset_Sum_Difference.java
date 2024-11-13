import java.util.ArrayList;
import java.util.Arrays;

// https://www.youtube.com/watch?v=-GtpxG6l_Mc&list=PL_z_8CaSLPWekqhdCPmFohncHwz8TY2Go&index=10

// https://practice.geeksforgeeks.org/problems/minimum-sum-partition3317/1#
public class D_Dynamic_Programming_417_10_Minimum_Subset_Sum_Difference {

    public static int minDifference(int[] arr, int n) {
        int sum = java.util.stream.IntStream.of(arr).sum();
        boolean[] possibleSubset = TargetSumSubset(arr, n, sum);
        ArrayList<Integer> al = new ArrayList<>();
        for (int i = 0; i <= sum / 2; i++) {
            if (possibleSubset[i])
                al.add(i);
        }
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < al.size(); i++) {
            min = Math.min(min, sum - 2 * al.get(i));
        }
        return min;
    }

    public static boolean[] TargetSumSubset(int[] arr, int n, int sum) {
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
        return dp[arr.length];
    }

    // chutiye ho kya . how can it be possible
    public int minDifferenceSubset(int[] arr, int n) {
        if (n == 1)
            return arr[0];
        Arrays.sort(arr);

        int sum = 0;
        int leftSum = 0;
        for (int val : arr)
            sum += val;

        int ans = 0;
        for (int val : arr) {
            leftSum += val;
            sum -= val;

            ans = Math.min(0, Math.abs(leftSum - sum));

        }
        return ans;
    }
}
