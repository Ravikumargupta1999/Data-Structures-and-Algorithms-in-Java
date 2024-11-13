package Day_24_Graph_Part_II;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class Kruskals_Algorithm {
    public static class Edge {
        int u;
        int v;
        int wt;

        Edge(int u, int v, int wt) {
            this.u = u;
            this.v = v;
            this.wt = wt;
        }
    }

    static int spanningTree(int n, ArrayList<ArrayList<ArrayList<Integer>>> adj) {

        PriorityQueue<Edge> priorityQueue = new PriorityQueue<>((a, b) -> {
            return a.wt - b.wt;
        });

        boolean[] visited = new boolean[n];
        int ans = 0;
        priorityQueue.add(new Edge(0, -1, 0));
        while (!priorityQueue.isEmpty()) {
            Edge rem = priorityQueue.poll();
//            System.out.println(rem.u+" "+rem.v+"  "+rem.wt);
            if(visited[rem.u])
                continue;
//            System.out.println("hell");
            visited[rem.u] = true;
            if (rem.v != -1) {
                ans += rem.wt;
            }
            ArrayList<ArrayList<Integer>> al = adj.get(rem.u);
            for (ArrayList<Integer> al1 : al) {
                if (!visited[al1.get(0)]) {
                    priorityQueue.add(new Edge(al1.get(0), rem.u, al1.get(1)));
                }
            }
        }
//        System.out.println(ans);
        return ans;

    }
}
