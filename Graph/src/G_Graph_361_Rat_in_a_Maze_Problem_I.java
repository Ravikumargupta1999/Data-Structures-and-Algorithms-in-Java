import java.util.*;

// https://practice.geeksforgeeks.org/problems/rat-in-a-maze-problem/1#
//
public class G_Graph_361_Rat_in_a_Maze_Problem_I {

    public static ArrayList<String> findPath(int[][] m, int n) {
        ArrayList<String> ans = new ArrayList<>();
        dfs(0, 0, "", m, n, new int[n][n], ans);
        return ans;
    }

    public static void dfs(int i, int j, String s, int[][] m, int n, int[][] vis, ArrayList<String> v) {
        if (i < 0 || j < 0 || i >= n || j >= n || m[i][j] == 0 || vis[i][j] == 1)
            return;

        if (i == n - 1 && j == n - 1) {
            v.add(s);
            return;
        }
        vis[i][j] = 1;
        dfs(i + 1, j, s + 'D', m, n, vis, v);
        dfs(i, j - 1, s + 'L', m, n, vis, v);
        dfs(i, j + 1, s + 'R', m, n, vis, v);
        dfs(i - 1, j, s + 'U', m, n, vis, v);
        vis[i][j] = 0;

    }


}
//4
//        1 0 0 0 1 1 0 1 1 1 0 0 0 1 1 1