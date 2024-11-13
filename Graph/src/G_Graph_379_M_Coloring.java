import java.util.List;

// https://practice.geeksforgeeks.org/problems/m-coloring-problem-1587115620/1#
public class G_Graph_379_M_Coloring {
    public static boolean graphColoring(List<Integer>[] G, int[] color, int source, int C) {

        int V = G.length;
        int[] res = new int[V];
        boolean[] available = new boolean[V];
        res[0] = 0;

        for (int i = 1; i < V; i++) {
            res[i] = -1;
        }

        for (int i = 0; i < V; i++) {
            available[i] = false;
        }

        int cn = 0;
        for (int i = 1; i < V; i++) {
            for (int j = 0; j < G[i].size(); j++) {
                int x = G[i].get(j);
                if (res[x] != -1) {
                    available[res[x]] = true;
                }
            }

            int cr;
            for (cr = 0; cr < V; cr++) {
                if (!available[cr])
                    break;
            }

            res[i] = cr;
            cn = Math.max(cn, cr + 1);
            for (int j = 0; j < G[i].size(); j++) {
                int x = G[i].get(j);
                if (res[x] != -1) {
                    available[res[x]] = false;
                }
            }

        }
        return cn <= C;


    }
}
