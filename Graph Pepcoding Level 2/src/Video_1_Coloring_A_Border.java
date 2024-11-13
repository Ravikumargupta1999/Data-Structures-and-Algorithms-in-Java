public class Video_1_Coloring_A_Border {
    // https://www.youtube.com/watch?v=R3AJoOBVAlg&list=PL-Jc9J83PIiEuHrjpZ9m94Nag4fwAvtPQ
    // https://leetcode.com/problems/coloring-a-border/
    public int[][] colorBorder(int[][] grid, int row, int col, int color) {
        dfs(grid, row, col, grid[row][col]);
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] < 0)
                    grid[i][j] = color;
            }
        }
        return grid;
    }

    int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    public void dfs(int[][] grid, int row, int col, int clr) {
        grid[row][col] = -clr;
        int count = 0;
        for (int i = 0; i < dirs.length; i++) {
            int rowdish = row + dirs[i][0];
            int coldish = col + dirs[i][1];
            if (rowdish < 0 || coldish < 0 || rowdish >= grid.length || coldish >= grid[0].length || Math.abs(grid[rowdish][coldish]) != clr)
                continue;
            count++;
            if (grid[rowdish][coldish] == clr)
                dfs(grid, rowdish, coldish, clr);
        }
        if (count == 4)
            grid[row][col] = clr;
    }
}
