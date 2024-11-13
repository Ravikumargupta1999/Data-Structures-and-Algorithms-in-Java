package Day_23_Clone_A_Graph;

public class Number_of_Islands {
    public int numIslands(char[][] grid) {
        int count = 0;

        int n = grid.length;
        int m = grid[0].length;
        boolean[][] visited = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == '1' && !visited[i][j]) {
                    count++;
                    dfs(grid, i, j, visited);
                }
            }
        }
        return count;
    }

    int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public void dfs(char[][] grid, int row, int col, boolean[][] visited) {
        grid[row][col] = '0';
        visited[row][col] = true;
        for (int i = 0; i < dirs.length; i++) {
            int rowdish = row + dirs[i][0];
            int coldish = col + dirs[i][1];
            if (rowdish < 0 || coldish < 0 || rowdish >= grid.length || coldish >= grid[0].length || grid[rowdish][coldish] == '0' || visited[rowdish][coldish] == true)
                continue;
            dfs(grid, rowdish, coldish, visited);
        }

    }
}
