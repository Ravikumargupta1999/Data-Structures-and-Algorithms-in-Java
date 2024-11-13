import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class G_Graph_383_Bipartite_Graph {

    public boolean isBipartite(int v, ArrayList<ArrayList<Integer>> al) {

        int[] visited = new int[ v];
        Arrays.fill(visited,-1);
        for (int i = 0; i < v; i++) {
            if (visited[i] == -1) {
                if (!checkComponentBipartiteness(al, i, visited))
                    return false;
            }
        }
        return true;
    }

    public boolean checkComponentBipartiteness(ArrayList<ArrayList<Integer>> al, int src, int[] visited) {
//        int[0] -> vertex    int[1] -> level
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{src, 0});
        while (q.size() > 0) {
            int[] rem = q.poll();
            if (visited[rem[0]] != -1) {
                if (rem[1] != visited[rem[0]])
                    return false;
            } else {
                visited[rem[0]] = rem[1];
            }
            for (int e : al.get(rem[0])) {
                if (visited[e] == -1) {
                    q.add(new int[]{e, rem[1] + 1});
                }
            }

        }
        return true;
    }




    // https://practice.geeksforgeeks.org/problems/bipartite-graph/1/#
//    // https://www.youtube.com/watch?v=ZBhZ1DXGrhA&t=821s
//    // Sumit Malik
//    class My_pair {
//        int v;
//        String psf;
//        int level;
//
//        public My_pair(int v, String psf, int level) {
//            this.v = v;
//            this.psf = psf;
//            this.level = level;
//        }
//    }
//
//    public boolean isBipartite(int v, ArrayList<ArrayList<Integer>> al) {
//
//
//        int[] visited = new int[v];
//        Arrays.fill(visited, -1);
//        for (int i = 0; i < v; i++) {
//            if (visited[i] == -1) {
//                boolean isCompBipartite = checkComponentBipartiteness(al, i, visited);
//                if (!isCompBipartite)
//                    return false;
//            }
//        }
//        return true;
//    }
//
//    public boolean checkComponentBipartiteness(ArrayList<ArrayList<Integer>> al, int src, int[] visited) {
//        Queue<My_pair> q = new LinkedList<>();
//        q.add(new My_pair(src, src + "", 0));
//        while (q.size() > 0) {
//            My_pair p = q.poll();
//            if (visited[p.v] != -1) {
//                if (p.level != visited[p.v])
//                    return false;
//            } else {
//                visited[p.v] = p.level;
//            }
//            for (int e : al.get(p.v)) {
//                if (visited[e] == -1) {
//                    q.add(new My_pair(e, p.psf + e, p.level + 1));
//                }
//            }
//
//        }
//        return true;
//    }
}
