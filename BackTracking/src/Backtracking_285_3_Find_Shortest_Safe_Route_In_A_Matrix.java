import java.util.LinkedList;
import java.util.Queue;
// https://practice.geeksforgeeks.org/problems/find-shortest-safe-route-in-a-matrix/0/?page=1&sortBy=newest&query=page1sortBynewest#
public class Backtracking_285_3_Find_Shortest_Safe_Route_In_A_Matrix {
    public static int findShortestPath(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int[][] moves = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        Queue<int[]> queue = new LinkedList<>();

        // add valid cell in first row
        for (int i = 0; i < m; i++) {
            if (isSafe(i, 0, grid)) {
                queue.add(new int[]{i, 0});
            }
        }

        int level = 1;


        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-- > 0) {
                int[] head = queue.poll();

                // if reached to last column
                // return current level
                if (head[1] == n - 1)
                    return level ;


                // Add in queue next valid path
                for (int i = 0; i < moves.length; i++) {
                    int row = head[0] + moves[i][0];
                    int col = head[1] + moves[i][1];
                    if (isSafe(row, col, grid)) {
                        queue.add(new int[]{row, col});
                    }
                }
            }
            level++;
        }
        return -1;

    }

    public static boolean isSafe(int row, int col, int[][] grid) {
        // current cell is visited or not valid then return
        if (row < 0 || row >= grid.length || col < 0 || col >= grid[0].length || grid[row][col] == 0 || grid[row][col] == -1)
            return false;
        // mark current cell visited
        grid[row][col] = -1;

        // check if adjacent contains 0 or not
        // if they do contain zero return false
        int[][] moves = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        for (int i = 0; i < moves.length; i++) {
            int newRow = row + moves[i][0];
            int newCol = col + moves[i][1];
            if (newRow < 0 || newRow >= grid.length || newCol < 0 || newCol >= grid[0].length)
                continue;
            if (grid[newRow][newCol] == 0)
                return false;
        }


        return true;
    }
    public static void main(String[] args) {
        int[][] grid = {{1, 0, 1, 1, 1},
                {1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1},
                {1, 1, 1, 0, 1},
                {1, 1, 1, 1, 0}};
        System.out.println(findShortestPath(grid));
    }
}
