package Recursion;

import java.util.HashSet;

public class Recursion_19_Special_Matrix {
    // https://practice.geeksforgeeks.org/problems/special-matrix4201/1/#
    public int FindWays(int n, int m, int[][] blocked_cells) {
        int mod = 1000000007;
        HashSet<String> set = new HashSet<>();
        for (int[] v : blocked_cells)
            set.add(v[0] + "" + v[1]);
        return totalWays(1, 1, n, m, set) % mod;
    }

    public int totalWays(int row, int col, int n, int m, HashSet<String> set) {
        int mod = 1000000007;
        if (row > n || col > m || set.contains(row + "" + col))
            return 0;
        if (row == n && col == m)
            return 1;
        int total = 0;
        total += totalWays(row + 1, col, n, m, set) % mod;
        total += totalWays(row, col + 1, n, m, set) % mod;
        return total % mod;
    }

    //  https://practice.geeksforgeeks.org/problems/special-matrix4201/1/#
    public int FindWaysTotal(int n, int m, int[][] blocked_cells) {
//        int mod = 1000000007;
//        HashSet<String> set = new HashSet<>();
//        for (int[] v : blocked_cells)
//            set.add((v[0] - 1) + "" + (v[1] - 1));
//
//        int[][] dp = new int[n][m];
//
//        for (int i = n - 1; i >= 0; i--) {
//            for (int j = m - 1; j >= 0; j--) {
//                if (set.contains(i + "" + j)) {
//                    continue;
//                }
//                if (i == n - 1 && j == n - 1) {
//                    dp[i][j] = 1;
//                } else if (i == n - 1) {
//                    dp[i][j] = dp[i][j + 1];
//                } else if (j == m - 1) {
//                    dp[i][j] = dp[i + 1][j];
//                } else {
//                    dp[i][j] = dp[i][j + 1] + dp[i + 1][j];
//                }
//            }
//        }
//        return dp[0][0] % mod;
        int arr[][] = new int[n][m];
        int dp[][] = new int[n][m];
        int i,j;

        int mod=1000000007;

        for(i = 0; i<blocked_cells.length;i++)
        {
            for(j=0; j <2; j++)
            {
                int x = blocked_cells[i][0]-1; //Obtaining Cell's Coordinates & Converting To 0-Based Indexing
                int y = blocked_cells[i][1]-1;

                arr[x][y] = -1; //Putting a marker that a position is blocked.
            }
        }

        for(i = 0; i<n;i++)
        {
            for(j=0;j<m;j++)
            {
                if(arr[i][j] == -1)
                {
                    dp[i][j] = 0;
                }

                else if((i==0) && (j==0))
                {
                    dp[i][j] = 1;
                }

                else
                {
                    int up = 0, left = 0;

                    if(i>0)
                    {
                        up = dp[i-1][j];
                    }

                    if(j>0)
                    {
                        left = dp[i][j-1];
                    }

                    dp[i][j] = up+left; //Total No. Of Ways To Reach (i,j)
                }
            }
        }

        return dp[n-1][m-1]%mod; //Total
    }
}
