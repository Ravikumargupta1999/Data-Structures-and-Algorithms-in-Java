package Day_24_Graph_Part_II;

import java.util.ArrayList;
import java.util.Arrays;

public class Bellman_Ford_Algorithm {
    static int[] bellman_ford(int n, ArrayList<ArrayList<Integer>> adj, int s) {
        int[] path = new int[n];
        int m = adj.size();
        Arrays.fill(path, Integer.MAX_VALUE);
        path[s] = 0;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < m; j++) {
                int u = adj.get(j).get(0);
                int v = adj.get(j).get(1);
                int w = adj.get(j).get(2);
                if (path[u] == Integer.MAX_VALUE) {
                    continue;
                }
                if (path[u] + w < path[v]) {
                    path[v] = path[u] + w;
                }
            }
        }
        for (int i = 0; i < path.length; i++) {
            if (path[i] == Integer.MAX_VALUE)
                path[i] = 100000000;
        }
        return path;
    }
}
