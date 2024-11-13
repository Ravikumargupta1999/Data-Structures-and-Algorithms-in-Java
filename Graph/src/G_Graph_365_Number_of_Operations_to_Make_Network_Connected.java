import java.util.ArrayList;

public class G_Graph_365_Number_of_Operations_to_Make_Network_Connected {
    public int makeConnected(int n, int[][] connections) {
        int m = connections.length;
        if (m < n - 1)
            return -1;
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++)
            graph.add(new ArrayList<>());
        for (int i = 0; i < connections.length; i++) {
            graph.get(connections[i][0]).add(connections[i][1]);
            graph.get(connections[i][1]).add(connections[i][0]);
        }
        int count = 0;
        boolean[] visited = new boolean[n];
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                count++;
                DfS(i, graph, visited);
            }
        }
        return count - 1;
    }

    public void DfS(int node, ArrayList<ArrayList<Integer>> graph, boolean[] visited) {
        visited[node] = true;
        for (int neighbour : graph.get(node)) {
            if (!visited[neighbour])
                DfS(neighbour, graph, visited);
        }
    }


}
