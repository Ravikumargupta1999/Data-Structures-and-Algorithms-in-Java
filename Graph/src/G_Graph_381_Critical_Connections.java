import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class G_Graph_381_Critical_Connections {
    // https://practice.geeksforgeeks.org/problems/critical-connections/1
    // https://www.youtube.com/watch?v=BsxYwt7A9Wc&list=PL-Jc9J83PIiEuHrjpZ9m94Nag4fwAvtPQ&index=24


    int[] parent;
    int[] disc;
    int[] low;
    int time;
    boolean[] visited;
    boolean[] ap;

    public ArrayList<ArrayList<Integer>> criticalConnections(int v, ArrayList<ArrayList<Integer>> adj) {

        parent = new int[v];
        disc = new int[v];
        low = new int[v];
        time = 0;
        visited = new boolean[v];
        ap = new boolean[v];
        parent[0] = -1;
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        criticalConnections(0, adj, ans);
        for (int i = 0; i < v; i++) {
            if (!visited[i]) {
                criticalConnections(i, adj, ans);
            }
        }
        Collections.sort(ans, new Sort());
        return ans;
    }

    public void criticalConnections(int u, ArrayList<ArrayList<Integer>> adj, ArrayList<ArrayList<Integer>> ans) {
        disc[u] = low[u] = time;
        time++;

        visited[u] = true;
        ArrayList<Integer> neighbours = adj.get(u);
        for (int i = 0; i < neighbours.size(); i++) {
            int v = neighbours.get(i);
            if (parent[u] == v) {
                continue;
            } else if (visited[v]) {
                low[u] = Math.min(low[u], disc[v]);
            } else {
                parent[v] = u;

                criticalConnections(v, adj, ans);
                low[u] = Math.min(low[u], low[v]);
                if (low[v] > disc[u]) {
                    ArrayList<Integer> al = new ArrayList<>();
                    // if( u < v) {
                    //     al.add(u);
                    //     al.add(v);
                    // }else {
                    al.add(v);
                    al.add(u);
                    // }
                    Collections.sort(al);
                    ans.add(al);
                }
            }
        }

    }

    class Sort implements Comparator<ArrayList<Integer>> {

        public int compare(ArrayList<Integer> a, ArrayList<Integer> b) {

            int x = a.get(0) - b.get(0);

            int y = a.get(1) - b.get(1);

            return x == 0 ? y : x;

        }

    }
}
