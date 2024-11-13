import java.util.ArrayList;

public class G_Graph_392_M_Coloring_Problem {
    // https://practice.geeksforgeeks.org/problems/m-coloring-problem-1587115620/1
    // https://www.youtube.com/watch?v=wuVwUK25Rfc&t=930s
    private static boolean isSafe(int node, ArrayList<ArrayList<Integer>> G, int[] color, int n, int col) {
        for (int it : G.get(node)) {
            if (color[it] == col) return false;
        }
        return true;
    }

    private static boolean solve(int node, ArrayList<ArrayList<Integer>> G, int[] color, int n, int m) {
        if (node == n)
            return true;

        for (int i = 1; i <= m; i++) {
            if (isSafe(node, G, color, n, i)) {
                color[node] = i;
                if (solve(node + 1, G, color, n, m))
                    return true;
                color[node] = 0;
            }
        }
        return false;
    }

    public static boolean graphColoring(ArrayList<ArrayList<Integer>> G, int[] color, int m) {
        int n = G.size();
        if (solve(0, G, color, n, m))
            return true;
        return false;
    }

    public boolean graphColoring(boolean[][] graph, int m, int n) {
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(new ArrayList<>());
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < graph[0].length; j++) {
                if (graph[i][j]) {
                    list.get(i).add(j);
                    list.get(j).add(i);
                }
            }
        }
        return graphColoring(list, new int[n + 1], m);

    }
}
