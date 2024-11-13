import java.util.ArrayList;
import java.util.Collections;

public class P_8_Maximum_Star_Sum_of_a_Graph {
    public int maxStarSum(int[] vals, int[][] edges, int k) {

        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();

        for (int i = 0; i < vals.length; i++)
            graph.add(new ArrayList<>());
        for (int[] edge : edges) {

            int u = edge[0];
            int v = edge[1];

            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        int maxSum = Integer.MIN_VALUE;

        for (int i = 0; i < vals.length; i++) {

            ArrayList<Integer> edge = graph.get(i);
            Collections.sort(edge, (a, b) -> {
                return vals[b] - vals[a];
            });

            int max = vals[i];
            maxSum = Math.max(max, maxSum);

            for (int j = 0; j < Math.min(edge.size(), k); j++) {

                max = max + vals[edge.get(j)];
                maxSum = Math.max(maxSum, max);
            }

        }
        return maxSum;
    }
}
