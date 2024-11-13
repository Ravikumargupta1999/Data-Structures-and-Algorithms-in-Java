package Day_23_Clone_A_Graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BFS_Of_Graph {
    public ArrayList<Integer> bfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        ArrayList<Integer> al = new ArrayList<>();
        boolean[] visited = new boolean[V];
        Queue<Integer> queue = new LinkedList<>();
        queue.add(0);
        visited[0] = true;
        while (!queue.isEmpty()){
            int size = queue.size();
            while (size-- > 0) {
                int rem = queue.poll();
                al.add(rem);
                for (int val : adj.get(rem)){
                    if(!visited[val]){
                        visited[val] = true;
                        queue.add(val);
                    }
                }
            }

        }
        return al;
    }
}
