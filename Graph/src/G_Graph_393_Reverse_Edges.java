import java.util.*;

// https://www.geeksforgeeks.org/minimum-edges-reverse-make-path-source-destination/
public class G_Graph_393_Reverse_Edges {
    // https://www.codingninjas.com/codestudio/problems/reverse-edges_1200162?leftPanelTab=1
    // https://www.geeksforgeeks.org/minimum-edges-reverse-make-path-source-destination/
    public static int getMinEdgeReversal(int n, int start, int end, ArrayList<ArrayList<Integer>> edgeList) {
        ArrayList<ArrayList<ArrayList<Integer>>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        for (ArrayList<Integer> arrayList : edgeList) {
            int u = arrayList.get(0);
            int v = arrayList.get(1);

            ArrayList<Integer> temp1 = new ArrayList<>();
            temp1.add(v);
            temp1.add(0);
            graph.get(u).add(temp1);

            ArrayList<Integer> temp2 = new ArrayList<>();
            temp2.add(u);
            temp2.add(1);
            graph.get(v).add(temp2);
        }

        int[] ans = dijkstra(n, graph, start);
        return ans[end];
    }

    static int[] dijkstra(int V, ArrayList<ArrayList<ArrayList<Integer>>> adj, int S) {
        int[] ans = new int[V];
        boolean[] visited = new boolean[V];
        PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> (a[1] - b[1]));
        queue.add(new int[]{S, 0});
        while (!queue.isEmpty()) {
            int[] rem = queue.poll();
            if (visited[rem[0]])
                continue;
            ans[rem[0]] = rem[1];
            visited[rem[0]] = true;
            for (ArrayList<Integer> arrayList : adj.get(rem[0])) {
                if (!visited[arrayList.get(0)]) {
                    queue.add(new int[]{arrayList.get(0), arrayList.get(1) + rem[1]});
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {

        int V = 7;
        int[][] arr = {{0, 1}, {2, 1},
                {2, 3}, {5, 1},
                {4, 5}, {6, 4},
                {6, 3}};
        int E = arr.length;
        ArrayList<ArrayList<Integer>> edge = new ArrayList<>();

        for (int[] a : arr) {
            ArrayList<Integer> temp = new ArrayList<>();
            temp.add(a[0]);
            temp.add(a[1]);
            edge.add(temp);
        }
        int minEdgeToReverse = getMinEdgeReversal(V, 0, 6, edge);
        if (minEdgeToReverse != -1)
            System.out.println(minEdgeToReverse);
        else
            System.out.println("Not possible");
    }
}

//    public static void main(String[] args) {
//        int V = 4;
//        int E = 3;
//        int[][] arr = {0,1}
//    }
//        V:   4    Edge : 3
//        start :  0    end : 3
//        edge1 :  0  1
//        edge2 :  0  2
//        edge3 :  3  2