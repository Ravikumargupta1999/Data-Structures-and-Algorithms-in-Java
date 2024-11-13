package Recursion;

public class Rat_Maze_With_Multiple_Jumps {
    public int[][] ShortestDistance(int[][] matrix) {
        int[][] ans = new int[matrix.length][matrix[0].length];
        if (solveMaze(matrix, 0, 0, ans)) {
            int[][] temp = new int[1][1];
            temp[0][0] = -1;
            return temp;
        }
        return ans;
    }

    public boolean isSafe(int row, int col, int[][] maze) {
        if (row >= 0 && row < maze.length && col >= 0 && col < maze.length && maze[row][col] != 0) {
            return true;
        }
        return false;
    }

    public boolean solveMaze(int[][] matrix, int row, int col, int[][] ans) {
        if (row == matrix.length - 1 && col == matrix.length - 1) {
            ans[row][col] = 1;
            return true;
        }
        if (isSafe(row, col, matrix)) {
            ans[row][col] = 1;
            int val = matrix[row][col];
            for (int i = 1; i <= val; i++) {
                if (solveMaze(matrix, row + i, col, ans)) {
                    return true;
                }
                if (solveMaze(matrix, row, col + 1, ans)) {
                    return true;
                }
            }
            ans[row][col] = 0;
            return false;
        }
        return false;
    }
}
