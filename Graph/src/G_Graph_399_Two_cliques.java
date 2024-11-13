import java.util.*;

public class G_Graph_399_Two_cliques {
    // https://www.codingninjas.com/codestudio/problems/two-cliques_1214524?leftPanelTab=1
    // https://www.youtube.com/watch?v=cA8-mdRJuCI&t=53s
    public static boolean twoCliques(int n, ArrayList<ArrayList<Integer>> edgeList) {
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        for (int i = 0; i < n; i++)
            list.add(new ArrayList<>());

        for (ArrayList<Integer> edge : edgeList) {
            int u = edge.get(0);
            int v = edge.get(1);
            list.get(u).add(v);
            list.get(v).add(u);
        }

        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();


        for (int i = 0; i < n; i++) {
            HashSet<Integer> set = new HashSet<>();
            for (int val : list.get(i)) {
                set.add(val);
            }
            ArrayList<Integer> temp = new ArrayList<>();
            for (int k = 0; k < n; k++) {
                if (!set.contains(k) && i != k)
                    temp.add(k);
            }
            graph.add(temp);
        }
        return isBipartite(n, graph);
    }

    static class My_pair {
        int v;
        String psf;
        int level;

        public My_pair(int v, String psf, int level) {
            this.v = v;
            this.psf = psf;
            this.level = level;
        }
    }

    public static boolean isBipartite(int v, ArrayList<ArrayList<Integer>> al) {


        int[] visited = new int[v];
        Arrays.fill(visited, -1);
        for (int i = 0; i < v; i++) {
            if (visited[i] == -1) {
                boolean isCompBipartite = checkComponentBipartiteness(al, i, visited);
                if (!isCompBipartite)
                    return false;
            }
        }
        return true;
    }

    public static boolean checkComponentBipartiteness(ArrayList<ArrayList<Integer>> al, int src, int[] visited) {
        Queue<My_pair> q = new LinkedList<>();
        q.add(new My_pair(src, src + "", 0));
        while (q.size() > 0) {
            My_pair p = q.poll();
            if (visited[p.v] != -1) {
                if (p.level != visited[p.v])
                    return false;
            } else {
                visited[p.v] = p.level;
            }
            for (int e : al.get(p.v)) {
                if (visited[e] == -1) {
                    q.add(new My_pair(e, p.psf + e, p.level + 1));
                }
            }

        }
        return true;
    }
}
