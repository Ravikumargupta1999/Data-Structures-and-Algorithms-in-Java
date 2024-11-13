import java.util.ArrayList;

public class G_Graph_371_Get_Connected_Component {


    // https://practice.geeksforgeeks.org/problems/number-of-provinces/1/
    static int numProvinces(ArrayList<ArrayList<Integer>> adj, int vertices) {

        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < vertices; i++)
            graph.add(new ArrayList<>());


        for (int i = 0; i < adj.size(); i++) {

            // j == i indicate in adjacency matrix only consider right side element
            for (int j = i; j < adj.get(i).size(); j++) {
                if (adj.get(i).get(j) == 0 || i == j)
                    continue;
                graph.get(i).add(j);
                graph.get(j).add(i);
            }
        }


        int count = 0;
        boolean[] visited = new boolean[vertices];
        for (int i = 0; i < vertices; i++) {
            if (!visited[i]) {
                dfs(i, graph, visited);
                count++;
            }
        }
        return count;
    }

    public static void dfs(int node, ArrayList<ArrayList<Integer>> graph, boolean[] vis) {
        vis[node] = true;

        for (int ver : graph.get(node)) {
            if (!vis[ver])
                dfs(ver, graph, vis);
        }
    }

    public static void main(String[] args) {
        int[][] arr = {
                {1, 0, 1},
                {0, 1, 0},
                {1, 0, 1}
        };

        ArrayList<ArrayList<Integer>> arrayList = new ArrayList<>();
        for (int[] temp : arr) {
            ArrayList<Integer> list = new ArrayList<>();

            for (int v : temp)
                list.add(v);
            arrayList.add(list);
        }
        System.out.println(numProvinces(arrayList, arr.length));
    }
}
