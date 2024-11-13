public class Video_2_Number_of_Enclaves {
    //https://leetcode.com/problems/number-of-enclaves/
    public int numEnclaves(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (i == 0 || i == n - 1 || j == 0 || j == m - 1) {
                    if (grid[i][j] == 1) {
                        dfs(grid, i, j);
                    }
                }
            }
        }
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {

                if (grid[i][j] == 1) {
                    count++;
                }
            }
        }
        return count;
    }

    int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    public void dfs(int[][] grid, int row, int col) {
        grid[row][col] = 0;
//        int count = 0;
        for (int i = 0; i < dirs.length; i++) {
            int rowdish = row + dirs[i][0];
            int coldish = col + dirs[i][1];
            if (rowdish < 0 || coldish < 0 || rowdish >= grid.length || coldish >= grid[0].length || grid[rowdish][coldish] == 0)
                continue;
            dfs(grid, rowdish, coldish);
        }
    }

    public static void main(String[] args) {
        int[][] arr = {{0, 0, 0, 0}, {1, 0, 1, 0}, {0, 1, 1, 0}, {0, 0, 0, 0}};
        Video_2_Number_of_Enclaves a = new Video_2_Number_of_Enclaves();
        System.out.println(a.numEnclaves(arr));
    }


}
