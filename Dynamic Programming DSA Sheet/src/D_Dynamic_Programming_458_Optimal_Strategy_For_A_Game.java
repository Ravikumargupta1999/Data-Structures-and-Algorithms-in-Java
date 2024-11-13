//import javafx.util.Pair;

import java.util.Arrays;

public class D_Dynamic_Programming_458_Optimal_Strategy_For_A_Game {
    // https://practice.geeksforgeeks.org/problems/optimal-strategy-for-a-game-1587115620/1
    // https://www.youtube.com/watch?v=ww4V7vRIzSk
    public static long maximumAmount(int[] arr, int n) {
        long[] longArray = Arrays.stream(arr).mapToLong(i -> i).toArray();
        long[][] dp = new long[(int) n][(int) n];

        for (long g = 0; g < dp.length; g++) {
            for (long i = 0, j = g; j < dp.length; j++, i++) {
                if (g == 0)
                    dp[(int) i][(int) j] = longArray[(int) i];
                else if (g == 1)
                    dp[(int) i][(int) j] = Math.max(longArray[(int) i], longArray[(int) j]);
                else {
                    long val1 = longArray[(int) i] + Math.min(dp[(int) i + 2][(int) j], dp[(int) i + 1][(int) j - 1]);
                    long val2 = longArray[(int) j] + Math.min(dp[(int) i + 1][(int) j - 1], dp[(int) i][(int) j - 2]);
                    long val = Math.max(val1, val2);
                    dp[(int) i][(int) j] = val;

                }

            }
        }
        return dp[0][longArray.length - 1];
    }

    // https://practice.geeksforgeeks.org/problems/max-possible-amount2717/1?page=4&company[]=Amazon&category[]=Dynamic%20Programming&sortBy=submissions
    int maxAmount(int arr[], int n) {
        int[][] dp = new int[n][n];

        for (int g = 0; g < dp.length; g++) {
            for (int i = 0, j = g; j < dp.length; j++, i++) {
                if (g == 0)
                    dp[i][j] = arr[i];
                else if (g == 1)
                    dp[i][j] = Math.max(arr[i], arr[j]);
                else {
                    int val1 = arr[i] + Math.min(dp[i + 2][j], dp[i + 1][j - 1]);
                    int val2 = arr[j] + Math.min(dp[i + 1][j - 1], dp[i][j - 2]);
                    int val = Math.max(val1, val2);
                    dp[i][j] = val;

                }

            }
        }
        return dp[0][arr.length - 1];
    }
}

