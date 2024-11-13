public class Video_26_Coin_Change_Problem_Recursion_Part_2 {

    // https://practice.geeksforgeeks.org/problems/coin-change2448/1#
    long count = 0;

    public long count(int[] coins, int m, int amt) {

        coinChange(0, coins, 0, amt);
        return count;
    }

    public void coinChange(int i, int[] coins, int amtSoFar, int totalAmt) {
        if (i == coins.length) {
            if (amtSoFar == totalAmt)
                count++;
            return;
        }
        for (int j = totalAmt / coins[i]; j >= 1; j--) {
//            String part = "";
//            for (int k = 0; k < j; k++) {
//                part += coins[i] + "-";
//            }
            coinChange(i + 1, coins, amtSoFar + coins[i] * j, totalAmt);
        }
        coinChange(i + 1, coins, amtSoFar, totalAmt);
    }

    //  https://leetcode.com/problems/coin-change-2/

    int total = 0;

    public int change(int amount, int[] coins) {
        coinChang(0, coins, 0, amount);
        return total;
    }

    public void coinChang(int i, int[] coins, int amtSoFar, int totalAmt) {
        if (i == coins.length) {
            if (amtSoFar == totalAmt)
                total++;
            return;
        }
        for (int j = totalAmt / coins[i]; j >= 1; j--) {
//            String part = "";
//            for (int k = 0; k < j; k++) {
//                part += coins[i] + "-";
//            }
            coinChang(i + 1, coins, amtSoFar + coins[i] * j, totalAmt);
        }
        coinChang(i + 1, coins, amtSoFar, totalAmt);
    }
}
