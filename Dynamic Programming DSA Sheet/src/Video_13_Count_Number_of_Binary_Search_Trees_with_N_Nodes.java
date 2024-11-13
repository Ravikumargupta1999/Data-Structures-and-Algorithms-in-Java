public class Video_13_Count_Number_of_Binary_Search_Trees_with_N_Nodes {
    // https://leetcode.com/problems/unique-binary-search-trees/
    // Leetcode
    public int numTrees(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            int l = 0;
            int r = i - 1;
            while (l <= i - 1) {
                dp[i] += (dp[l] * dp[r]);
                l++;
                r--;
            }
        }

        return dp[n];
    }

    // https://practice.geeksforgeeks.org/problems/unique-bsts-1587115621/1
    // https://practice.geeksforgeeks.org/problems/dyck-path1028/1
    // Gfg
    static int numTrees1(int n) {
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
        int v = (int) dp[n];
        return v;
    }
}
