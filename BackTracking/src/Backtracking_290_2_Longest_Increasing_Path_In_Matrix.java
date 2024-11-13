
public class Backtracking_290_2_Longest_Increasing_Path_In_Matrix {


    // https://practice.geeksforgeeks.org/problems/longest-path-in-a-matrix3019/1
    // https://www.youtube.com/watch?v=cZlHLMxIOMI

    static int[][] dir = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
    public static int longestIncreasingPath(int[][] matrix) {

        int[][] dp = new int[matrix.length][matrix[0].length];
        if (matrix.length == 0)
            return 0;
        int res = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                res = Math.max(res, dfs(i, j, matrix, dp));
            }
        }
        return res;
    }

    public static int dfs(int x, int y, int[][] matrix, int[][] dp) {
        if (dp[x][y] != 0)
            return dp[x][y];

        int ans = 1;
        for (int i = 0; i < 4; i++) {
            int X = x + dir[i][0];
            int Y = y + dir[i][1];
            if (X < 0 || X >= matrix.length || Y < 0 || Y >= matrix[0].length)
                continue;
            if (matrix[X][Y] <= matrix[x][y])
                continue;
            ans = Math.max(ans, 1 + dfs(X, Y, matrix, dp));
        }
        return dp[x][y] = ans;
    }
}
