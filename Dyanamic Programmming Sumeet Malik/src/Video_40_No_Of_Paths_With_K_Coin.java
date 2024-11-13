//
// https://practice.geeksforgeeks.org/problems/number-of-paths-in-a-matrix-with-k-coins2728/1

import java.util.ArrayList;

public class Video_40_No_Of_Paths_With_K_Coin {
    long numberOfPath(int N, int K, int[][] arr) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(0);
        dfs(0, 0, arr[0][0], K, arr, list);
        return list.get(0);
    }

    void dfs(int i, int j, int coins, int k, int[][] arr, ArrayList<Integer> list) {
        if (i == arr.length - 1 && j == arr[0].length - 1) {
            if (coins == k)
                list.set(0, list.get(0) + 1);
            return;

        }

        if (isValid(i + 1, j, arr))
            dfs(i + 1, j, coins + arr[i + 1][j], k, arr, list);
        if (isValid(i, j + 1, arr))
            dfs(i, j + 1, coins + arr[i][j + 1], k, arr, list);

    }

    boolean isValid(int i, int j, int[][] arr) {
        return i >= 0 && j >= 0 && i < arr.length && j < arr.length;
    }


    // DP
    long[][][] dp = new long[101][101][101];

    long func(int n, int i, int j, int k, int[][] arr) {
        if (k < 0)
            return 0;

        if (i > n || j > n) {
            return 0;
        }


        if (dp[i][j][k] != -1) {

            return dp[i][j][k];
        }
        if (i == n && j == n) {
            if (k == arr[i][j]) {
                return 1;
            }
            return 0;
        }
        return dp[i][j][k] = func(n, i + 1, j, k - arr[i][j], arr) + func(n, i, j + 1, k - arr[i][j], arr);
    }

    long numberOfPath1(int n, int K, int[][] arr) {

        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp.length; j++) {
                for (int k = 0; k < dp.length; k++) {
                    dp[i][j][k] = -1;
                }
            }
        }
        return func(n - 1, 0, 0, K, arr);
    }
}
