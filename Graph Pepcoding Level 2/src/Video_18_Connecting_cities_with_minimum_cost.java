import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;

// https://www.youtube.com/watch?v=k5SVIlN4hio&list=PL-Jc9J83PIiEuHrjpZ9m94Nag4fwAvtPQ&index=18

// https://www.codingninjas.com/codestudio/problems/connecting-cities-with-minimum-cost_1386586?leftPanelTab=1
public class Video_18_Connecting_cities_with_minimum_cost {
    static class Edge implements Comparable<Edge> {
        int v;
        int wt;

        Edge(int nbr, int wt) {
            this.v = nbr;
            this.wt = wt;
        }

        @Override
        public int compareTo(Edge o) {
            return this.wt - o.wt;
        }
    }

    public static int getMinimumCost(int n, int m, int[][] connections) {

        int vertices = n;
        ArrayList<ArrayList<Edge>> graph = new ArrayList<>();
        for (int i = 0; i < vertices; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] connection : connections) {
            graph.get(connection[0]-1).add(new Edge(connection[1]-1, connection[2]));
            graph.get(connection[1]-1).add(new Edge(connection[0]-1, connection[2]));
        }

        int ans = 0;
        PriorityQueue<Edge> priorityQueue = new PriorityQueue<>();
        boolean[] visited = new boolean[vertices];
        priorityQueue.add(new Edge(0, 0));
        while (priorityQueue.size() > 0) {
            Edge rem = priorityQueue.remove();
            if (visited[rem.v])
                continue;
            visited[rem.v] = true;
            ans = ans + rem.wt;
            ArrayList<Edge> nbrs = graph.get(rem.v);
            for (Edge nbr : nbrs) {
                if (!visited[nbr.v]) {
                    priorityQueue.add(nbr);
                }
            }
        }
        return ans;
    }

}
