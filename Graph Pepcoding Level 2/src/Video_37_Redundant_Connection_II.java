import java.util.Arrays;
// https://leetcode.com/problems/redundant-connection-ii/submissions/
public class Video_37_Redundant_Connection_II {
    int[] par;
    int[] rank;

    public int find(int x) {
        if (par[x] == x)
            return x;
        return par[x] = find(par[x]);
    }

    public boolean union(int x, int y) {
        int lx = find(x);
        int ly = find(y);
        if (lx != ly) {
            if (rank[x] > rank[y]) {
                par[ly] = lx;
            } else if (rank[x] < rank[y]) {
                par[lx] = ly;
            } else {
                par[lx] = ly;
                rank[ly]++;
            }
            return false;
        }
        return true;
    }

    public int[] findRedundantDirectedConnection(int[][] edges) {
        int n = edges.length;
        int[] inDegrees = new int[edges.length + 1];
        Arrays.fill(inDegrees, -1);
        int bl1 = -1;
        int bl2 = -1;
        for (int i = 0; i < edges.length; i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            if (inDegrees[v] == -1) {
                inDegrees[v] = i;
            } else {
                bl1 = i;
                bl2 = inDegrees[v];
                break;
            }
        }
        par = new int[n+1];
        rank = new int[n+1];
        for(int i=0;i<=n;i++)
        {
            par[i] = i;
            rank[i] = 1;
        }
        for (int i= 0;i<edges.length;i++)
        {
            if( i == bl1)
                continue;
            int u = edges[i][0];
            int v = edges[i][1];

            boolean flag = union(u,v);
            if(flag )
            {
                if(bl1 == -1)
                    return edges[i]; // case 2
                else
                    return edges[bl2]; // case 3
            }
        }
        return edges[bl1]; // case 1
    }
}
