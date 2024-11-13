import java.util.ArrayList;

public class G_Graph_379_Graph_Coloring_Problem {
    // https://www.youtube.com/watch?v=h9M0pQ39ha0
    // https://practice.geeksforgeeks.org/problems/m-coloring-problem-1587115620/1#
    // Will fail for disconnected graph
    public int findChromaticNumber(boolean[][] edges, int v) {

        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < v; i++)
            graph.add(new ArrayList<>());

        for (int i = 0; i < edges.length; i++) {
            for (int j = i; j < edges[0].length; j++) {
                if (!edges[i][j])
                    continue;
                graph.get(i).add(j);
                graph.get(j).add(i);
            }
        }


        int[] res = new int[v];
        boolean[] available = new boolean[v];

        res[0] = 0;
        for (int i = 1; i < v; i++) {
            res[i] = -1;
        }

        for (int i = 0; i < v; i++) {
            available[i] = false;
        }

        int cn = 0;
        for (int i = 1; i < v; i++) {
            for (int j = 0; j < graph.get(i).size(); j++) {
                int x = graph.get(i).get(j);
                if (res[x] != -1) {
                    available[res[x]] = true;
                }
            }

            int cr;
            for (cr = 0; cr < v; cr++) {
                if (!available[cr])
                    break;
            }

            res[i] = cr;
            cn = Math.max(cn, cr + 1);

            for (int j = 0; j < graph.get(i).size(); j++) {
                int x = graph.get(i).get(j);
                if (res[x] != -1) {
                    available[res[x]] = false;
                }
            }
        }
        return cn;
    }

    // for single component
    public boolean graphColoring(boolean[][] graph, int m, int n) {
        return findChromaticNumber(graph, n) <= m;
    }
}
