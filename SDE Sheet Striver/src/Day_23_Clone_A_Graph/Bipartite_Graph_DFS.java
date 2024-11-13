package Day_23_Clone_A_Graph;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Bipartite_Graph_DFS {
    // https://leetcode.com/problems/is-graph-bipartite/submissions/
//    https://www.youtube.com/watch?v=uC884ske2uQ&list=PLgUwDviBIf0rGEWe64KWas0Nryn7SCRWw&index=12
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        int[] color = new int[n];
        Arrays.fill(color, -1);
        for (int i = 0; i < n; i++) {
            if (color[i] == -1) {
                if (!dfsCheck(i, graph, color))
                    return false;
            }
        }
        return true;
    }

    public boolean dfsCheck(int node, int[][] graph, int[] colour) {

        if (colour[node] == -1)
            colour[node] = 1;


        for (int neighbour : graph[node]) {
            if (colour[neighbour] == -1) {
                colour[neighbour] = 1 - colour[node];
                if(!dfsCheck(neighbour,graph,colour))
                    return false;
            } else if (colour[neighbour] == colour[node])
                return false;

        }
        return true;
    }
}
