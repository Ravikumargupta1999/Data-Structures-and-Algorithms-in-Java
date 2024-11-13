// https://leetcode.com/problems/redundant-connection/
public class Video_36_Redundant_Connection {
    public int[] findRedundantConnection(int[][] edges) {
        int[] par = new int[edges.length + 1];
        int[] rank = new int[edges.length + 1];
        for (int i = 0; i < par.length; i++) {
            par[i] = i;
            rank[i] = 1;
        }
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            int lu = findPair(u, par);
            int lv = findPair(v, par);
            if (lv != lu) {
                if (rank[lu] > rank[lv]) {
                    par[lv] = lu;
                } else if (rank[lu] < rank[lv]) {
                    par[lu] = lv;
                } else {
                    par[lu] = lv;
                    rank[lv]++;
                }

            } else {
                return edge;
            }
        }
        return new int[2];
    }

    public int findPair(int u, int[] par) {
        if (par[u] == u)
            return u;
        return par[u] = findPair(par[u], par);
    }
}
