package Sumit_Malik_Level_2;

import java.util.Arrays;

// https://www.youtube.com/watch?v=46zD5d9y9b4
// https://practice.geeksforgeeks.org/problems/count-all-possible-paths-from-top-left-to-bottom-right3011/1#
public class V_Video_4_Find_No_Paths_In_N_M_Matrix {
    // TLE Recursion
//    long numberOfPaths(int m, int n) {
//        return find(1, 1, m, n);
//    }
//
//    long find(int i, int j, int m, int n) {
//        if (i == m || j == n) {
//            return 1;
//        }
//        if (i > m || j > n)
//            return 0;
//        return find(i + 1, j, m, n) + find(i, j + 1, m, n);
//    }


    // https://practice.geeksforgeeks.org/problems/count-all-possible-paths-from-top-left-to-bottom-right3011/1#
    // Memoization
    static long numberOfPaths(int m, int n) {
        long[][] dp = new long[m + 1][n + 1];
        for (long[] arr : dp)
            Arrays.fill(arr, -1);
        return find(1, 1, m, n, dp);
    }

    static long find(int i, int j, int m, int n, long[][] dp) {
        int mod = (int) 1e9 + 7;
        if (i == m || j == n) {
            return 1;
        }
        if (i > m || j > n)
            return 0;
        if (dp[i][j] != -1)
            return dp[i][j];
        return dp[i][j] = (find(i + 1, j, m, n, dp) % mod + find(i, j + 1, m, n, dp) % mod) % mod;
    }

    // DP Approach
    static long numberOfPaths3(int m, int n) {
        if (m == 1 || n == 1)
            return 1;
        int mod = (int) 1e9 + 7;
        long[][] dp = new long[m][n];
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                if (i == m - 1 || j == n - 1) {
                    dp[i][j] = 1;
                } else {
                    dp[i][j] = (dp[i + 1][j] % mod + dp[i][j + 1] % mod) % mod;
                }
            }
        }
        return dp[0][0];
    }


    public static void main(String[] args) {
        System.out.println(numberOfPaths(19, 71));
    }
}
