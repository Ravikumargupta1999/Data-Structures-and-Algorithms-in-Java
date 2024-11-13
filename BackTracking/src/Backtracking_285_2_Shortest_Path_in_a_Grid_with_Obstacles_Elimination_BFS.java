import java.util.LinkedList;
import java.util.Queue;

public class Backtracking_285_2_Shortest_Path_in_a_Grid_with_Obstacles_Elimination_BFS {
    // https://www.youtube.com/watch?v=ywljsnzUS1w&t=651s
    // https://leetcode.com/problems/shortest-path-in-a-grid-with-obstacles-elimination/
    public int shortestPath(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;

        int[][] obstacle = new int[m][n];
        boolean[][] visited = new boolean[m][n];
        int[][] moves = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0, 0, grid[0][0]});
        obstacle[0][0] = grid[0][0];
        int level = 1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-- > 0) {
                int[] head = queue.poll();
                if (head[0] == m - 1 && head[1] == n - 1)
                    return level - 1;

                int currentObstacle = head[2];
                for (int i = 0; i < moves.length; i++) {
                    int row = head[0] + moves[i][0];
                    int col = head[1] + moves[i][1];
                    if (row < 0 || row >= m || col < 0 || col >= n)
                        continue;

                    int oldObstacle = obstacle[row][col];
                    int newObstacle = currentObstacle + grid[row][col];
                    if (!visited[row][col] && newObstacle <= k) {
                        queue.add(new int[]{row, col, newObstacle});
                        obstacle[row][col] = newObstacle;
                        visited[row][col] = true;
                    } else if (oldObstacle > newObstacle && newObstacle <= k) {
                        queue.add(new int[]{row, col, newObstacle});
                        obstacle[row][col] = newObstacle;
                        visited[row][col] = true;
                    }
                }
            }
            level++;
        }
        return -1;

    }
}
