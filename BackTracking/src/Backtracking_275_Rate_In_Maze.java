import java.util.ArrayList;

// D L R U
public class Backtracking_275_Rate_In_Maze {
    // https://practice.geeksforgeeks.org/problems/rat-in-a-maze-problem/1
    public static ArrayList<String> findPath(int[][] maze, int n) {

        if (maze[n - 1][n - 1] == 0)
            return new ArrayList<>();
        ArrayList<String> list = new ArrayList<>();
        boolean[][] visited = new boolean[n][n];
        printPaths(0, 0, n, maze, "", visited, list);
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
