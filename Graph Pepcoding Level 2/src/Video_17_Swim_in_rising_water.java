import java.util.PriorityQueue;

// https://leetcode.com/problems/swim-in-rising-water/submissions/
public class Video_17_Swim_in_rising_water {
    public int swimInWater(int[][] grid) {
        int n = grid.length;
        PriorityQueue<Pair> pq = new PriorityQueue<>();

        pq.add(new Pair(0, 0, grid[0][0]));

        boolean[][] visited = new boolean[n][n];

        int[][] dir = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

        while (pq.size() > 0) {
            Pair rem = pq.remove();

            if (rem.row == n - 1 && rem.col == n - 1)
                return rem.msf;

            if (visited[rem.row][rem.col])
                continue;

            visited[rem.row][rem.col] = true;

            for (int i = 0; i < dir.length; i++) {
                int rowDish = rem.row + dir[i][0];
                int colDish = rem.col + dir[i][1];
                if (isValidPath(rowDish, colDish, visited)) {
                    pq.add(new Pair(rowDish, colDish, Math.max(rem.msf, grid[rowDish][colDish])));
                }
            }
        }
        return 0;
    }

    public boolean isValidPath(int row, int col, boolean[][] visited) {
        if (row < 0 || row >= visited.length || col < 0 || col >= visited.length || visited[row][col])
            return false;
        return true;
    }

    public class Pair implements Comparable<Pair> {
        int row;
        int col;
        int msf;

        Pair(int row, int col, int msf) {
            this.row = row;
            this.col = col;
            this.msf = msf;
        }

        @Override
        public int compareTo(Pair o) {
            return this.msf - o.msf;
        }
    }
}
