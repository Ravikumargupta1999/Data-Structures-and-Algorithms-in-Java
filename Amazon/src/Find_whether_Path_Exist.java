public class Find_whether_Path_Exist {
    //Function to find whether a path exists from the source to destination.
    public boolean is_Possible(int[][] grid) {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    if (dfs(i + 1, j, grid) || dfs(i, j + 1, grid) || dfs(i - 1, j, grid) || dfs(i, j - 1, grid))
                        return true;
                }
            }
        }
        return false;
    }

    boolean dfs(int row, int col, int[][] grid) {
        if (row < 0 || row >= grid.length || col < 0 || col >= grid[0].length || grid[row][col] == 0)
            return false;
        if (grid[row][col] == 1)
            return false;
        if (grid[row][col] == 2)
            return true;
        int temp = grid[row][col];
        grid[row][col] = 0;
        boolean found = dfs(row + 1, col, grid) || dfs(row, col + 1, grid) || dfs(row - 1, col, grid) || dfs(row, col - 1, grid);
//        grid[row][col] = temp;  yahi i logic hai ki isko store kyun nahi kiya
        return found;
    }

    public static void main(String[] args) {
        int[][] arr = {
//                { 1,0},
//                { 0,2}};
                       {3, 2, 3, 3, 0},
                       {3, 0, 0, 3, 3},
                       {3, 0, 3, 3, 3},
                       {0, 3, 0, 3, 0},
                       {3, 0, 3, 1, 3}
                      };
        Find_whether_Path_Exist a = new Find_whether_Path_Exist();
        System.out.println(a.is_Possible(arr));
    }
}
