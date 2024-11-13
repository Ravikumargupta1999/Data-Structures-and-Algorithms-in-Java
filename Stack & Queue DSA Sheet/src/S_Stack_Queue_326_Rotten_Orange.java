import java.util.LinkedList;
import java.util.Queue;

public class S_Stack_Queue_326_Rotten_Orange {
    // https://leetcode.com/problems/rotting-oranges/
    static class Pair {
        int row;
        int col;

        public Pair(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }
    // https://leetcode.com/problems/rotting-oranges/
    // https://practice.geeksforgeeks.org/problems/rotten-oranges2536/1
    // https://www.youtube.com/watch?v=Dq3dGS_0Z6o
    public static int rottenOranges(int[][] grid) {
        Queue<Pair> queue = new LinkedList<>();
        int fresh = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 2) {
                    queue.add(new Pair(i, j));
                } else if (grid[i][j] == 1) {
                    fresh++;
                }
            }
        }
        if (fresh == 0)
            return 0;
        int[][] dis = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
        int level = -1;

        while (queue.size() > 0) {
            int size = queue.size();
            level++;
            while (size-- > 0) {
                Pair rem = queue.poll();
                for (int i = 0; i < dis.length; i++) {
                    int newRow = rem.row + dis[i][0];
                    int newCol = rem.col + dis[i][1];
                    if (newRow >= 0 && newCol >= 0 && newRow < grid.length && newCol < grid[0].length && grid[newRow][newCol] == 1) {
                        queue.add(new Pair(newRow, newCol));
                        grid[newRow][newCol] = 0;
                        fresh--;
                    }
                }
            }
        }
        if (fresh == 0)
            return level;
        else
            return -1;
    }
}
