package Day_23_Clone_A_Graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Cycle_In_an_Undirected_Graph_DFS {
    // https://practice.geeksforgeeks.org/problems/detect-cycle-in-an-undirected-graph/1
    //
    public boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
        boolean[] visited = new boolean[V];
        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                if (detectCycle(i, -1, adj, visited))
                    return true;
            }
        }
        return false;
    }

    public boolean detectCycle(int i, int prev, ArrayList<ArrayList<Integer>> adj, boolean[] visited) {
        visited[i] = true;
        for (int neighbour : adj.get(i)) {
            if (!visited[neighbour]) {
                if(detectCycle(neighbour,i,adj,visited))
                    return true;
            } else if (prev != neighbour)
                return true;
        }
        return false;
    }
}
