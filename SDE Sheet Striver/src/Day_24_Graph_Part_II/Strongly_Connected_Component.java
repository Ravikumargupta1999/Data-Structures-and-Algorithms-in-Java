package Day_24_Graph_Part_II;

import java.util.ArrayList;
import java.util.LinkedList;

public class Strongly_Connected_Component {
    public int kosaraju(int v, ArrayList<ArrayList<Integer>> adj)
    {
        // step 1
        boolean[] visited = new boolean[v];
        LinkedList<Integer> stack = new LinkedList<>();
        for (int i = 0; i < v; i++) {
            if (!visited[i]) {
                dfs1(i, adj, stack, visited);
            }
        }

        // step 2
        ArrayList<ArrayList<Integer>> ngraph = new ArrayList<>();
        for (int i = 0; i < v; i++) {
            ngraph.add(new ArrayList<>());
        }
        for (int i = 0; i < v; i++) {
            ArrayList<Integer> nbrs = adj.get(i);
            for (int nbr : nbrs) {
                ngraph.get(nbr).add(i);
            }
        }

        // step 3;
        int ans = 0;
        visited = new boolean[v];
        while (stack.size() > 0) {
            int rem = stack.removeFirst();
            if (!visited[rem]) {
                dfs2(rem, ngraph, visited);
                ans++;
            }
        }
        return ans;
    }

    public void dfs1(int src, ArrayList<ArrayList<Integer>> graph, LinkedList<Integer> stack, boolean[] visited) {
        visited[src] = true;
        ArrayList<Integer> nbrs = graph.get(src);
        for (int nbr : nbrs) {
            if (!visited[nbr]) {
                dfs1(nbr, graph, stack, visited);
            }
        }
        stack.addFirst(src);
    }

    public void dfs2(int src, ArrayList<ArrayList<Integer>> graph, boolean[] visited) {
        visited[src] = true;
        ArrayList<Integer> nbrs = graph.get(src);
        for (int nbr : nbrs) {
            if (!visited[nbr]) {
                dfs2(nbr, graph, visited);
            }
        }
    }
}
