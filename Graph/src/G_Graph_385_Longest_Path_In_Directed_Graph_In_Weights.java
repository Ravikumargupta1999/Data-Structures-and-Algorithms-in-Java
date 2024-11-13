import java.util.ArrayList;
import java.util.Arrays;


// https://www.codingninjas.com/codestudio/problems/longest-path-in-directed-graph_1172157?leftPanelTab=1
public class G_Graph_385_Longest_Path_In_Directed_Graph_In_Weights {
    // Run DFS from source
    // In case node is already visited then check if current path is more optimal then revisit that node

    public static ArrayList<Integer> findMaxDistances(int v, int src, ArrayList<ArrayList<Integer>> edges) {
        ArrayList<ArrayList<ArrayList<Integer>>> adj = new ArrayList<>();

        for (int i = 0; i < v; i++) {
            adj.add(new ArrayList<>());
        }

        for (ArrayList<Integer> arrayList : edges) {
            int source = arrayList.get(0);

            int destination = arrayList.get(1);

            int weight = arrayList.get(2);

            ArrayList<Integer> temp = new ArrayList<>();

            temp.add(destination);
            temp.add(weight);

            adj.get(source).add(temp);
        }

        int[] longestPath = new int[v];
        Arrays.fill(longestPath, Integer.MIN_VALUE);

        longestPath[src] = 0;
        boolean[] visited = new boolean[v];

        dfs(src, adj, visited, longestPath);
        for (int i = 0; i < v; i++) {
            longestPath[i] = longestPath[i] == Integer.MIN_VALUE ? -1 : longestPath[i];
        }
        ArrayList<Integer> result = new ArrayList<>();
        for (int t : longestPath)
            result.add(t);
        return result;
    }

    public static void dfs(int src, ArrayList<ArrayList<ArrayList<Integer>>> adj, boolean[] visited, int[] lpt) {
        visited[src] = true;
        for (ArrayList<Integer> list : adj.get(src)) {
            int dest = list.get(0);
            int weight = list.get(1);

            if (!visited[dest] || lpt[dest] < weight + lpt[src]) {
                lpt[dest] = weight + lpt[src];
                dfs(dest, adj, visited, lpt);
            }
        }
    }

}
