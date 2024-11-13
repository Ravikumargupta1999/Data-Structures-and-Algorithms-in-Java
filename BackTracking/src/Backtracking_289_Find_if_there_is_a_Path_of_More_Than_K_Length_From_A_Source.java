import java.util.ArrayList;
import java.util.Arrays;
public class Backtracking_289_Find_if_there_is_a_Path_of_More_Than_K_Length_From_A_Source {
    // https://www.geeksforgeeks.org/find-if-there-is-a-path-of-more-than-k-length-from-a-source/
    // https://www.youtube.com/watch?v=oZYMOJHWI9w
    // https://practice.geeksforgeeks.org/problems/path-of-greater-than-equal-to-k-length1034/1#

    boolean pathMoreThanK(int V , int E , int K , int [] A){
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
        int[] maxPath = new int[V];
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
