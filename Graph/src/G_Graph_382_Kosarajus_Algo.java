import java.util.ArrayList;
import java.util.Stack;

public class G_Graph_382_Kosarajus_Algo {
    // https://practice.geeksforgeeks.org/problems/strongly-connected-components-kosarajus-algo/1

    public static int kosaraju(ArrayList<ArrayList<Integer>> graph) {


        // Step 1 :  Do random order DFS and store in Stack
        int n = graph.size();
        boolean[] visited = new boolean[n];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < n; i++) {

            if (!visited[i]) {

                randomOrderDFS(i, graph, visited, stack);
            }
        }


        // Step 2 : Reverse edge

        ArrayList<ArrayList<Integer>> reversedGraph = getReverseGraph(graph);


        // Step 3 : DFS on reversed Graph in order of stored element in stack

        visited = new boolean[n];

        int component = 0;
        while (stack.size() > 0) {

            int top = stack.pop();
            if (!visited[top]) {

                dfs(top, reversedGraph,visited);

                component++;
            }
        }

        return component;
    }

    public static void randomOrderDFS(int node, ArrayList<ArrayList<Integer>> graph, boolean[] visited, Stack<Integer> stack) {
        visited[node] = true;
        for (int neighbour : graph.get(node)) {
            if (!visited[neighbour]) {
                randomOrderDFS(neighbour, graph, visited, stack);
            }
        }
        stack.add(node);
    }

    public static ArrayList<ArrayList<Integer>> getReverseGraph(ArrayList<ArrayList<Integer>> graph) {


        ArrayList<ArrayList<Integer>> reversedGraph = new ArrayList<>();
        for (int i = 0; i < graph.size(); i++) {
            reversedGraph.add(new ArrayList<>());
        }

        for (int i = 0; i < graph.size(); i++) {

            for (int j = 0; j < graph.get(i).size(); j++) {

                int start = i;
                int end = graph.get(i).get(j);

                reversedGraph.get(end).add(start);
            }
        }
        return reversedGraph;
    }

    public static void dfs(int node,ArrayList<ArrayList<Integer>> graph,boolean[] visited){
        visited[node] = true;

        for (int neighbour : graph.get(node)){
            if(!visited[neighbour]) {
                    dfs(neighbour,graph,visited);
            }
        }
    }
}
