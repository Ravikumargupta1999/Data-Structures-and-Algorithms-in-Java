public class Video_56_Stone_Game_VII {
    // https://leetcode.com/problems/stone-game-vii/
    int[] pre;
    public int stoneGameVII(int[] stones) {
        int n = stones.length;
        pre = new int[n];
        pre[0] = stones[0];
        for (int i = 1; i < n; i++) {
            pre[i] = pre[i - 1] + stones[i];
        }
        return rec(stones, 0, n - 1, new int[n][n]);
    }

    public int rec(int[] stones, int i, int j, int[][] dp) {
        if (i >= j)
            return 0;
        if (i + 1 == j)
            return Math.max(stones[i], stones[j]);
        if (dp[i][j] != 0)
            return dp[i][j];
        return dp[i][j] = Math.max(pre[j] - pre[i] - rec(stones, i + 1, j, dp), pre[j - 1] - (i == 0 ? 0 : pre[i - 1]) - rec(stones, i, j - 1, dp));
    }


    public int stoneGameVII1(int[] stones) {
        int n = stones.length;
        int[] pre = new int[n];
        pre[0] = stones[0];
        for (int i = 1; i < n; i++) {
            pre[i] = pre[i - 1] + stones[i];
        }
        int[][] dp = new int[n][n];
        for(int i=n-1;i>=0;i--)
        {
            for(int j=0;j<n;j++)
            {
                if( i >=j)
                {
                    dp[i][j] = 0;
                }
                else if( i+1 == j)
                {
                    dp[i][j] = Math.max(stones[i],stones[j]);
                }
                else
                {
                    dp[i][j] = dp[i][j] = Math.max(pre[j] - pre[i] - dp[i + 1] [j], pre[j - 1] - (i == 0 ? 0 : pre[i - 1]) - dp [i][j - 1]);
                }
            }
        }
        return dp[0][n-1];
    }

}
