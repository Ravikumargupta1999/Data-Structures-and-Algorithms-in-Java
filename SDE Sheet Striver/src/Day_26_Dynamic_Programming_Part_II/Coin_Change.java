package Day_26_Dynamic_Programming_Part_II;

import java.lang.reflect.Array;
import java.util.Arrays;

public class Coin_Change {
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, -1);
        dp[0] = 0;

        for (int i = 1; i <= amount; i++) {
            int min = Integer.MAX_VALUE;
            for (int j = 0; j < coins.length; j++) {
                if (coins[j] > i)
                    continue;
                if (dp[i - coins[j]] != -1)
                    min = Math.min(min, dp[i - coins[j]]);
            }
            dp[i] = min == Integer.MAX_VALUE ? dp[i] : 1 + min;
        }
        return dp[amount];

    }
}
