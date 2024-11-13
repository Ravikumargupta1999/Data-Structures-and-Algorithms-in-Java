import java.util.Arrays;

public class Video_20_Negative_weight_cycle {
    // https://www.youtube.com/watch?v=dwcNHh2aHzo&list=PL-Jc9J83PIiEuHrjpZ9m94Nag4fwAvtPQ&index=20
    // https://practice.geeksforgeeks.org/problems/negative-weight-cycle3504/1
    public int isNegativeWeightCycle(int n, int[][] adj) {
        int[] path = new int[n];
        int m = adj.length;
        Arrays.fill(path, Integer.MAX_VALUE);
        path[0] = 0;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < m; j++) {
                int u = adj[j][0];
                int v = adj[j][1];
                int w = adj[j][2];
                if (path[u] == Integer.MAX_VALUE) {
                    continue;
                }
                if (path[u] + w < path[v]) {
                    path[v] = path[u] + w;
                }
            }
        }


        for (int j = 0; j < m; j++) {
            int u = adj[j][0];
            int v = adj[j][1];
            int w = adj[j][2];
            if (path[u] == Integer.MAX_VALUE) {
                continue;
            }
            if (path[u] + w < path[v]) {
                return 1;
            }
        }

        return 0;
    }
}
