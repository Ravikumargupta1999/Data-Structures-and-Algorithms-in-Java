import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

// https://practice.geeksforgeeks.org/problems/minimum-spanning-tree/1

public class Video_14_Kruskals_Algorithm_Pepcoding {
    static int[] parent;
    static int[] rank;

    public static class Edge {
        int u;
        int v;
        int wt;

        Edge(int u, int v, int wt) {
            this.u = u;
            this.v = v;
            this.wt = wt;
        }
    }

    static int spanningTree(int n, ArrayList<ArrayList<ArrayList<Integer>>> adj) {
        ArrayList<Edge> arr = new ArrayList<Edge>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < adj.get(i).size(); j++) {
                int source = i;
                int destination = adj.get(i).get(j).get(0);
                int weight = adj.get(i).get(j).get(1);
                arr.add(new Edge(source, destination, weight));
            }
        }
        Collections.sort(arr, new Comparator<Edge>() {
                    @Override
                    public int compare(Edge o1, Edge o2) {
                        Integer i1 = (Integer) o1.wt;
                        Integer i2 = (Integer) o2.wt;
                        return i1.compareTo(i2);
                    }
                }
        );
        parent = new int[n];
        rank = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
            rank[i] = 1;
        }
        int ans = 0;
        for (int i = 0; i < arr.size(); i++) {
            boolean flag = union(arr.get(i).u, arr.get(i).v);
            if (flag)
                ans += arr.get(i).wt;
        }
        return ans;
    }

    public static boolean union(int x, int y) {
        int lx = find(x);
        int ly = find(y);
        if (lx != ly) {
            if (rank[lx] > rank[ly]) {
                parent[ly] = lx;
            } else if (rank[lx] < rank[ly]) {
                parent[lx] = ly;
            } else {
                parent[lx] = ly;
                rank[ly]++;
            }
            return true;
        } else
            return false;
    }

    public static int find(int x) {
        if (parent[x] == x)
            return x;
        int temp = find(parent[x]);
        parent[x] = temp;
        return temp;
    }
}
