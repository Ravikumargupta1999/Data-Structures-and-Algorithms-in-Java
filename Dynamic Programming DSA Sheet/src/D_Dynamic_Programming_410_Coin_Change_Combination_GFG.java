import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

// https://www.youtube.com/watch?v=l_nR5X9VmaI&list=PL-Jc9J83PIiG8fE6rj9F5a6uyQ5WPdqKy&index=13

//
public class D_Dynamic_Programming_410_Coin_Change_Combination_GFG {

    //https://practice.geeksforgeeks.org/problems/coin-change2448/1
    // Total No of ways
    public long count(int[] coins, int N, int amount) {
        long[] dp = new long[(int) amount + 1];
        dp[0] = 1;
        for (int i = 0; i < coins.length; i++) {
            for (int j = coins[i]; j < dp.length; j++) {
                dp[j] = dp[j] + dp[(j - coins[i])];
            }
        }
        return dp[amount];
    }


    // Min Coins
    // https://practice.geeksforgeeks.org/problems/number-of-coins1824/1
    // https://practice.geeksforgeeks.org/problems/min-coin5549/1
    // https://practice.geeksforgeeks.org/problems/min-coin5549/1
    // https://practice.geeksforgeeks.org/problems/number-of-coins1824/1#
    // https://leetcode.com/problems/coin-change/
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, -1);
        dp[0] = 0;

        for (int i = 1; i <= amount; i++) {
            int min = Integer.MAX_VALUE;
            for (int coin : coins) {
                if (coin <= i) {
                    if (dp[i - coin] != -1)
                        min = Math.min(min, dp[i - coin]);
                }
            }
            if(min != Integer.MAX_VALUE)
                dp[i] = min+1;
        }
        return dp[amount];
    }

    // https://practice.geeksforgeeks.org/problems/-minimum-number-of-coins4426/1#
    static List<Integer> minPartition(int amount) {
        int[] nums = {1, 2, 5, 10, 20, 50, 100, 200, 500, 2000};

        Pair[] dp = new Pair[amount + 1];

        for (int i = 0; i < dp.length; i++) {
            dp[i] = new Pair();
        }


        for (int num : nums) {


            for (int j = num; j < dp.length; j++) {
//                System.out.print(j + "   " + dp[j].temp + "   ");
                List<Integer> temp1 = new ArrayList<>(dp[j].temp);
                List<Integer> temp2 = new ArrayList<>();


                if (j - num == 0) {
                    temp2.add(num);

                } else {
                    if (dp[j - num].temp.size() == 0) {

                    } else {
                        temp2 = new ArrayList<>(dp[j - num].temp);
                        temp2.add(num);
                    }
                }
                if (temp1.size() == 0 && temp2.size() == 0) {
                    dp[j].temp = new ArrayList<>(temp1);
                } else if (temp1.size() == 0) {
                    dp[j].temp = new ArrayList<>(temp2);
                } else if (temp2.size() == 0) {
                    dp[j].temp = new ArrayList<>(temp1);
                } else {
                    if (temp1.size() > temp2.size()) {
                        dp[j].temp = new ArrayList<>(temp2);
                    } else {
                        dp[j].temp = new ArrayList<>(temp1);
                    }
                }


            }


        }

        Collections.sort(dp[amount].temp, (a, b) -> b - a);
        return dp[amount].temp;
    }

    static class Pair {
        List<Integer> temp = new ArrayList<>();

    }

    public static void main(String[] args) {
        System.out.println(minPartition(43));
    }


}