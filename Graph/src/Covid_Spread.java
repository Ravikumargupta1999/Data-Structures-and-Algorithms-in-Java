import java.util.LinkedList;
import java.util.Queue;

public class Covid_Spread {
    public int helpaterp(int[][] grid) {
        int n = grid.length, m = grid[0].length;
        Queue<int[]> q = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 2) {
                    q.add(new int[]{i, j, 0});
                }
            }
        }

        int dir[][] = {{0, 1}, {1, 0}, {-1, 0}, {0, -1}};
        int ans = -1;
        while (!q.isEmpty()) {
            ans++;
            int size = q.size();
            while (size-- > 0) {
                int[] a = q.poll();

                for (int b[] : dir) {
                    int r = a[0] + b[0];
                    int c = a[1] + b[1];

                    if (isValid(r, c, n, m, grid)) {
                        q.add(new int[]{r, c});

                    }
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1) {
                    return -1;
                }
            }
        }
        return ans;
    }

    public boolean isValid(int r, int c, int n, int m, int[][] grid) {
        if (r < 0 || c < 0 || r >= n || c >= m || grid[r][c] != 1)
            return false;

        grid[r][c] = 2;
        return true;

    }
}
