package InterviewQuestion;

import java.util.ArrayList;

public class Video_85_Prerequisite_Tasks {
    // https://practice.geeksforgeeks.org/problems/prerequisite-tasks/1
    // https://www.youtube.com/watch?v=uzVUw90ZFIg&t=46s
    // https://leetcode.com/problems/course-schedule/submissions/
    public boolean isPossible(int N, int[][] prerequisites)
    {
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < N; i++)
            graph.add(new ArrayList<>());

        for (int[] edge : prerequisites) {
            graph.get(edge[0]).add(edge[1]);
        }
        return !isCyclic(N, graph);
    }

    public static boolean isCyclic(int v, ArrayList<ArrayList<Integer>> adj) {
        boolean[] vis = new boolean[v];
        boolean[] dfsVis = new boolean[v];

        for (int i = 0; i < v; i++) {
            if (!vis[i]) {
                if (cycleCheck(i, adj, vis, dfsVis))
                    return true;
            }
        }
        return false;

    }

    public static boolean cycleCheck(int node, ArrayList<ArrayList<Integer>> adj, boolean[] vis, boolean[] dfsVis) {
        vis[node] = true;
        dfsVis[node] = true;

        for (Integer neighbour : adj.get(node)) {
            if (!vis[neighbour]) {
                if (cycleCheck(neighbour, adj, vis, dfsVis)) {
                    return true;
                }
            } else if (dfsVis[neighbour]) {
                return true;
            }
        }
        dfsVis[node] = false;
        return false;

    }

}
