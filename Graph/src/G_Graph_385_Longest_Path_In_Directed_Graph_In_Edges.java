import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class G_Graph_385_Longest_Path_In_Directed_Graph_In_Edges {
    // https://www.youtube.com/watch?v=hTaHVDUibeE
    public static int longestPathInDAG(int n, ArrayList<ArrayList<Integer>> graph) {
        int[] inDegree = new int[n + 1];
        int[] LPT = new int[n + 1];

        for (ArrayList<Integer> list : graph) {
            for (int node : list) {
                inDegree[node]++;
            }
        }


        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i < inDegree.length; i++) {
            if (inDegree[i] == 0) {
                queue.add(i);
            }
        }

        int res = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();

            while (size-- > 0) {
                int j = queue.poll();

                for (int node : graph.get(j)) {

                    inDegree[node]--;
                    LPT[node] = Math.max(LPT[node], 1 + LPT[j]);

                    res = Math.max(res, LPT[node]);

                    if (inDegree[node] == 0)
                        queue.add(node);
                }
            }
        }
        System.out.println(Arrays.toString(LPT));
        return res;
    }

    public static void main(String[] args) {
        int vertices = 8;
        int[][] edges = {{1, 3}, {1, 4}, {1, 5}, {2, 3}, {2, 8}, {3, 6}, {4, 6}, {4, 8}, {5, 8}, {6, 7}, {7, 8}};
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for (int i = 0; i <= vertices; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
        }
        System.out.println(longestPathInDAG(vertices, graph));
    }
}
