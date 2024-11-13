import java.util.*;

// https://practice.geeksforgeeks.org/problems/detect-cycle-in-an-undirected-graph/1#
// https://www.youtube.com/watch?v=Y9NFqI6Pzd4
public class G_Graph_360_Detect_Cycle_in_an_Undirected_Graph_DFS {
    public boolean isCycle(int V, ArrayList<ArrayList<Integer>> graph) {
        boolean[] visited = new boolean[V];
        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                if (detectCycle(i, -1, graph, visited))
                    return true;
            }
        }
        return false;
    }

    public boolean detectCycle(int node, int par, ArrayList<ArrayList<Integer>> graph, boolean[] vis) {
        vis[node] = true;
        for (int neighbour : graph.get(node)) {
            if (!vis[neighbour]) {
                if (detectCycle(neighbour, node, graph, vis))
                    return true;
            } else if (par != neighbour)
                return true;
        }
        return false;
    }
}
