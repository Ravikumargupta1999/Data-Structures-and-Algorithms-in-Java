package Recursion;

public class Rate_With_Multiple_Jumps_Gfg {
    int N;
    void printSolution(int sol[][]) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.printf(" %d ", sol[i][j]);
            }
            System.out.printf("\n");
        }
    }

    boolean isSafe(int maze[][], int x, int y) {
        if (x >= 0 && x < N && y >= 0 &&
                y < N && maze[x][y] != 0) {
            return true;
        }
        return false;
    }

    public int[][] ShortestDistance(int[][] matrix) {
        N = matrix.length;
        int sol[][] = new int[matrix.length][matrix[0].length];
        if (solveMazeUtil(matrix, 0, 0, sol) == false) {
            int[][] temp = new int[1][1];
            temp[0][0] = -1;
            return temp;
        }
        printSolution(sol);
        return sol;
    }
    boolean solveMazeUtil(int maze[][], int x, int y, int sol[][]) {
        if (x == N - 1 && y == N - 1) {
            sol[x][y] = 1;
            return true;
        }
        if (isSafe(maze, x, y)) {
            sol[x][y] = 1;
            for (int i = 1; i <= maze[x][y] && i < N; i++) {
                if (solveMazeUtil(maze, x + i, y, sol)) {
                    return true;
                }
                if (solveMazeUtil(maze, x, y + i, sol)) {
                    return true;
                }
            }

            sol[x][y] = 0;
            return false;
        }
        return false;
    }

}
