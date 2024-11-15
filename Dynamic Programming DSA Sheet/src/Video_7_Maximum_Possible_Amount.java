import java.util.Arrays;

public class Video_7_Maximum_Possible_Amount {
    int maxAmount(int[] arr, int n) {

        int[][] dp = new int[n][n];

        for (int g = 0; g < dp.length; g++) {
            for (int i = 0, j = g; j < dp.length; j++, i++) {
                if (g == 0)
                    dp[i][j] = arr[ i];
                else if (g == 1)
                    dp[i][j] = Math.max(arr[i], arr[j]);
                else {
                    int val1 = arr[ i] + Math.min(dp[i + 2][j], dp[i + 1][ j - 1]);
                    int val2 = arr[j] + Math.min(dp[ i + 1][ j - 1], dp[ i][ j - 2]);
                    int val = Math.max(val1, val2);
                    dp[i][j] = val;

                }

            }
        }
        return dp[0][arr.length - 1];
    }
}
