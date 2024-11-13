import java.util.*;

public class G_Graph_387_Cheapest_Flights_Within_K_Stops {
    // My solution using queue
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        ArrayList<ArrayList<int[]>> graph = new ArrayList<>();


        for (int i = 0; i < n; i++)
            graph.add(new ArrayList<>());

        for (int[] flight : flights) {

            int source = flight[0];
            int destination = flight[1];
            int weight = flight[2];


            graph.get(source).add(new int[]{destination, weight});

        }

        boolean[] visited = new boolean[n];

        int[] distance = new int[n];
        Arrays.fill(distance, Integer.MAX_VALUE);

        Queue<int[]> queue = new LinkedList<>();

        queue.add(new int[]{src, 0, 0});

        while (queue.size() > 0) {

            int[] temp = queue.poll();

            int node = temp[0];
            int weights = temp[1];
            int stops = temp[2];

            if (!visited[node]) {
                visited[node] = true;
                distance[node] = weights;
            } else if (stops <= k + 1) {
                distance[node] = Math.min(distance[node], weights);
            }

            for (int[] neighbours : graph.get(node)) {
                int vertex = neighbours[0];
                int weight = neighbours[1];

                if (stops == k + 1) continue;

                if (!visited[vertex] || weight + weights < distance[vertex]) {
                    queue.add(new int[]{vertex, weight + weights, stops + 1});
                }
            }
        }
        return distance[dst] == Integer.MAX_VALUE ? -1 : distance[dst];
    }
    // https://www.youtube.com/watch?v=vWgoPTvQ3Rw
    // https://leetcode.com/problems/cheapest-flights-within-k-stops/submissions/

    public int findCheapestPrice1(int n, int[][] flights, int src, int dst, int k) {
        ArrayList<ArrayList<int[]>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++)
            adj.add(new ArrayList<>());
        for (int ar[] : flights)
            adj.get(ar[0]).add(new int[]{ar[1], ar[2]});
        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        int[] stops = new int[n];
        Arrays.fill(stops, Integer.MAX_VALUE);
        dist[src] = 0;
        stops[src] = 0;
        Queue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        pq.offer(new int[]{src, 0, 0});
        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            if (curr[0] == dst)
                return curr[1];
            if (curr[2] == k + 1)
                continue;
            for (int edge[] : adj.get(curr[0])) {
                int nextDist = curr[1] + edge[1];
                int nextStop = curr[2] + 1;
                if (nextDist < dist[edge[0]] || nextStop < stops[edge[0]]) {
                    dist[edge[0]] = nextDist;
                    stops[edge[0]] = nextStop;
                    pq.offer(new int[]{edge[0], nextDist, nextStop});
                }
            }
        }
        return -1;
    }

}
