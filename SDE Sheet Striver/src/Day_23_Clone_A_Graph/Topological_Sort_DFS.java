package Day_23_Clone_A_Graph;

import java.util.ArrayList;
import java.util.Stack;

public class Topological_Sort_DFS {
    // https://practice.geeksforgeeks.org/problems/topological-sort/1
    static int[] topoSort(int V, ArrayList<ArrayList<Integer>> adj) {
        Stack<Integer> stack = new Stack<>();
        boolean[] visited = new boolean[V];
        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                dfs(i, visited, adj, stack);
            }
        }
        int[] res = new int[V];
        int i = 0;
        while (!stack.isEmpty())
            res[i++] = stack.pop();
        return res;
    }
    static void dfs(int node,boolean[] visited,ArrayList<ArrayList<Integer>> adj,Stack<Integer> st){
        visited[node] = true;
        for (int neighbour : adj.get(node)){
            if(!visited[neighbour]){
                dfs(neighbour,visited,adj,st);
            }
        }
        st.push(node);
    }
}