import java.util.ArrayList;
import java.util.PriorityQueue;

public class Video_16_Optimize_Water_Distribution {
    public static int minCostToSupplyWater(int n, int[] wells, int[][] pipes) {
        ArrayList<ArrayList<Pair>> graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i = 0; i < pipes.length; i++) {
            int u = pipes[i][0];
            int v = pipes[i][1];
            int wt = pipes[i][2];

            graph.get(u).add(new Pair(v, wt));
            graph.get(v).add(new Pair(u, wt));
        }
        for (int i = 1; i <= n; i++) {
            graph.get(i).add(new Pair(0, wells[i - 1]));
            graph.get(0).add(new Pair(i, wells[i - 1]));
        }
        int ans = 0;
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        pq.add(new Pair(0, 0));
        boolean[] visited = new boolean[n + 1];
        while (pq.size() > 0) {
            Pair rem = pq.poll();
            if (visited[rem.v]) {
                continue;
            }
            ans += rem.wt;
            visited[rem.v] = true;
            ArrayList<Pair> nbrs = graph.get(rem.v);
            for (Pair nbr : nbrs) {
                if (!visited[nbr.v]) {
                    pq.add(nbr);
                }
            }

        }
        return ans;

    }

    public static class Pair implements Comparable<Pair> {
        int v;
        int wt;

        public Pair(int v, int wt) {
            this.v = v;
            this.wt = wt;
        }

        @Override
        public int compareTo(Pair o) {
            return this.wt - o.wt;
        }
    }
}
