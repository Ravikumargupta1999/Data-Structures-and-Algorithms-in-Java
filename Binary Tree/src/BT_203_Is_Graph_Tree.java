import java.util.ArrayList;

public class BT_203_Is_Graph_Tree {
    // https://www.codingninjas.com/codestudio/problems/is-graph-tree_1115787?leftPanelTab=1
    public static boolean isGraphTree(int n, ArrayList<ArrayList<Integer>> edgeList) {
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();

        for (int i = 0; i < n; i++)
            graph.add(new ArrayList<>());

        for (ArrayList<Integer> edge : edgeList) {
            graph.get(edge.get(0)).add(edge.get(1));
            graph.get(edge.get(1)).add(edge.get(0));
        }

        //    System.out.println(graph);

        return  !isCycle(n, graph);


    }

    public static boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
        boolean[] visited = new boolean[V];
        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                if (detectCycle(i, -1, adj, visited))
                    return true;
            }
        }
        return false;
    }

    public static boolean detectCycle(int i, int prev, ArrayList<ArrayList<Integer>> adj, boolean[] visited) {
        visited[i] = true;
        for (int neighbour : adj.get(i)) {
            if (!visited[neighbour]) {
                if(detectCycle(neighbour,i,adj,visited))
                    return true;
            } else if (prev != neighbour)
                return true;
        }
        return false;
    }
}
