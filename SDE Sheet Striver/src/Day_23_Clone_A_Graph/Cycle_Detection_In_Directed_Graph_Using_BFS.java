package Day_23_Clone_A_Graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Cycle_Detection_In_Directed_Graph_Using_BFS {
    public boolean isCyclic(int V, ArrayList<ArrayList<Integer>> graph) {
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
        int count = 0;
        while (!queue.isEmpty()) {
            int rem = queue.poll();
            count++;
            for (int vertex : graph.get(rem)) {
                inDegree[vertex]--;
            }
            for (int vertex : graph.get(rem)) {
                if (inDegree[vertex] == 0) {
                    queue.add(vertex);
                }
            }
        }
        // System.out.println(count);
        return count == V ? false : true;
    }
}
