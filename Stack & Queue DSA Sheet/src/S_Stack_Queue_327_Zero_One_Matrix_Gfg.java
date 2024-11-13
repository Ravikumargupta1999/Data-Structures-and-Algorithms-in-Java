import java.util.LinkedList;
import java.util.Queue;

// https://practice.geeksforgeeks.org/problems/distance-of-nearest-cell-having-1-1587115620/1#
// https://www.youtube.com/watch?v=BJbaUH9dN24
public class S_Stack_Queue_327_Zero_One_Matrix_Gfg {
    static class Pair {
        int x;
        int y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static int[][] nearestWindow(int[][] grid) {
        Queue<Pair> queue = new LinkedList<>();
        int fresh = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1) {
                    queue.add(new Pair(i, j));
                } else if (grid[i][j] == 0) {
                    grid[i][j] = -1;
                }
            }
        }
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1) {
                    grid[i][j] = 0;
                }
            }
        }

        int[][] dis = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
        while (queue.size() > 0) {
            Pair rem = queue.poll();
            for (int i = 0; i < dis.length; i++) {
                int rdis = rem.x + dis[i][0];
                int cdis = rem.y + dis[i][1];
                if (rdis >= 0 && cdis >= 0 && rdis < grid.length && cdis < grid[0].length && grid[rdis][cdis] < 0) {
                    queue.add(new Pair(rdis, cdis));
                    grid[rdis][cdis] = grid[rem.x][rem.y] + 1;

                }
            }
        }
        return grid;

    }


    // Driven Program
    public static void main(String[] args) {
        int mat[][] = {{0, 0, 0},
                {0, 1, 0},
                {1, 1, 1}};

        mat = nearestWindow(mat);
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++)
                System.out.print(mat[i][j] + "  ");
            System.out.println("");
        }
    }
}
