import java.util.ArrayList;
import java.util.HashMap;

public class G_Graph_381_Articulation_Point {
// https://practice.geeksforgeeks.org/problems/articulation-point-1/0/#

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
        for (int v : neighbours) {
            if (parent[u] == v) {
                continue;
            } else if (visited[v]) {
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

    public static String morseToEnglish(String morsecode) {
        String[] arr = morsecode.split(" ");
        HashMap<String, Character> map = new HashMap<>();
        for (int i = 0; i < 26; i++) {
            map.put(arr[i], (char) ('a' + i));
        }

        char ch = '0';
        for (int i = 26; i < 36; i++) {
            map.put(arr[i],ch);
            ch++;
        }

        String ans = "";
        for (String str : morsecode.split(" ")){
            ans = ans +  (map.get(str));
        }
        return ans;
    }
}