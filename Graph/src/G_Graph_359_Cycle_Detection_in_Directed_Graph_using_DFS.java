import java.util.ArrayList;

// https://practice.geeksforgeeks.org/problems/detect-cycle-in-a-directed-graph/1#
// https://www.youtube.com/watch?v=uzVUw90ZFIg
public class G_Graph_359_Cycle_Detection_in_Directed_Graph_using_DFS {

    public static boolean isCyclic(int v, ArrayList<ArrayList<Integer>> adj) {
        boolean[] visited = new boolean[v];
        boolean[] dfsVisit = new boolean[v];

        for (int i = 0; i < v; i++) {
            if (!visited[i]) {
                if (isContainCycle(i, visited, dfsVisit, adj)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean isContainCycle(int node, boolean[] visited, boolean[] dfsVisit, ArrayList<ArrayList<Integer>> adj) {
        visited[node] = true;
        dfsVisit[node] = true;

        for (int neighbour : adj.get(node)) {
            if (!visited[neighbour]) {
                if (isContainCycle(neighbour, visited, dfsVisit, adj)) {
                    return true;
                }
            } else if (dfsVisit[neighbour]) {
                return true;
            }
        }
        dfsVisit[node] = false;
        return false;
    }

}
