//import com.sun.tools.javac.util.List;

import java.util.ArrayList;
import java.util.LinkedList;

// https://practice.geeksforgeeks.org/problems/strongly-connected-components-kosarajus-algo/1/#
// https://www.youtube.com/watch?v=QtdE7QPsWiU&list=PL-Jc9J83PIiEuHrjpZ9m94Nag4fwAvtPQ&index=21

public class Video_21_Kosaraju_Algorithm {

    public int kosaraju(int v, ArrayList<ArrayList<Integer>> adj) {
        // step 1
        boolean[] visited = new boolean[v];
        LinkedList<Integer> stack = new LinkedList<>();
        for (int i = 0; i < v; i++) {
            if (!visited[i]) {
                dfs1(i, adj, stack, visited);
            }
        }

        // step 2
        ArrayList<ArrayList<Integer>> reversedGraph = new ArrayList<>();
        for (int i = 0; i < v; i++) {
            reversedGraph.add(new ArrayList<>());
        }
        for (int i = 0; i < v; i++) {
            ArrayList<Integer> neighbours = adj.get(i);
            for (int nbr : neighbours) {
                reversedGraph.get(nbr).add(i);
            }
        }

        // step 3;
        int ans = 0;
        visited = new boolean[v];
        while (stack.size() > 0) {
            int rem = stack.removeFirst();
            if (!visited[rem]) {
                dfs2(rem, reversedGraph, visited);
                ans++;
            }
        }
        return ans;
    }

    public void dfs1(int src, ArrayList<ArrayList<Integer>> graph, LinkedList<Integer> stack, boolean[] visited) {
        visited[src] = true;
        ArrayList<Integer> neighbours = graph.get(src);
        for (int nbr : neighbours) {
            if (!visited[nbr]) {
                dfs1(nbr, graph, stack, visited);
            }
        }
        stack.addFirst(src);
    }

    public void dfs2(int src, ArrayList<ArrayList<Integer>> graph, boolean[] visited) {
        visited[src] = true;
        ArrayList<Integer> neighbours = graph.get(src);
        for (int nbr : neighbours) {
            if (!visited[nbr]) {
                dfs2(nbr, graph, visited);
            }
        }
    }

    public static void main(String[] args) {
//        int v = 8;
//        int[][] graph = {{0, 1}, {0, 3}, {0, 4}, {0, 7}, {1, 3}, {1, 5}, {1, 7}, {2, 7}, {3, 4}, {5, 6}, {5, 7}};
//        ArrayList<ArrayList<Integer>> al = new ArrayList<>();
        int v = 5;
        int[][] graph = {{0, 2}, {0, 3}, {1, 0}, {2, 1},{3,4}};
        ArrayList<ArrayList<Integer>> al = new ArrayList<>();
        for (int i = 0; i < v; i++) {
            al.add(new ArrayList<>());
        }
        for (int i = 0; i < graph.length; i++) {
            al.get(graph[i][0]).add(graph[i][1]);
            al.get(graph[i][1]).add(graph[i][0]);
        }
        Video_21_Kosaraju_Algorithm g = new Video_21_Kosaraju_Algorithm();
        System.out.println(g.kosaraju(v, al));
    }

}
