package Day_23_Clone_A_Graph;

import java.util.ArrayList;

public class DFS_Of_Graph {
    // https://practice.geeksforgeeks.org/problems/depth-first-traversal-for-a-graph/1
    public ArrayList<Integer> dfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        boolean[] visited = new boolean[V];
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            if (!visited[i])
                dfs(i, adj, visited, list);
        }
        return list;
    }

    public void dfs(int node, ArrayList<ArrayList<Integer>> adj, boolean[] visited, ArrayList<Integer> list) {
        list.add(node);
        visited[node] = true;
        for (int neighbour : adj.get(node)){
            if(!visited[neighbour])
                dfs(neighbour,adj,visited,list);
        }
    }
}
