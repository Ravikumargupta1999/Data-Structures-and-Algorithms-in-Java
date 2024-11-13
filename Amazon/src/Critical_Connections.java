import java.lang.reflect.Array;
import  java.util.*;
//https://practice.geeksforgeeks.org/problems/critical-connections/1/?company[]=Amazon&company[]=Amazon&page=2&category[]=Graph&query=company[]Amazonpage2company[]Amazoncategory[]Graph#

public class Critical_Connections {
    int[] parent;
    int[] disc;
    int[] low;
    int time;
    boolean[] vis;

    public ArrayList<ArrayList<Integer>> criticalConnections(int n, ArrayList<ArrayList<Integer>> Edges) {
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for(int i=0;i<n;i++)
        {
            graph.add(new ArrayList<>());
        }
        for(int i=0;i<Edges.size();i++)
        {
            int u = Edges.get(i).get(0);
            int v = Edges.get(i).get(1);
            graph.get(u).add(v);
            graph.get(v).add(u);

        }
        parent = new int[n];
        disc = new int[n];
        low = new int[n];
        time = 0;
        vis = new boolean[n];
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        int src = 0;
        bridges(src, graph, ans);
        return ans;
    }

    public void bridges(int u, ArrayList<ArrayList<Integer>> graph, ArrayList<ArrayList<Integer>> ans) {
        disc[u] = low[u] = time;
        time++;
        vis[u] = true;
        for (int i = 0; i < graph.get(u).size(); i++) {
            int v = graph.get(u).get(i);
            if (parent[u] == v)
                continue;
            else if (vis[v] == true) {
                low[u] = Math.min(low[u], disc[v]);
            } else {
                parent[v] = u;
                bridges(v, graph, ans);
                low[u] = Math.min(low[u], low[v]);
                if (low[v] > disc[u]) {
                    ArrayList<Integer> temp = new ArrayList<>();
                    temp.add(u);
                    temp.add(v);
                    ans.add(temp);
                }
            }
        }
    }

    public static void main(String[] args) {
        System.out.println("J");
    }
}