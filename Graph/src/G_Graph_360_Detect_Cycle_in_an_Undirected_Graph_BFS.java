import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class G_Graph_360_Detect_Cycle_in_an_Undirected_Graph_BFS {
    public boolean isCycle(int V, ArrayList<ArrayList<Integer>> graph) {
        boolean[] visited = new boolean[V];
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                if (detectCycle(i, -1, graph, visited, queue)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean detectCycle(int node, int pre, ArrayList<ArrayList<Integer>> graph, boolean[] visited, Queue<int[]> queue) {
        visited[node] = true;
        queue.add(new int[]{node, -1});
        while (!queue.isEmpty()) {
            int[] rem = queue.poll();
            for (int val : graph.get(rem[0])) {
                if (!visited[val]) {
                    queue.add(new int[]{val, rem[0]});
                    visited[val] = true;
                } else if (rem[1] != val)
                    return true;
            }
        }
        return false;
    }
}
