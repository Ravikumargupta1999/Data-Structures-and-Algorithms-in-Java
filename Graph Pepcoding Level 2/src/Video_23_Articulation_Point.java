import java.util.ArrayList;

// https://practice.geeksforgeeks.org/problems/articulation-point-1/0/#
public class Video_23_Articulation_Point {
    int[] parent;
    int[] disc;
    int[] low;
    int time;
    boolean[] visited;
    boolean[] ap;

    public ArrayList<Integer> articulationPoints(int v, ArrayList<ArrayList<Integer>> adj) {
        parent = new int[v];
        disc = new int[v];
        low = new int[v];
        time = 0;
        visited = new boolean[v];
        ap = new boolean[v];
        parent[0] = -1;
        dfs(0, adj);
        ArrayList<Integer> ans = new ArrayList<>();
        for (int i = 0; i < v; i++) {
            if (ap[i])
                ans.add(i);
        }
        if (ans.size() == 0)
            ans.add(-1);
        return ans;
    }

    public void dfs(int u, ArrayList<ArrayList<Integer>> adj) {
        disc[u] = low[u] = time;
        time++;
        int count = 0;
        visited[u] = true;
        ArrayList<Integer> neighbours = adj.get(u);
        for (int i = 0; i < neighbours.size(); i++) {
            int v = neighbours.get(i);
            if (parent[u] == v)
                continue;
            if (visited[v]) {
                low[u] = Math.min(low[u], disc[v]);
            } else {
                parent[v] = u;
                count++;
                dfs(v, adj);
                low[u] = Math.min(low[u], low[v]);
                if (parent[u] == -1) {
                    if (count >= 2) {
                        ap[u] = true;
                    }
                } else {
                    if (low[v] >= disc[u]) {
                        ap[u] = true;
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        int v = 14;
        int[][] arr = {{1, 2}, {2, 3}, {1, 3}, {3, 4}, {4, 8}, {4, 6}, {6, 7}, {5, 7}, {8, 7}, {8, 9}, {9, 10},
                {9, 11}, {11, 14}, {11, 12}, {12, 14}, {11, 13}, {12, 13}};
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < v; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] temp : arr) {
            graph.get(temp[0] - 1).add(temp[1] - 1);
            graph.get(temp[1] - 1).add(temp[0] - 1);
        }
        System.out.println(new Video_23_Articulation_Point().articulationPoints(v,graph));
    }
}
