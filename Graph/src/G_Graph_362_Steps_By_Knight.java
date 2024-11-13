import java.util.LinkedList;
import java.util.Queue;

public class G_Graph_362_Steps_By_Knight {

    //Function to find out minimum steps Knight needs to reach target position.
    public int minStepToReachTarget(int[] KnightPos, int[] TargetPos, int n) {
        int sx = KnightPos[0] - 1;
        int sy = KnightPos[1] - 1;
        int ex = TargetPos[0] - 1;
        int ey = TargetPos[1] - 1;

        boolean[][] visited = new boolean[n][n];
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{sx, sy});
        int step = 0;
        int[][] steps = {{-1, 2}, {1, 2}, {-2, 1}, {2, 1}, {-2, -1}, {2, -1}, {-1, -2}, {1, -2}};
        while (!queue.isEmpty()) {

            int size = queue.size();

            while (size-- > 0) {

                int[] rem = queue.poll();

                if (rem[0] == ex && rem[1] == ey)
                    return step;
                for (int i = 0; i < steps.length; i++) {

                    int newRow = rem[0] + steps[i][0];
                    int newCol = rem[1] + steps[i][1];

                    if (newRow < 0 || newRow >= n || newCol < 0 || newCol >= n && visited[newRow][newCol])
                        continue;
                    visited[newRow][newCol] = true;
                    queue.add(new int[]{newRow, newCol});
                }
            }
            step++;
        }
        return -1;

    }
}
