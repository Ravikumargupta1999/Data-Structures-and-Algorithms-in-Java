import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class P_9_Minimum_Score_of_a_Path_Between_Two_Cities {
    // https://leetcode.com/problems/minimum-score-of-a-path-between-two-cities/submissions/912519582/
    //
    public int minScore(int N, int[][] roads) {
        List<List<int[]>> adj = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] road : roads) {
            int u = road[0] - 1, v = road[1] - 1;
            adj.get(u).add(new int[]{v, road[2]});
            adj.get(v).add(new int[]{u, road[2]});

        }
        Queue<Integer> q = new LinkedList<>();
        q.add(0);
        int min = Integer.MAX_VALUE;
        boolean[] visited = new boolean[N];
        visited[0] = true;
        while (!q.isEmpty()) {
            int u = q.poll();
            for (int[] temp : adj.get(u)) {
                int v = temp[0];
                if (!visited[v]) {
                    visited[v] = true;
                    q.add(v);
                }
            }
            for (int[] temp : adj.get(u)) {
                int cost = temp[1];
                min = Math.min(min, cost);
            }
        }
        return visited[N - 1] ? min : -1;
    }
}
