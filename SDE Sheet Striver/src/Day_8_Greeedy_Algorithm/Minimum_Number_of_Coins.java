package Day_8_Greeedy_Algorithm;

import java.util.Arrays;

public class Minimum_Number_of_Coins {
    // https://practice.geeksforgeeks.org/problems/number-of-coins1824/1
    // DP
    public int minCoins(int[] coins, int M, int V) {
        int[] dp = new int[V + 1];
        Arrays.fill(dp, -1);
        dp[0] = 0;
        for (int i = 1; i <= V; i++) {
            int min = Integer.MAX_VALUE;
            for (int coin : coins) {
                if (coin > i)
                    continue;
                if (dp[i - coin] != -1) {
                    min = Math.min(min, dp[i - coin]);
                }
            }
            if (min != Integer.MAX_VALUE)
                dp[i] = min + 1;
        }
        return dp[V];
    }

    public int minCoins1(int[] coins, int M, int V) {
        // wont work for all cases
        Arrays.sort(coins);
        int count = 0;
        for (int i = coins.length - 1; i >= 0; i--) {

            while (V >= coins[i]) {
                count++;
                V -= coins[i];
            }
        }
        return count;
    }
}
