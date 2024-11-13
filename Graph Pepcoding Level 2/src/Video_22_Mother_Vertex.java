import java.util.ArrayList;
import java.util.LinkedList;

// https://practice.geeksforgeeks.org/problems/mother-vertex/1/#
// https://www.youtube.com/watch?v=gNn0L18DUvg&list=PL-Jc9J83PIiEuHrjpZ9m94Nag4fwAvtPQ&index=22

public class Video_22_Mother_Vertex {
    public int findMotherVertex(int v, ArrayList<ArrayList<Integer>>adj)
    {
        boolean[] visited = new boolean[v];
        LinkedList<Integer> stack = new LinkedList<>();
        for (int i = 0; i < v; i++) {
            if (!visited[i]) {
                dfs1(i, adj, stack, visited);
            }
        }
        visited = new boolean[v];
        int val = stack.removeFirst();
        dfs2(val,adj, visited);
        for(int i=0;i<visited.length;i++)
        {
            if(!visited[i])
                return -1;
        }
        return val;
    }

    public void dfs1(int src, ArrayList<ArrayList<Integer>> graph, LinkedList<Integer> stack, boolean[] visited) {
        visited[src] = true;
        ArrayList<Integer> nbrs = graph.get(src);
        for (int nbr : nbrs) {
            if (!visited[nbr]) {
                dfs1(nbr, graph, stack, visited);
            }
        }
        stack.addFirst(src);
    }
    public void dfs2(int src, ArrayList<ArrayList<Integer>> graph, boolean[] visited) {
        visited[src] = true;
        ArrayList<Integer> nbrs = graph.get(src);
        for (int nbr : nbrs) {
            if (!visited[nbr]) {
                dfs2(nbr, graph, visited);
            }
        }
    }

}
