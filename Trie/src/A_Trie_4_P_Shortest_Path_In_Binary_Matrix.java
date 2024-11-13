import java.time.Year;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class A_Trie_4_P_Shortest_Path_In_Binary_Matrix {

//    https://leetcode.com/problems/shortest-path-in-binary-matrix/submissions/912912032/
    public static int shortestPathBinaryMatrix(int[][] grid) {
        if (grid[0][0] == 1)
            return -1;

        int m = grid.length;
        int n = grid[0].length;

        boolean[][] visited = new boolean[m][n];

        PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> {
            return a[2] - b[2];
        });


        int[][] direction = {{-1, -1}, {-1, 0}, {-1, 1}, {0, -1}, {0, 1}, {1, -1}, {1, 0}, {1, 1}};

        queue.add(new int[]{0, 0, 1});
        // System.out.println(queue.size());

        while (!queue.isEmpty()) {


            int[] temp = queue.poll();
            int row = temp[0];
            int col = temp[1];
            // System.out.println(row+"  "+col);

            if (row == m - 1 && col == n - 1)
                return temp[2];
            if (visited[row][col]) {
                // System.out.println("\n");
                continue;
            }
            visited[row][col] = true;

            for (int[] dir : direction) {
                int r = row + dir[0];
                int c = col + dir[1];
                // System.out.println(r+"   "+c);
                if (r < 0 || r >= m || c < 0 || c >= n || grid[r][c] == 1 || visited[r][c])
                    continue;
                // System.out.println("Addded");

                queue.add(new int[]{r, c, temp[2] + 1});
            }
            // System.out.println("\n");

        }
        return -1;
    }
    public static void main(String[] args) {
        int[][] grid = {{0,0,0},{1,1,0},{1,1,0}};
        System.out.println(shortestPathBinaryMatrix(grid));
    }
}
