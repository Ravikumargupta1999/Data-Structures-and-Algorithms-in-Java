
public class D_Dynamic_Programming_410_Coin_Change_Permutation_GFG {
    //
    // https://www.youtube.com/watch?v=yc0LunmJA1A
    public static int change(int amount, int[] coins) {
        int[] dp = new int[amount + 1];
        dp[0] = 1;
        for (int tar = 1; tar <= amount; tar++) {
            for (int coin : coins) {
                if (coin <= tar) {
                    dp[tar] += dp[tar - coin];
                }
            }
        }
        return dp[amount];
    }

    public static void main(String[] args) {
        int[] coins = {1, 1, 1, 1, 1};
        System.out.println(change(3,coins));
    }
}
