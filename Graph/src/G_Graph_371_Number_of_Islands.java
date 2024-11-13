public class G_Graph_371_Number_of_Islands {
    // https://practice.geeksforgeeks.org/problems/find-the-number-of-islands/1#
    public int numIslands(char[][] grid) {
        int[][] direction = {{-1, -1}, {-1, 0}, {-1, 1}, {0, 1}, {1, 1}, {1, 0}, {1, -1}, {0, -1}};
        int count = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; i++) {
                if (grid[i][j] == '1') {
                    Dfs(i, j, grid, direction);
                    count++;
                }
            }
        }
        return count;
    }

    public void Dfs(int row, int col, char[][] grid, int[][] direction) {
        grid[row][col] = '0';
        for (int i = 0; i < direction.length; i++) {
            int newRow = row + direction[i][0];
            int newCol = col + direction[i][1];

            if (IsValidPath(newRow, newCol, grid)) {
                Dfs(newRow, newCol, grid, direction);
            }
        }
    }

    public boolean IsValidPath(int row, int col, char[][] grid) {
        return row >= 0 && row < grid.length && col >= 0 && col <= grid[0].length && grid[row][col] == '1';
    }
}
