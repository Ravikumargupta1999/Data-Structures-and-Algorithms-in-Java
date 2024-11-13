import java.util.LinkedList;
import java.util.Queue;

//https://leetcode.com/problems/rotting-oranges/
public class Video_5_Rotten_oranges {
    class Pair {
        int i;
        int j;

        Pair(int i, int j) {
            this.i = i;
            this.j = j;
        }
    }

    int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public int orangesRotting(int[][] grid) {
        Queue<Pair> queue = new LinkedList<>();
        int fresh = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 2)
                    queue.add(new Pair(i, j));
                else if (grid[i][j] == 1)
                    fresh++;
            }
        }
        if (fresh == 0)
            return 0;
        int time = -1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            time++;
            while (size-- > 0) {
                Pair temp = queue.poll();
                for (int i = 0; i < dirs.length; i++) {
                    int rowdish = temp.i + dirs[i][0];
                    int coldish = temp.j + dirs[i][1];
                    if (rowdish >= 0 && coldish >= 0 && rowdish < grid.length && coldish < grid[0].length && grid[rowdish][coldish] == 1) {
                        grid[rowdish][coldish] = 0;
                        queue.add(new Pair(rowdish, coldish));
                        fresh--;
                    }
                }
            }

        }
        if (fresh == 0)
            return time;
        return -1;

    }

    public static void main(String[] args) {
        int[][] grid = {{0}};
        Video_5_Rotten_oranges a = new Video_5_Rotten_oranges();
        System.out.print(a.orangesRotting(grid));
    }
}
