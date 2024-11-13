import java.util.ArrayList;
import java.util.List;

public class P_3_All_Paths_From_Source_to_Target {
    // https://leetcode.com/problems/all-paths-from-source-to-target/submissions/912144912/
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {

        List<List<Integer>> res = new ArrayList<>();


        int n = graph.length;



        List<Integer> temp = new ArrayList<>();
        temp.add(0);
        boolean[] visited = new boolean[n];
        visited[0] = true;
        getAllPaths(0, n - 1, visited, temp, res, graph);
        return res;
    }

    public void getAllPaths(int source, int destination, boolean[] visited, List<Integer> temp, List<List<Integer>> res,int[][] graph) {
        if (source == destination ){
            res.add(new ArrayList<>(temp));
            return;
        }

        for (int neighbour : graph[source]) {
            if (!visited[neighbour]) {
                visited[neighbour] = true;
                temp.add(neighbour);
                getAllPaths(neighbour,destination,visited,temp,res,graph);
                visited[neighbour] = false;
                temp.remove(temp.size()-1);
            }
        }
    }

}
