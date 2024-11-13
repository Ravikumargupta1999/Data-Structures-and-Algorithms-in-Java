import java.util.*;

public class G_Graph_391_Path_of_greater_than_equal_to_k_length {
    // https://practice.geeksforgeeks.org/problems/path-of-greater-than-equal-to-k-length1034/1#

    boolean pathMoreThanK(int V, int E, int K, int[] A) {
        ArrayList<ArrayList<int[]>> graph = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < 3 * E; i += 3) {
            int u = A[i];
            int v = A[i + 1];
            int w = A[i + 2];

            graph.get(u).add(new int[]{v, w});
            graph.get(v).add(new int[]{u, w});
        }

        boolean[] visited = new boolean[V];
        return DFS(0, K, graph, visited);
    }

    public boolean DFS(int node, int k, ArrayList<ArrayList<int[]>> graph, boolean[] visited) {

        if (k <= 0)
            return true;
        visited[node] = true;
        for (int[] temp : graph.get(node)) {
            if (!visited[temp[0]]) {
                if (DFS(temp[0], k - temp[1], graph, visited))
                    return true;
            }
        }
        visited[node] = false;
        return false;
    }


}
