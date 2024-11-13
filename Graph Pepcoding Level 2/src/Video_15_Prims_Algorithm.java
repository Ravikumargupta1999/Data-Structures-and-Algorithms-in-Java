import java.util.ArrayList;
import java.util.PriorityQueue;
// https://practice.geeksforgeeks.org/problems/minimum-spanning-tree/1#
// https://www.youtube.com/watch?v=Vw-sktU1zmc
public class Video_15_Prims_Algorithm {
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

        PriorityQueue<Edge> priorityQueue = new PriorityQueue<>((a, b) -> {
            return a.wt - b.wt;
        });

        boolean[] visited = new boolean[n];
        int ans = 0;
        priorityQueue.add(new Edge(0, -1, 0));
        while (!priorityQueue.isEmpty()) {
            Edge rem = priorityQueue.poll();
//            System.out.println(rem.u+" "+rem.v+"  "+rem.wt);
            if(visited[rem.u])
                continue;
//            System.out.println("hell");
            visited[rem.u] = true;
            if (rem.v != -1) {
                ans += rem.wt;
            }
            ArrayList<ArrayList<Integer>> al = adj.get(rem.u);
            for (ArrayList<Integer> al1 : al) {
                if (!visited[al1.get(0)]) {
                    priorityQueue.add(new Edge(al1.get(0), rem.u, al1.get(1)));
                }
            }
        }
//        System.out.println(ans);
        return ans;

    }

    public static void main(String[] args) {
        int v = 3;
        int e = 3;
        ArrayList<ArrayList<ArrayList<Integer>>> adj = new ArrayList<ArrayList<ArrayList<Integer>>>();
        for (int i = 0; i < v; i++) {
            adj.add(new ArrayList<ArrayList<Integer>>());
        }
        ArrayList<Integer> al1 = new ArrayList<>();
        ArrayList<Integer> al2 = new ArrayList<>();
        al1.add(0);
        al1.add(5);
        al2.add(1);
        al2.add(5);
        adj.get(0).add(al2);
        adj.get(1).add(al1);

        al1 = new ArrayList<>();
        al2 = new ArrayList<>();
        al1.add(1);
        al1.add(3);
        al2.add(2);
        al2.add(3);
        adj.get(1).add(al2);
        adj.get(2).add(al1);

        al1 = new ArrayList<>();
        al2 = new ArrayList<>();
        al1.add(0);
        al1.add(1);
        al2.add(2);
        al2.add(1);
        adj.get(0).add(al2);
        adj.get(2).add(al1);
        spanningTree(v,adj);


    }
}
//3 3
//        0 1 5
//        1 2 3
//        0 2 1