import java.util.ArrayList;

public class Greedy_241_Water_Connection_Problem {
    // https://practice.geeksforgeeks.org/problems/water-connection-problem5822/1#
    // https://www.youtube.com/watch?v=PxYviqEuWlA&t=2009s
    static class Pair {
        int end;
        int weight;

        Pair(int end, int weight) {
            this.end = end;
            this.weight = weight;
        }
    }

    static class Pair1 {
        int end;
        int minDiameter;

        Pair1(int end, int minDiameter) {
            this.end = end;
            this.minDiameter = minDiameter;
        }
    }



    ArrayList<ArrayList<Integer>> solve(int n, int p, ArrayList<Integer> a, ArrayList<Integer> b, ArrayList<Integer> d) {
        ArrayList<ArrayList<Pair>> graph = new ArrayList<>();
        for (int i = 0; i <= n; i++)
            graph.add(new ArrayList<>());
        boolean[] in = new boolean[n + 1];
        boolean[] out = new boolean[n + 1];
        for (int i = 0; i < p; i++) {
            out[a.get(i)] = true;
            in[b.get(i)] = true;

            graph.get(a.get(i)).add(new Pair(b.get(i), d.get(i)));
        }

        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        boolean[] visited = new boolean[n + 1];
        for (int i = 1; i <= n; i++) {
            if (!in[i] && out[i] && !visited[i]) {

                Pair1 pair = dfs(i, graph, visited);
                ArrayList<Integer> arrayList = new ArrayList<>();
                arrayList.add(i);
                arrayList.add(pair.end);
                arrayList.add(pair.minDiameter);
                ans.add(arrayList);
            }
        }
        return ans;
    }

    public Pair1 dfs(int node, ArrayList<ArrayList<Pair>> graph, boolean[] visited) {

        visited[node] = true;
        int min = Integer.MAX_VALUE;
        int end = node;
        for (Pair arrayList : graph.get(node)) {
            if (!visited[arrayList.end]) {
                min = Math.min(min, arrayList.weight);
                Pair1 p = dfs(arrayList.end, graph, visited);
                min = Math.min(min, p.minDiameter);
                end = p.end;
            }
        }
        return new Pair1(end, min);
    }

    public static void main(String[] args) {
        int n = 9, p = 6;
        int[] a = {7, 5, 4, 2, 9, 3};
        ArrayList<Integer> a1 = new ArrayList<>();
        for (int val : a)
            a1.add(val);
        int[] b = {4, 9, 6, 8, 7, 1};
        ArrayList<Integer> b1 = new ArrayList<>();
        for (int val : b)
            b1.add(val);
        int[] d = {98, 72, 10, 22, 17, 66};
        ArrayList<Integer> d1 = new ArrayList<>();
        for (int val : d)
            d1.add(val);
        System.out.println(new Greedy_241_Water_Connection_Problem().solve(n, p, a1, b1, d1));
    }

}
