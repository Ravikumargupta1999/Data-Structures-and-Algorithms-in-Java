package Day_10_Recursion_and_Backtracking;

public class M_Colouring_ {
    public boolean graphColoring(boolean graph[][], int m, int n) {
        int[] colour = new int[n + 1];
        return function(0, graph, n, m, colour);
    }

    public boolean function(int node, boolean[][] graph, int n, int m, int[] colour) {
        if (node == n)
            return true;
        for (int i = 1; i <= m; i++) {
            if (isPossible(node, i, graph, colour)) {
                colour[node] = i;
                if (function(node + 1, graph, n, m, colour))
                    return true;
                colour[node] = 0;
            }

        }
        return false;
    }

    public boolean isPossible(int node, int col, boolean[][] graph, int[] colour) {
        for (int i = 0; i < graph[node].length; i++) {
            if (!graph[node][i]) {
                continue;
            }
            if (colour[i] == col)
                return false;
        }
        return true;
    }
}
