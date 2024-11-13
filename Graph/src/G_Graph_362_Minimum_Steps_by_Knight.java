import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class G_Graph_362_Minimum_Steps_by_Knight {
    // Solution 1
    public int minStepToReachTarget(int[] KnightPos, int[] TargetPos, int n) {
        int x1 = KnightPos[0];
        int y1 = KnightPos[1];
        int x2 = TargetPos[0];
        int y2 = TargetPos[1];
        int[][] DP = new int[n + 1][n + 1];
        if (x1 == x2 && y1 == y2)
            return 0;
        for (int[] arr : DP)
            Arrays.fill(arr, -1);

        Queue<int[]> q = new LinkedList<>();

        q.add(new int[]{x1, y1});
        DP[x1][y1] = 0;

        int[][] steps = new int[][]{{1, 2}, {2, 1}, {1, -2}, {2, -1}, {-1, 2}, {-2, 1}, {-1, -2}, {-2, -1}};

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int x = cur[0];
            int y = cur[1];
            for (int k = 0; k < steps.length; k++) {
                int nx = x + steps[k][0];
                int ny = y + steps[k][1];
                if (nx < 1 || nx > n || ny < 1 || ny > n || DP[nx][ny] != -1)
                    continue;

                DP[nx][ny] = 1 + DP[x][y];
                q.add(new int[]{nx, ny});
            }
        }
        return DP[x2][y2];
    }

    // Code library
    // https://www.youtube.com/watch?v=ce4vjUVfrhU
    public static int minStepToReachTarget3(int[] KnightPos, int[] TargetPos, int n) {
        int[][] board = new int[n][n];
        if (KnightPos[0] == TargetPos[0] && KnightPos[1] == TargetPos[1])
            return 0;

        Queue<int[]> queue = new LinkedList<>();

        queue.add(new int[]{KnightPos[0] - 1, KnightPos[1] - 1});

        int[][] steps = new int[][]{{1, 2}, {2, 1}, {1, -2}, {2, -1}, {-1, 2}, {-2, 1}, {-1, -2}, {-2, -1}};


        while (!queue.isEmpty()) {

            int[] rem = queue.poll();
//            if (rem[0] == TargetPos[0] - 1 && rem[1] == TargetPos[1] - 1)
//                return board[rem[0]][rem[1]];
            for (int i = 0; i < steps.length; i++) {

                int row = rem[0] + steps[i][0];
                int col = rem[1] + steps[i][1];

                if (isValidPath(row, col, board)) {
                    board[row][col] = 1 + board[rem[0]][rem[1]];
                    queue.add(new int[]{row, col});
                }
            }
        }
        return board[TargetPos[0] - 1][TargetPos[1] - 1];
    }

    public static boolean isValidPath(int i, int j, int[][] board) {
        return i >= 0 && i < board.length && j >= 0 && j < board[0].length && board[i][j] == 0;
    }

    public static void main(String[] args) {
        int N = 6, knightPos[] = {4, 5}, targetPos[] = {1, 1};

        System.out.println(new G_Graph_362_Minimum_Steps_by_Knight().minStepToReachTarget3(knightPos,targetPos,N));
    }
}