import java.util.ArrayDeque;
import java.util.Deque;

public class Hello {
    public static int shortestPath(int[][] grid, int k) {
        int n = grid.length;
        int m = grid[0].length;

        if (k >= n + m - 2) return m + n - 2;

        // possible directions
        int[][] directions = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        // q of [row, col, eliminations used]
        Deque<int[]> q = new ArrayDeque<>();

        // visited for each row,col,k
        boolean[][][] visited = new boolean[n][m][k + 1];

        q.offer(new int[]{0, 0, 0, 0});

        while (!q.isEmpty()) {

            int[] curr = q.poll();
            int row = curr[0], col = curr[1], ks = curr[2], steps = curr[3];

            // if its the end, return it
            if (row == n - 1 && col == m - 1) return steps;

            // if already visited this situation, skip
            if (visited[row][col][ks]) continue;

            // set this to visited
            visited[row][col][ks] = true;

            for (int[] dir : directions) {

                int r1 = row + dir[0], c1 = col + dir[1];

                if (r1 < 0 || r1 >= n || c1 < 0 || c1 >= m) continue;

                if (grid[r1][c1] == 0 && !visited[r1][c1][ks]) {
                    q.addLast(new int[]{r1, c1, ks, steps + 1});
                    continue;
                }
                if (ks < k && !visited[r1][c1][ks + 1]) q.addLast(new int[]{r1, c1, ks + 1, steps + 1});
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[][] arr = {{0, 0}, {1, 0}};
        System.out.println(shortestPath(arr, 2));
    }
}
