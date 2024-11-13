import java.util.*;
//https://leetcode.com/problems/matrix-cells-in-distance-order/submissions/
public class Video_44_Matrix_Cells_in_Distance_Order {
    public int[][] allCellsDistOrder(int rows, int cols, int rCenter, int cCenter) {
        int[][] ans = new int[rows][cols];
        ans[rCenter][cCenter] = 0;
        boolean[][] visited = new boolean[rows][cols];
        return bfs(ans, visited, rCenter, cCenter);
    }

    class Pair {
        int i;
        int j;
        int ans;
    }

    int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public int[][] bfs(int[][] ans, boolean[][] visited, int rCenter, int cCenter) {

        ArrayList<Pair> arrays = new ArrayList<>();
        int index = 0;
        Queue<Pair> queue = new LinkedList<>();
        visited[rCenter][cCenter] = true;
        Pair p = new Pair();
        p.i = rCenter;
        p.j = cCenter;
        p.ans = 0;
        queue.add(p);
        ans[rCenter][cCenter] = 0;
        while (!queue.isEmpty()) {

            Pair temp = queue.poll();
            arrays.add(temp);
            ans[temp.i][temp.j] = temp.ans;
            for (int i = 0; i < dir.length; i++) {
                int row = temp.i + dir[i][0];
                int col = temp.j + dir[i][1];

                if (isValid(visited, row, col)) {
                    Pair child = new Pair();
                    child.i = row;
                    child.j = col;
                    child.ans = temp.ans + 1;

                    visited[child.i][child.j] = true;
                    queue.add(child);
                }

            }
        }
        int[][] result = new int[arrays.size()][2];
        for (int i = 0; i < arrays.size(); i++) {
            result[i][0] = arrays.get(i).i;
            result[i][1] = arrays.get(i).j;
        }
        return result;
    }
    public boolean isValid(boolean[][] visited, int row, int col) {
        if (row < 0 || row >= visited.length || col < 0 || col >= visited[0].length || visited[row][col])
            return false;
        return true;
    }
}
