import java.util.PriorityQueue;

public class P_10_Minimum_Time_to_Visit_a_Cell_In_a_Grid {
//    https://leetcode.com/problems/minimum-time-to-visit-a-cell-in-a-grid/submissions/912568303/
    // TLE
    public int minimumTime(int[][] grid) {
        int[][] dir = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
        PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> {
            return a[2] - b[2];
        });
        queue.add(new int[]{0, 0, 0});

        int n = grid.length;
        int m = grid[0].length;


        while (!queue.isEmpty()) {

            int[] temp = queue.poll();

            if (temp[0] == n - 1 && temp[1] == m - 1)
                return temp[2];

            for (int i = 0; i < dir.length; i++) {

                int row = temp[0] + dir[i][0];
                int col = temp[1] + dir[i][1];
                if (row < 0 || row >= n || col < 0 || col >= m || grid[row][col] > temp[2] + 1)
                    continue;
                queue.add(new int[]{row, col, temp[2] + 1});
            }
        }
        return -1;
    }

    public int minimumTime1(int[][] grid) {
        int[][] dir = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
        PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> {
            return a[2] - b[2];
        });
        queue.add(new int[]{0, 0, 0});

        int n = grid.length;
        int m = grid[0].length;

        boolean[][] visited = new boolean[n][m];

        while (!queue.isEmpty()) {

            int[] temp = queue.poll();
            if (visited[temp[0]][temp[1]])
                continue;
            visited[temp[0]][temp[1]] = true;

            if (temp[0] == n - 1 && temp[1] == m - 1)
                return temp[2];

            for (int i = 0; i < dir.length; i++) {

                int row = temp[0] + dir[i][0];
                int col = temp[1] + dir[i][1];
                if (row < 0 || row >= n || col < 0 || col >= m || visited[row][col])
                    continue;

                if (grid[row][col] <= temp[2] + 1) {
                    // if it is possible to move to neighbor, do it
                    queue.offer(new int[]{row, col, temp[2] + 1});
                } else {
                    // If we cant move to neighbor yet, we can hop to the previous cell
                    // and back to current cell as many times as we need to until
                    // sufficient time has passed.
                    // The trick here is that if the difference between the current time
                    // and the time we need is even, we will arrive back at the current cell
                    // 1 second "late" and so we will move to the neighbor 1 second after
                    // the minimum neighbor time.
                    int diff = grid[row][col] - temp[2];
                    if (diff % 2 == 1) {
                        queue.add(new int[]{row, col, grid[row][col]});
                    } else {
                        queue.offer(new int[]{row, col, grid[row][col] + 1});
                    }
                }
            }
        }
        return -1;
    }
}
