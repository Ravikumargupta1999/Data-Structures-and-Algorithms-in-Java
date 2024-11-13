// https://leetcode.com/problems/unique-binary-search-trees/submissions/
// https://practice.geeksforgeeks.org/problems/unique-bsts-1587115621/1
class Video_31_Unique_BST {
    static int numTrees(int n) {
        int p = 1000000007;
        long[] dp = new long[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            int l = 0;
            int r = i - 1;
            while (l <= i - 1) {
                dp[i] = (dp[i] + (dp[l] * dp[r]) % p) % p;

                l++;
                r--;
            }
        }
        return (int) dp[n];

    }

}
