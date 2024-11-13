package Day_10_Recursion_and_Backtracking;

import java.io.ByteArrayInputStream;
import java.util.ArrayList;
import java.util.List;

public class Rat_In_A_Maze_Problem {
    public static ArrayList<String> findPath(int[][] matrix, int n) {
        if (matrix[n - 1][n - 1] == 0)
            return new ArrayList<>();
        ArrayList<String> list = new ArrayList<>();
        boolean[][] visited = new boolean[n][n];
        printPaths(0, 0, n, matrix, "", visited, list);
        return list;
    }

    public static void printPaths(int i, int j, int n, int[][] matrix, String res, boolean[][] visited, ArrayList<String> list) {
        if (i < 0 || i >= n || j < 0 || j >= n || matrix[i][j] == 0 || visited[i][j]) {
            return;
        }
        if (i == n - 1 && j == n - 1) {
            list.add(res);
            return;
        }
        visited[i][j] = true;


        printPaths(i, j + 1, n, matrix, res + "R", visited, list);
        printPaths(i, j - 1, n, matrix, res + "L", visited, list);
        printPaths(i - 1, j, n, matrix, res + "U", visited, list);
        printPaths(i + 1, j, n, matrix, res + "D", visited, list);

        visited[i][j] = false;
    }
}
