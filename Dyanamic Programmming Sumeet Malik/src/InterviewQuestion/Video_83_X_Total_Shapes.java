package InterviewQuestion;

public class Video_83_X_Total_Shapes {
    // https://practice.geeksforgeeks.org/problems/x-total-shapes3617/1
    //Function to find the number of 'X' total shapes.
    public int xShape(char[][] grid) {
        int count = 0;
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 'X' && !visited[i][j]) {
                    count++;
                    dfs(i, j, grid, visited);
                }
            }
        }
        return count;
    }

    public void dfs(int i, int j, char[][] grid, boolean[][] visited) {
        visited[i][j] = true;
        if (validPath(i + 1, j, grid, visited)) {
            dfs(i + 1, j, grid, visited);
        }
        if (validPath(i - 1, j, grid, visited)) {
            dfs(i - 1, j, grid, visited);
        }
        if (validPath(i, j + 1, grid, visited)) {
            dfs(i, j + 1, grid, visited);
        }
        if (validPath(i, j - 1, grid, visited)) {
            dfs(i, j - 1, grid, visited);
        }
    }

    public boolean validPath(int i, int j, char[][] grid, boolean[][] visited) {
        return i >= 0 && i < grid.length && j >= 0 && j < grid[0].length && grid[i][j] == 'X' && !visited[i][j];
    }

    public static void main(String[] args) {

    }
}
