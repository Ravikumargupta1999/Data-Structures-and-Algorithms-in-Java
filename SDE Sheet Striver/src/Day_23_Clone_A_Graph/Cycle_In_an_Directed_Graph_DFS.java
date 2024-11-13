package Day_23_Clone_A_Graph;

import java.util.ArrayList;

public class Cycle_In_an_Directed_Graph_DFS {
    static boolean checkCycle(int node, ArrayList<ArrayList<Integer>> adj, boolean[] vis, boolean[] dfsVisit) {
        vis[node] = true;
        dfsVisit[node] = true;
        for (Integer it : adj.get(node)) {
            if (!vis[it]) {
                if (checkCycle(it, adj, vis, dfsVisit)) {
                    return true;
                }
            } else if (dfsVisit[it]) {
                return true;
            }
        }
        dfsVisit[node] = false;
        return false;
    }

    public static boolean isCyclic(int v, ArrayList<ArrayList<Integer>> adj) {
        boolean[] vis = new boolean[v];
        boolean[] dfsVis = new boolean[v];

        for (int i = 0; i < v; i++) {
            if (!vis[i]) {
                if (checkCycle(i, adj, vis, dfsVis))
                    return true;
            }
        }
        return false;

    }
}
