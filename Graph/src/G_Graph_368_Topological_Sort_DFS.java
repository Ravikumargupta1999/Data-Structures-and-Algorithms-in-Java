import java.util.ArrayList;
import java.util.Stack;

public class G_Graph_368_Topological_Sort_DFS {
    // https://practice.geeksforgeeks.org/problems/topological-sort/1#
    // https://www.youtube.com/watch?v=Yh6EFazXipA
    static int[] topoSort(int V, ArrayList<ArrayList<Integer>> adj) {
        boolean[] visited = new boolean[V];
        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                findTopoSort(i, adj, visited, st);
            }
        }
        int[] ans = new int[V];
        int i = 0;
        while (!st.isEmpty())
            ans[i++] = st.pop();
        return ans;
    }

    public static void findTopoSort(int vertex, ArrayList<ArrayList<Integer>> graph, boolean[] visited, Stack<Integer> st) {
        visited[vertex] = true;
        for (int ver : graph.get(vertex)) {
            if (!visited[ver]) {
                findTopoSort(ver, graph, visited, st);
            }
        }
        st.push(vertex);
    }
}
