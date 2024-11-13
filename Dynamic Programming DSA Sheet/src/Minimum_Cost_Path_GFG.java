public class Minimum_Cost_Path_GFG {
    public int minimumCostPath(int[][] grid)
    {
        return solve(0,0,grid,new boolean[grid.length][grid[0].length]);
    }
    public static int solve(int row,int col,int[][] grid,boolean[][] visited)
    {
        if( row < 0 || row >= grid.length || col < 0 || col >= grid[0].length || visited[row][col])
        {
            return 0;
        }
        if( row == grid.length-1 && col == grid[0].length-1)
            return grid[row][col];
        visited[row][col] = true;
        int up = solve(row-1,col,grid,visited);
        int down = solve(row+1,col,grid,visited);
        int left = solve(row,col-1,grid,visited);
        int right = solve(row,col+1,grid,visited);
        visited[row][col] = false;
        return grid[row][col] + Math.max(Math.max(left,right),Math.max(up,down));
    }
}
