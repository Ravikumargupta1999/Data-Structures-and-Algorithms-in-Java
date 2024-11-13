import java.util.ArrayList;
import java.util.List;

public class G_Graph_386_Journey_To_Moon {
    // https://www.hackerrank.com/challenges/journey-to-the-moon/problem
    // https://www.youtube.com/watch?v=IM1xOjamHA8
    public static long journeyToMoon(int n, List<List<Integer>> astronaut) {

        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        for (List<Integer> list : astronaut) {
            int u = list.get(0);
            int v = list.get(1);
            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        boolean[] visited = new boolean[n];
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                int total = DFS(i, graph, visited);
                list.add(total);

            }
        }
        long total = (n * (n - 1)) / 2;
        for (int i = 0; i < list.size(); i++) {
            int x = (list.get(i) * (list.get(i) - 1)) / 2;
            total = total - x;
        }
        return total;
    }

    public static int DFS(int i, ArrayList<ArrayList<Integer>> graph, boolean[] visited) {
        visited[i] = true;
        int count = 1;
        for (int v : graph.get(i)) {
            if (!visited[v]) {
                count += DFS(v, graph, visited);
            }
        }
        return count;
    }

    // Solution 2
    // https://www.youtube.com/watch?v=dP1Auzs1yJo
    public static long journeyToMoon1(int n, List<List<Integer>> astronaut) {
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        for (List<Integer> list : astronaut) {
            int u = list.get(0);
            int v = list.get(1);
            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        boolean[] visited = new boolean[n];
        long ans = 0;
        long pre = 0;
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                int total = DFS(i, graph, visited);
                ans = ans + pre * total;
                pre = pre + total;
            }
        }
        return ans;
    }

}
