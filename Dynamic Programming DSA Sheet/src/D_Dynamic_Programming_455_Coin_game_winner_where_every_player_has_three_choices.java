

// https://practice.geeksforgeeks.org/problems/geek-and-its-game-of-coins4043/1/#
// https://www.geeksforgeeks.org/coin-game-winner-every-player-three-choices/
// https://www.youtube.com/watch?v=yHM16Ln7eGM&t=392s
public class D_Dynamic_Programming_455_Coin_game_winner_where_every_player_has_three_choices {

    // Wrong Solution
//    public static int findWinne1(int n, int x, int y) {
//        int[] arr = new int[3];
//        arr[0] = 1;
//        arr[1] = x;
//        arr[2] = y;
//        boolean flag = true;
//        while (n >= 1) {
////            System.out.println(n);
//            for (int i = arr.length - 1; i >= 0; i--) {
//                if (arr[i] <= n) {
//                    n = n - arr[i];
//                    break;
//                }
//            }
//            System.out.println(n+"   "+flag);
//            if (n < 1)
//                return flag == true ? 1 : 0;
//            flag = !flag;
//        }
//        System.out.println("Hello");
//        return 0;
//
//    }

    // https://www.youtube.com/watch?v=uXqoNkv_Iv0
    public int findWinner(int n, int x, int y) {
        boolean[] dp = new boolean[n + 1];
        dp[0] = false;
        if (n == 0)
            return dp[n] == true ? 1 : 0;
        dp[1] = true;
        if (n == 1)
            return dp[n] == true ? 1 : 0;
        for (int i = 2; i <= n; i++) {
            if ((i - 1) >= 0 && !dp[i - 1]) {
                dp[i] = true;
            } else if ((i - x) >= 0 && !dp[i - x]) {
                dp[i] = true;
            } else if ((i - y) >= 0 && !dp[i - y]) {
                dp[i] = true;
            } else {
                dp[i] = false;
            }
        }
        return dp[n] == true ? 1 : 0;
    }


}
