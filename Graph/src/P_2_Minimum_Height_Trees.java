import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class P_2_Minimum_Height_Trees {

    // https://leetcode.com/problems/minimum-height-trees/submissions/912135869/
    // https://www.youtube.com/watch?v=ivl6BHJVcB0
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {

        List<Integer> res = new ArrayList<>();
        if (n == 1) {
            res.add(1);
            return res;
        }

        List<List<Integer>> graph = new ArrayList<>();

        for (int i = 0; i < n; i++)
            graph.add(new ArrayList<>());
        int[] degree = new int[n];
        for (int[] edge : edges) {
            degree[edge[0]]++;
            degree[edge[1]]++;

            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (degree[i] == 1)
                queue.add(i);
        }

        while (n > 2) {

            int size = queue.size();
            n = n - size;
            while (size-- > 0){

                int temp = queue.poll();

                for(int neighbour : graph.get(temp)){
                    degree[neighbour]--;
                    if(degree[neighbour] == 1)
                        queue.add(neighbour);
                }
            }
        }

        res.addAll(queue);

        return res;


    }
}
