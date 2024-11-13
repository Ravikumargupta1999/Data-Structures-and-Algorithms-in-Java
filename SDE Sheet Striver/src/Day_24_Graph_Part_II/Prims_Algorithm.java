package Day_24_Graph_Part_II;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class Prims_Algorithm {
    static int spanningTree(int V, ArrayList<ArrayList<ArrayList<Integer>>> adj) {
        ArrayList<int[]> result = new ArrayList<>();
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> (a[2] - b[2]));
        pq.add(new int[]{0, -1, 0});
        boolean[] visited = new boolean[V];
        int minWeight = 0;
        while (pq.size() > 0) {
            int[] rem = pq.remove();
            if (visited[rem[0]])
                continue;
            visited[rem[0]] = true;
            minWeight += rem[2];
            for (ArrayList<Integer> e : adj.get(rem[0])) {
                if (!visited[e.get(0)])
                    pq.add(new int[]{e.get(0), rem[0], e.get(1)});
            }

        }
        return minWeight;
    }
}
