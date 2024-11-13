public class Video_21_Otimal_Binary_Search_Tree {
    // https://practice.geeksforgeeks.org/problems/optimal-binary-search-tree2214/1
    // https://www.youtube.com/watch?v=HnslzEs8dbY&list=PL-Jc9J83PIiEZvXCn-c5UIBvfT8dA-8EG&index=26
    static int optimalSearchTree(int keys[], int freq[], int n)
    {
        int[][] dp = new int[n][n];
        int[] psa = new int[n];
        psa[0] = freq[0];
        for (int i = 1; i < n; i++)
            psa[i] = psa[i - 1] + freq[i];
        for (int g = 0; g < dp.length; g++) {
            for (int i = 0, j = g; j < n; j++, i++) {
                if (g == 0) {
                    dp[i][j] = freq[i];
                } else if (g == 1) {
                    int f1 = freq[i];
                    int f2 = freq[j];
                    dp[i][j] = Math.min(f1 + 2 * f2, f2 + 2 * f1);
                } else {
                    int min = Integer.MAX_VALUE;
                    int fs = 0;
                    for (int x = i; x <= j; x++) {
                        fs += freq[x];
                    }
                    // int fs = psa[j] - (i == 0 ? 0 : psa[i - 1]);
                    for (int k = i; k <= j; k++) {
                        int left = k == i ? 0 : dp[i][k - 1];
                        int right = k == j ? 0 : dp[k + 1][j];
                        min = Math.min(min, left + fs + right);
                    }
                    dp[i][j] = min;
                }
            }
        }
        return dp[0][n - 1];
    }
}
