import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

//https://practice.geeksforgeeks.org/problems/minimum-time-taken-by-each-job-to-be-completed-given-by-a-directed-acyclic-graph/0/?page=1&sortBy=accuracy&query=page1sortByaccuracy
// https://www.youtube.com/watch?v=zvOIjamNGSw
public class G_Graph_369_Minimum_time_taken_by_each_job_to_be_completed_given_by_Directed_Acyclic_Graph {
    public static int[] minimumTime(int n, int m, int[][] edges) {
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();


        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
        }

        int[] ans = new int[n];
        int[] inDegree = new int[n + 1];

        for (int[] a : edges) {
            inDegree[a[1]]++;
        }


        Queue<Integer> queue = new LinkedList<>();

        for (int i = 1; i < inDegree.length; i++) {
            if (inDegree[i] == 0)
                queue.add(i);
        }

        int time = 1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-- > 0) {
                int rem = queue.poll();

                ans[rem - 1] = time;
                for (int a : graph.get(rem)) {
                    inDegree[a]--;
                    if (inDegree[a] == 0) {
                        queue.add(a);
                    }
                }
            }
            time++;
        }
        return ans;
    }
}

