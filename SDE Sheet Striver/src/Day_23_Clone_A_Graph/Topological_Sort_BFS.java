package Day_23_Clone_A_Graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Topological_Sort_BFS {
    // https://practice.geeksforgeeks.org/problems/topological-sort/1
    static int[] topoSort(int V, ArrayList<ArrayList<Integer>> adj)
    {
        int[] inDegree = new int[V];
        for (ArrayList<Integer> list : adj) {
            for (int node : list) {
                inDegree[node]++;
            }
        }
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < V; i++) {
            if(inDegree[i] == 0)
                queue.add(i);
        }
        boolean[] visited = new boolean[V];
        int[] res = new int[V];
        int i=0;
        while (!queue.isEmpty()) {
            int temp = queue.poll();
            res[i++] = temp;

            for (int node : adj.get(temp))
                inDegree[node]--;

            for (int node : adj.get(temp))
                if (inDegree[node] == 0)
                    queue.add(node);
        }
        return res;
    }
}
