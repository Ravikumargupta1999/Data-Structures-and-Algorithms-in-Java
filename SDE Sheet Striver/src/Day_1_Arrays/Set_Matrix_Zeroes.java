package Day_1_Arrays;

import java.util.LinkedList;
import java.util.Queue;

public class Set_Matrix_Zeroes {
    public static void main(String[] args) {
        int[][] arr = {{1,2,3,4},{5,0,5,2},{8,9,2,0},{5,7,2,1}};
        Set_Matrix_Zeroes a = new Set_Matrix_Zeroes();
        a.setZeroes(arr);

        for (int[] array : arr) {
            for (int val : array) {
                System.out.print(val + "\t");
            }
            System.out.println();
        }
    }
    public void setZeroes(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        boolean[][] visited = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                callDFS(i, j, n, m, matrix, visited);
            }
        }
    }

    public void callDFS(int i, int j, int n, int m, int[][] matrix, boolean[][] visited) {
        if (!visited[i][j] && matrix[i][j] == 0) {

            checkDfs(i, j, n, m, matrix, visited, 1);
            checkDfs(i, j, n, m, matrix, visited, 2);
            checkDfs(i, j, n, m, matrix, visited, 3);
            checkDfs(i, j, n, m, matrix, visited, 4);
        }
    }

    public void checkDfs(int i, int j, int n, int m, int[][] matrix, boolean[][] visited, int dir) {
        visited[i][j] = true;
        if (dir == 1) {

            if (isValid(i, j + 1, n, m)) {
                if (matrix[i][j + 1] == 0 && !visited[i][j+1]) {
                    callDFS(i, j + 1, n, m, matrix, visited);
                } else {

                    matrix[i][j + 1] = 0;
                    checkDfs(i, j + 1, n, m, matrix, visited, 1);
                }
            }
        } else if (dir == 2) {

            if (isValid(i + 1, j, n, m)) {
                if (matrix[i + 1][j] == 0  && !visited[i+1][j]) {
                    callDFS(i + 1, j, n, m, matrix, visited);
                } else {
                    matrix[i+1][j] = 0;
                    checkDfs(i +1, j, n, m, matrix, visited, dir);
                }
            }
        } else if (dir == 3) {
            if (isValid(i, j - 1, n, m) ) {
                if (matrix[i][j - 1] == 0 && !visited[i][j-1]) {
                    callDFS(i, j - 1, n, m, matrix, visited);
                } else {

                    matrix[i][j - 1] = 0;
                    checkDfs(i, j - 1, n, m, matrix, visited, dir);
                }
            }

        } else if (dir == 4) {

            if (isValid(i - 1, j, n, m)) {
                if (matrix[i - 1][j] == 0  && !visited[i-1][j]) {
                    callDFS(i - 1, j, n, m, matrix, visited);
                } else {
                    matrix[i-1][j] = 0;
                    checkDfs(i - 1, j, n, m, matrix, visited, dir);
                }
            }
        }
    }

    public boolean isValid(int i, int j, int n, int m) {
        if (i < 0 || j < 0 || i >= n || j >= m)
            return false;
        return true;
    }



    // Solution 2

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

    public void setZeroes1(int[][] matrix) {
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

    public void dfs(int[][] matrix, int row, int col, int val) {
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
