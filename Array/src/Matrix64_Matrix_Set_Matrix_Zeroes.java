import java.util.LinkedList;
import java.util.Queue;

public class Matrix64_Matrix_Set_Matrix_Zeroes {
    // https://leetcode.com/problems/set-matrix-zeroes/submissions/
    class Pair {
        int val;
        int row;
        int col;

        Pair(int val, int row, int col) {
            this.val = val;
            this.row = row;
            this.col = col;
        }

    }

    public void setZeroes(int[][] matrix) {
        Queue<Pair> queue = new LinkedList<>();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    queue.add(new Pair(0, i, j));
                }
            }
        }
        while (!queue.isEmpty()) {
            Pair p = queue.poll();
            dfs(matrix, p.row, p.col + 1, 0);
            dfs(matrix, p.row + 1, p.col, 1);
            dfs(matrix, p.row, p.col - 1, 2);
            dfs(matrix, p.row - 1, p.col, 3);
        }
    }

    public  void dfs(int[][] matrix, int row, int col, int val) {
        if (row < 0 || row >= matrix.length || col < 0 || col >= matrix[0].length)
            return;
        matrix[row][col] = 0;
        if (val == 0) {
            dfs(matrix, row, col + 1, 0);
        } else if (val == 1) {
            dfs(matrix, row + 1, col, 1);
        } else if (val == 2) {
            dfs(matrix, row, col - 1, 2);
        } else if (val == 3) {
            dfs(matrix, row - 1, col, 3);
        }
    }
}
