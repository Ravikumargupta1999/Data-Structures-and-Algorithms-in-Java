import java.util.ArrayList;
import java.util.List;

public class P_6_Find_Eventual_Safe_States {

    // https://www.youtube.com/watch?v=uRbJ1OF9aYM
    // https://leetcode.com/problems/find-eventual-safe-states/submissions/912291315/
    // https://practice.geeksforgeeks.org/problems/eventual-safe-states/1
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n = graph.length;
        boolean[] visited = new boolean[n];
        boolean[] dfsVisit = new boolean[n];
        boolean[] isSafe = new boolean[n];
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                checkCycle(i, graph, dfsVisit, visited, isSafe);
            }
        }

        List<Integer> res = new ArrayList<>();

        for (int i = 0; i < isSafe.length; i++) {
            if (isSafe[i])
                res.add(i);
        }
        return res;
    }

    public boolean checkCycle(int node, int[][] graph, boolean[] dfsVisit, boolean[] visit, boolean[] isSafe) {
        dfsVisit[node] = visit[node] = true;
        isSafe[node] = false;

        for (int neighbour : graph[node]) {
            if (!visit[neighbour]) {
                if(checkCycle(neighbour, graph, dfsVisit, visit, isSafe)){
                    isSafe[node] = false;
                    return true;
                }
            } else if (dfsVisit[neighbour]) {
                isSafe[node] = false;
                return true;
            }
        }
        dfsVisit[node] = false;
        isSafe[node] = true;
        return false;

    }
}