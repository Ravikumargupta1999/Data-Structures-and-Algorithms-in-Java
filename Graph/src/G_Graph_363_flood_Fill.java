public class G_Graph_363_flood_Fill {
    // https://practice.geeksforgeeks.org/problems/flood-fill-algorithm1856/1#
    // https://leetcode.com/problems/flood-fill/
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int x = image.length;
        int y = image[0].length;
        int[][] vis = new int[x][y];
        int oldColor = image[sr][sc];
        dfs(sr, sc, vis, image, newColor, oldColor);
        return image;
    }

    public void dfs(int i, int j, int[][] vis, int[][] image, int newColor, int oldColor) {
        if (i < 0 || j < 0 || i >= image.length || j >= image[0].length)
            return;
        if (vis[i][j] == 1)
            return;
        if (image[i][j] != oldColor)
            return;
        vis[i][j] = 1;
        image[i][j] = newColor;

        dfs(i + 1, j, vis, image, newColor, oldColor);
        dfs(i - 1, j, vis, image, newColor, oldColor);
        dfs(i, j + 1, vis, image, newColor, oldColor);
        dfs(i, j - 1, vis, image, newColor, oldColor);
    }
}

//Input: image = [[1,1,1],[1,1,0],[1,0,1]], sr = 1, sc = 1, newColor = 2
//        Output: [[2,2,2],[2,2,0],[2,0,1]]