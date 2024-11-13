package Day_22_Binary_Trees_Miscellaneous;

public class Flood_Fill {
    // https://leetcode.com/problems/flood-fill/
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int x = image.length;
        int y = image[0].length;
        int[][] vis = new int[x][y];
        int oldColor = image[sr][sc];
        dfs(sr, sc, vis, image, newColor, x, y, oldColor);
        return image;
    }

    public static void dfs(int i, int j, int[][] vis, int[][] image, int newColor, int n, int m, int oldColor) {
        if (i < 0 || j < 0 || i >= n || j >= m)
            return;
        if (vis[i][j] == 1)
            return;
        if (image[i][j] != oldColor)
            return;
        vis[i][j] = 1;
        image[i][j] = newColor;
        System.out.println(image[i][j]);

        dfs(i + 1, j, vis, image, newColor, n, m, oldColor);
        dfs(i - 1, j, vis, image, newColor, n, m, oldColor);
        dfs(i, j + 1, vis, image, newColor, n, m, oldColor);
        dfs(i, j - 1, vis, image, newColor, n, m, oldColor);
        // return image;
    }
}
