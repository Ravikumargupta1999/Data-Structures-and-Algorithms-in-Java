package Day_23_Clone_A_Graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

// https://practice.geeksforgeeks.org/problems/detect-cycle-in-an-undirected-graph/1
// https://www.youtube.com/watch?v=A8ko93TyOns&t=654s
public class Cycle_In_an_Undirected_Graph_BFS {
    // Function to detect cycle in an undirected graph.
    public boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
        boolean[] visited = new boolean[V];
        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                if (detectCycle(i, adj, visited))
                    return true;
            }
        }
        return false;
    }

    public boolean detectCycle(int i, ArrayList<ArrayList<Integer>> adj, boolean[] visited) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{i, -1});
        visited[i] = true;

        while (!queue.isEmpty()) {
            int[] temp = queue.poll();
            for (int neighbour : adj.get(temp[0])) {
                if (!visited[neighbour]) {
                    queue.add(new int[]{neighbour, temp[0]});
                    visited[neighbour] = true;
                } else if (temp[1] != neighbour)
                    return true;
            }
        }
        return false;
    }
}

