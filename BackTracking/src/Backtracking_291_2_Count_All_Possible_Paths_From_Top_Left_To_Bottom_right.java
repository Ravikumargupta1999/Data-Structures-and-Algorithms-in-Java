
// https://practice.geeksforgeeks.org/problems/count-all-possible-paths-from-top-left-to-bottom-right3011/1
public class Backtracking_291_2_Count_All_Possible_Paths_From_Top_Left_To_Bottom_right {
    long numberOfPaths(int m, int n) {
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

}
