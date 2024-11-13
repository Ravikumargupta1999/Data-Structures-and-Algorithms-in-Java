public class Backtracking_275_Rate_In_Maze_With_Multiple_Jumps {
    // https://practice.geeksforgeeks.org/problems/rat-maze-with-multiple-jumps3852/1#
    public boolean isSafe(int[][] matrix, int x, int y) {
        if (x >= matrix.length || y >= matrix[0].length || matrix[x][y] == 0)
            return false;
        return true;
    }

    public boolean solve(int[][] mat, int[][] res, int x, int y, int n) {
        if (x == n - 1 && y == n - 1) {
            res[x][y] = 1;
            return true;
        }
        if (isSafe(mat, x, y)) {
            res[x][y] = 1;
            for (int i = 1; i <= mat[x][y] && i < n; i++) {
                if (solve(mat, res, x, y + i, n)) {
                    return true;
                }
                if (solve(mat, res, x + i, y, n)) {
                    return true;
                }
            }
            res[x][y] = 0;
            return false;
        }
        return false;
    }

    public int[][] ShortestDistance(int[][] matrix) {
        int n = matrix.length;
        if (n == 1) {
            return new int[][]{{1}};
        }
        if (n == 0 || matrix[0][0] == 0)
            return new int[][]{{-1}};
        int[][] res = new int[matrix.length][matrix[0].length];
        solve(matrix, res, 0, 0, n);
        return res;
    }


}
