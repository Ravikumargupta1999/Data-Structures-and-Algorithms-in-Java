import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Video_12_Kahns_Algorithm {
    // https://practice.geeksforgeeks.org/problems/topological-sort/1
    // https://www.youtube.com/watch?v=hM7-4viROWo&list=PL-Jc9J83PIiEuHrjpZ9m94Nag4fwAvtPQ&index=12
    // Function to return list containing vertices in Topological order.
    static int[] toposo(int n, ArrayList<ArrayList<Integer>> graph) {
        int[] inDegree = new int[n];
        int[] ans = new int[n];
        for (int i = 0; i < graph.size(); i++) {
            for (int j = 0; j < graph.get(i).size(); j++) {
                inDegree[graph.get(i).get(j)]++;
            }
        }
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (inDegree[i] == 0) {
                queue.add(i);
            }
        }

        int index = 0;
        while (queue.size() > 0) {
            int rem = queue.poll();
            ans[index] = rem;
            index++;
            for (int val : graph.get(rem)) {
                inDegree[val]--;
                if (inDegree[val] == 0) {
                    queue.add(val);
                }
            }
        }
        return index == n ? ans : new int[]{-1};
    }

}
