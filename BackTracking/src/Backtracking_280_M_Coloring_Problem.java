import java.util.*;

public class Backtracking_280_M_Coloring_Problem {
    // https://www.youtube.com/watch?v=wuVwUK25Rfc
    // https://practice.geeksforgeeks.org/problems/m-coloring-problem-1587115620/1
    private static boolean isSafe(int node, List<Integer>[] G, int[] color, int n, int col) {
        for (int it : G[node]) {
            if (color[it] == col)
                return false;
        }
        return true;
    }

    private static boolean solve(int node, List<Integer>[] G, int[] color, int n, int totalColor) {
        if (node == n)
            return true;

        for (int col = 1; col <= totalColor; col++) {
            if (isSafe(node, G, color, n, col)) {
                color[node] = col;
                if (solve(node + 1, G, color, n, totalColor))
                    return true;
                color[node] = 0;
            }
        }
        return false;
    }

    public static boolean graphColoring(boolean[][] graph, int totalColor, int n) {

        List<Integer>[] list = new ArrayList[n];
        for (int i = 0; i < n; i++)
            list[i] = new ArrayList<>();
        for (int i = 0; i < graph.length; i++) {
            for (int j = 0; j < graph[0].length; j++) {
                if (graph[i][j]) {
                    list[i].add(j);
                    list[j].add(i);
                }
            }
        }
        int[] color = new int[totalColor];
        if (solve(0, list, color, n, totalColor))
            return true;
        return false;
    }
}
