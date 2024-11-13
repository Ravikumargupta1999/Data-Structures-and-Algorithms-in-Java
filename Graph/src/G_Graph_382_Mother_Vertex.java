import java.util.ArrayList;
import java.util.LinkedList;

public class G_Graph_382_Mother_Vertex {
    public int findMotherVertex(int v, ArrayList<ArrayList<Integer>> adj) {
        boolean[] visited = new boolean[v];
        LinkedList<Integer> stack = new LinkedList<>();
        for (int i = 0; i < v; i++) {
            if (!visited[i]) {
                dfs1(i, adj, stack, visited);
            }
        }
        visited = new boolean[v];
        int val = stack.removeFirst();
        dfs2(val, adj, visited);
        for (boolean flag : visited) {
            if (!flag)
                return -1;
        }
        return val;
    }

    public void dfs1(int src, ArrayList<ArrayList<Integer>> graph, LinkedList<Integer> stack, boolean[] visited) {
        visited[src] = true;
        ArrayList<Integer> neighbours = graph.get(src);
        for (int nbr : neighbours) {
            if (!visited[nbr]) {
                dfs1(nbr, graph, stack, visited);
            }
        }
        stack.addFirst(src);
    }

    public void dfs2(int src, ArrayList<ArrayList<Integer>> graph, boolean[] visited) {
        visited[src] = true;
        ArrayList<Integer> neighbours = graph.get(src);
        for (int neighbour : neighbours) {
            if (!visited[neighbour]) {
                dfs2(neighbour, graph, visited);
            }
        }
    }
}
