import java.util.ArrayList;
import java.util.Arrays;

/*
    Time Complexity: O(3 ^ N)
    Space Complexity: O(N)

    where N is length of the array
*/
// https://www.geeksforgeeks.org/maximum-subsequence-sum-such-that-no-three-are-consecutive/
// https://www.codingninjas.com/codestudio/problems/maximum-subsequence-sum-such-that-no-three-are-consecutive_1215007?leftPanelTab=2
// https://www.youtube.com/watch?v=-FJinY9Yb-s&t=338s
public class D_Dynamic_Programming_431_Maximum_subsequence_sum_such_that_no_three_are_consecutive {
    public static int maxSumHandler(ArrayList<Integer> a, int i, int[] dp) {
        if (i < 0)
            return 0;
        if (i == 0) {
            return a.get(0);
        }

        if (i == 1) {
            return a.get(0) + a.get(1);
        }

        if (i == 2) {
            return Math.max(a.get(0) + a.get(1), Math.max(a.get(1) + a.get(2), a.get(0) + a.get(2)));
        }

        if (dp[i] != -1)
            return dp[i];

        int U = maxSumHandler(a, i - 1, dp);
        int V = a.get(i) + maxSumHandler(a, i - 2, dp);
        int W = a.get(i) + a.get(i - 1) + maxSumHandler(a, i - 3, dp);
        int res = Math.max(U, Math.max(V, W));

        return dp[i] = res;
    }

    public static int maxSum(ArrayList<Integer> a, int n) {
        int[] dp = new int[n];
        Arrays.fill(dp, -1);
        return maxSumHandler(a, n - 1, dp);
    }
}
// https://www.geeksforgeeks.org/maximum-subsequence-sum-such-that-no-three-are-consecutive/