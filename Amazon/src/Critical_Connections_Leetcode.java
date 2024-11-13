import java.util.ArrayList;
import java.util.List;

//https://leetcode.com/problems/critical-connections-in-a-network/submissions/

public class Critical_Connections_Leetcode {
    int[] parent;
    int[] disc;
    int[] low;
    int time;
    boolean[] vis;

    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> Edges) {
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
        List<List<Integer>> ans = new ArrayList<>();
        int src = 0;
        bridges(src, graph, ans);
        return ans;
    }

    public void bridges(int u, ArrayList<ArrayList<Integer>> graph, List<List<Integer>> ans) {
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
                    List<Integer> temp = new ArrayList<>();
                    temp.add(u);
                    temp.add(v);
                    ans.add(temp);
                }
            }
        }
    }
}
