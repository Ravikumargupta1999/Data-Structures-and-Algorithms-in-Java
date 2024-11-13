public class Video_32_Path_with_Maximum_Gold {

    // https://leetcode.com/problems/path-with-maximum-gold/
    // https://www.youtube.com/watch?v=8nlmcgy7vso


    public int getMaximumGold(int[][] grid) {
        int max = 0;
        for(int i=0;i<grid.length;i++)
        {
            for(int j=0;j<grid[0].length;j++)
            {
                if(grid[i][j] > 0)
                {
                    int cmax = findMaxGoldPath(grid,i,j,max,new boolean[grid.length][grid[0].length]);
                    max = Math.max(cmax,max);
                }
            }
        }
        return max;
    }
    public static int findMaxGoldPath(int[][] grid,int i,int j,int max,boolean[][] visited)
    {
        if(i < 0|| j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] == 0  || visited[i][j] )
        {
            return 0;
        }
        visited[i][j] = true;
        int left = findMaxGoldPath(grid,i,j-1,max,visited);
        int right = findMaxGoldPath(grid,i,j+1,max,visited);
        int up = findMaxGoldPath(grid,i-1,j,max,visited);
        int down = findMaxGoldPath(grid,i+1,j,max,visited);
        visited[i][j] = false;
        return Math.max(left,Math.max(right,Math.max(up,down)))+grid[i][j];

    }
}
