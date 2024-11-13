package Day_23_Clone_A_Graph;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Bipartite_Graph_BFS {
    // https://leetcode.com/problems/is-graph-bipartite/submissions/
    // https://www.youtube.com/watch?v=nbgaEu-pvkU&list=PLgUwDviBIf0rGEWe64KWas0Nryn7SCRWw&index=11
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        int[] color = new int[n];
        Arrays.fill(color, -1);
        for (int i = 0; i < n; i++) {
            if (color[i] == -1){
                if(!bfsCheck(i,graph,color))
                    return false;
            }
        }
        return true;
    }

    public boolean bfsCheck(int node, int[][] graph, int[] colour) {
        colour[node] = 1;
        Queue<Integer> queue = new LinkedList<>();
        queue.add(node);

        while (!queue.isEmpty()) {
            int temp = queue.poll();

            for (int neighbour : graph[temp]) {
                if (colour[neighbour] == -1) {
                    colour[neighbour] = 1 - colour[temp];
                    queue.add(neighbour);
                }else if(colour[neighbour] == colour[temp])
                    return false;
            }
        }
        return true;
    }
}
