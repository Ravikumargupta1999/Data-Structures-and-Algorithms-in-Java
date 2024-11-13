import java.util.ArrayList;

// https://practice.geeksforgeeks.org/problems/prerequisite-tasks/1/
public class G_Graph_370_Prerequisite_Tasks {
    public boolean isPossible(int N, int[][] prerequisites) {
        ArrayList<ArrayList<Integer>> arrayList = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            arrayList.add(new ArrayList<>());
        }
        for (int[] a : prerequisites) {
            arrayList.get(a[0]).add(a[1]);
        }
        return !isCyclic(N, arrayList);
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

}
