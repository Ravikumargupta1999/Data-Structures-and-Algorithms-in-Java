import java.util.LinkedList;
import java.util.Queue;

//https://leetcode.com/problems/shortest-bridge/
public class Video_7_Shortest_Bridge {
    static class Pair {
        int i;
        int j;
        int level;

        public Pair(int i, int j, int level) {
            this.i = i;
            this.j = j;
            this.level = level;
        }
    }

    int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public int shortestBridge(int[][] grid) {
        Queue<Pair> queue = new LinkedList<>();
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        boolean found = false;
        for (int i = 0; i < grid.length; i++) {
            if (found)
                break;
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    found = true;
                    Dfs(grid, i, j, visited, queue);
                    break;
                }

            }
        }
        while (queue.size() > 0) {
            int size = queue.size();
            while (size-- > 0) {
                Pair temp = queue.poll();
                for (int[] arr : dirs) {
                    int rowDish = temp.i + arr[0];
                    int colDish = temp.j + arr[1];
                    if (rowDish >= 0 && colDish >= 0 && rowDish < grid.length && colDish < grid[0].length && !visited[rowDish][colDish]) {
                        if (grid[rowDish][colDish] == 0) {
                            visited[rowDish][colDish] = true;
                            queue.add(new Pair(rowDish, colDish, temp.level + 1));
                        } else
                            return temp.level;
                    }
                }
            }

        }
        return 0;
    }

    public void Dfs(int[][] grid, int row, int col, boolean[][] visited, Queue<Pair> queue) {
        visited[row][col] = true;
        queue.add(new Pair(row, col, 0));
        for (int i = 0; i < dirs.length; i++) {
            int rowDish = row + dirs[i][0];
            int colDish = col + dirs[i][1];
            if (rowDish >= 0 && colDish >= 0 && rowDish < grid.length && colDish < grid[0].length && !visited[rowDish][colDish] && grid[rowDish][colDish] == 1) {
                Dfs(grid, rowDish, colDish, visited, queue);
            }
        }
    }

    public static void main(String[] args) {

 //        int[][] grid = {{0,1,0},{0,0,0},{0,0,1}};

        int[][] grid = {{0, 1}, {1, 0}};
        Video_7_Shortest_Bridge a = new Video_7_Shortest_Bridge();
        System.out.print(a.shortestBridge(grid));
    }
}
