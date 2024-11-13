public class Backtracking_285_1_Shortest_Path_in_a_Grid_with_Obstacles_Elimination_DFS_TLE {
    int min = Integer.MAX_VALUE;

    public int shortestPath(int[][] grid, int k) {
        DFS(grid, k, 0, 0, 0, 0, new boolean[grid.length][grid[0].length]);
        return min == Integer.MAX_VALUE ? -1 : min;
    }

    int[][] moves = {{0, -1}, {0, 1}, {-1, 0}, {1, 0}};

    public void DFS(int[][] grid, int k, int obstacle, int len, int row, int col, boolean[][] visited) {
        if (row < 0 || row >= grid.length || col < 0 || col >= grid[0].length || visited[row][col] || obstacle > k)
            return;
        if (row == grid.length - 1 && col == grid[0].length - 1) {
//            if (obstacle <= k) {
                min = Math.min(min, len);
//            }
            return;
        }
        visited[row][col] = true;
        for (int i = 0; i < moves.length; i++) {
            if (grid[row][col] == 1) {
                DFS(grid, k, obstacle + 1, len + 1, row + moves[i][0], col + moves[i][1], visited);
            } else {
                DFS(grid, k, obstacle, len + 1, row + moves[i][0], col + moves[i][1], visited);
            }
        }
        visited[row][col] = false;
    }


}
