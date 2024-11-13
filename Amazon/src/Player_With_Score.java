//https://practice.geeksforgeeks.org/problems/player-with-max-score/0/
public class Player_With_Score {
    static Boolean is1winner(int n, int arr[]) {
        int[][] dp = new int[arr.length][arr.length];
        for (int g = 0; g < dp.length; g++) {
            for (int i = 0, j = g; j < dp.length; i++, j++) {
                if (g == 0) {
                    dp[i][j] = arr[j];
                } else if (g == 1) {
                    dp[i][j] = Math.max(arr[i], arr[j]);

                } else {
                    int val1 = arr[i] + Math.min(dp[i + 2][j], dp[i + 1][j - 1]);
                    int val2 = arr[j] + Math.min(dp[i + 1][j - 1], dp[i][j - 2]);
                    int val = Math.max(val1, val2);
                    dp[i][j] = val;
                }
            }
        }
        int sum = 0;
        for (int i = 0; i < arr.length; i++)
            sum += arr[i];
//        System.out.println(sum);
//        System.out.println(dp[0][arr.length - 1]);
        if (dp[0][arr.length - 1] > sum - dp[0][arr.length - 1])
            return true;
        else
            return false;

    }

    public static void main(String[] args) {
        int[] arr = {1, 1, 2, 2, 3, 4, 5, 5, 6, 7};
        System.out.println(is1winner(arr.length,arr));
    }
}
