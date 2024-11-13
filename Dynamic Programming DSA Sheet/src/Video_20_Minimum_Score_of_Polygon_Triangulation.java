public class Video_20_Minimum_Score_of_Polygon_Triangulation {
    // https://leetcode.com/problems/minimum-score-triangulation-of-polygon/
    public int minScoreTriangulation(int[] values) {
        int[][] dp = new int[values.length][values.length];
        for (int g = 0; g < dp[0].length; g++) {
            for (int i = 0, j = g; j < dp[0].length; i++, j++) {
                if (g == 0) {
                    dp[i][j] = 0;
                } else if (g == 1) {
                    dp[i][j] = 0;
                } else if (g == 2) {
                    dp[i][j] = values[i] * values[i + 1] * values[i + 2];
                } else {
                    int min = Integer.MAX_VALUE;
                    for (int k = i + 1; k <= j - 1; k++) {
                        int trie = values[i] * values[k] * values[j];
                        int left = dp[i][k];
                        int right = dp[k][j];
                        min = Math.min(min, trie + left + right);
                    }
                    dp[i][j] = min;
                }
            }
        }
        return dp[0][values.length - 1];
    }
}
