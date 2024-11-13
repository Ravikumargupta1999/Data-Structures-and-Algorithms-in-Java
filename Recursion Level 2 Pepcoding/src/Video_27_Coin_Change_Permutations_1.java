import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Video_27_Coin_Change_Permutations_1 {
    // https://www.youtube.com/watch?v=aqepijUkV6w&list=PLcg9PGsf43LgHt0T0-k3Rn3NyxBSxBtA0&index=40
    public static void coinChange(int[] coins, int amountSoFar, int totalAmount, String asf, boolean[] used) {
        if (amountSoFar > totalAmount)
            return;
        if (amountSoFar == totalAmount) {
            System.out.println(asf + ".");
            return;
        }
        for (int i = 0; i < coins.length; i++) {
            if (!used[i]) {
                used[i] = true;
                coinChange(coins, amountSoFar + coins[i], totalAmount, asf + coins[i] + "-", used);
                used[i] = false;
            }
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] coins = new int[n];
        for (int i = 0; i < n; i++) {
            coins[i] = Integer.parseInt(br.readLine());
        }
        int amt = Integer.parseInt(br.readLine());
        boolean[] used = new boolean[coins.length];
        coinChange(coins, 0, amt, "", used);
    }
}
//5
//        2
//        3
//        5
//        6
//        7
//        12