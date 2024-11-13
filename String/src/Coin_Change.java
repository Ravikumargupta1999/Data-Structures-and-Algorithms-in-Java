public class Coin_Change {
    public static int CoinDeterMiner(int n) {
        int arr[] = {1, 5, 7, 9, 11};
        int[] dp = new int[n + 1];
        for (int i = 1; i < dp.length; i++)
            dp[i] = -1;
        for (int i = 1; i < dp.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                if (i - arr[j] >= 0) {
                    if (dp[i - arr[j]] >= 0) {
                        int temp = 1 + dp[i - arr[j]];
                        if (dp[i] < 0)
                            dp[i] = temp;
                        else {
                            if (dp[i] >= temp)
                                dp[i] = temp;
                        }
                    }
                }
            }

        }
        return dp[n];
    }

    public static void main(String[] args) {
        System.out.println(CoinDeterMiner(16));
    }
}
