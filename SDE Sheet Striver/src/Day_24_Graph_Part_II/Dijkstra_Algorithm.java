package Day_24_Graph_Part_II;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class Dijkstra_Algorithm {
    static int[] dijkstra(int V, ArrayList<ArrayList<ArrayList<Integer>>> adj, int S) {
        int[] ans = new int[V];
        boolean[] visited = new boolean[V];

        // int[2]  : 0th_Index --> node  1st_Index --> weight
        PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> (a[1] - b[1]));
        queue.add(new int[]{S, 0});
        while (!queue.isEmpty()) {
            int[] rem = queue.poll();
            if (visited[rem[0]])
                continue;
            ans[rem[0]] = rem[1];
            visited[rem[0]] = true;
            for (ArrayList<Integer> arrayList : adj.get(rem[0])) {
                if (!visited[arrayList.get(0)]) {
                    queue.add(new int[]{arrayList.get(0), arrayList.get(1) + rem[1]});
                }
            }
        }
        return ans;
    }
}
