import java.util.HashMap;

// https://practice.geeksforgeeks.org/problems/longest-subsequence-such-that-difference-between-adjacents-is-one4724/1#
public class D_Dynamic_Programming_430_Longest_Subsequence_such_that_difference_between_adjacent_is_one {

    // TC : O(n^2)
    // SC : O(n)
    public static int longestSubsequence(int n, int[] arr) {
        int[] dp = new int[n];
        dp[0] = 1;
        int maxlen = 1;
        for (int i = 0; i < n; i++) {
            int max = 0;
            for (int j = 0; j < i; j++) {
                int val = arr[i] - arr[j];
                if (val == 1 || val == -1) {
                    max = Math.max(max, dp[j]);
                }
            }
            dp[i] = max + 1;
            maxlen = Math.max(maxlen, dp[i]);
        }
        return maxlen;
    }

    // TC : O(n)
    // SC : O(n)
    static int longestSubsequence1(int n, int[] arr) {
        int res = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int val : arr) {
            int len = 0;
            if (map.containsKey(val - 1))
                len = map.get(val - 1);
            if (map.containsKey(val + 1) && map.get(val + 1) > len) {
                len = map.get(val + 1);
            }
            map.put(val, len + 1);
            res = Math.max(res, len + 1);
        }

        return res;
    }
}
