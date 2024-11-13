import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class G_Graph_368_Topological_Sort_Kahns_Algorithm_BFS {
    // https://practice.geeksforgeeks.org/problems/topological-sort/1#
    // https://www.youtube.com/watch?v=rZv_jHZva34
    static int[] topoSort(int V, ArrayList<ArrayList<Integer>> graph) {
        int[] ans = new int[V];
        int[] inDegree = new int[V];
        for (ArrayList<Integer> list : graph) {
            for (int vertex : list) {
                inDegree[vertex]++;
            }
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < V; i++)
            if (inDegree[i] == 0)
                queue.add(i);
        int index = 0;
        while (!queue.isEmpty()) {
            int rem = queue.poll();
            ans[index++] = rem;
            for (int vertex : graph.get(rem)) {
                inDegree[vertex]--;

                if (inDegree[vertex] == 0) {
                    queue.add(vertex);
                }
            }
        }
        return ans;
    }
}
