import java.util.*;

public class G_Graph_357_BFS_of_graph {
    public ArrayList<Integer> bfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        ArrayList<Integer> al = new ArrayList<>();
        boolean[] visited = new boolean[V];
        Queue<Integer> queue = new LinkedList<>();
        queue.add(0);
        visited[0] = true;
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-- > 0) {
                int rem = queue.poll();
                al.add(rem);
                for (int val : adj.get(rem)) {
                    if (!visited[val]) {
                        visited[val] = true;
                        queue.add(val);
                    }
                }
            }

        }
        return al;
    }

    private ArrayList<Integer> adj[];
    int V;

    public G_Graph_357_BFS_of_graph(int v) {
        this.V = v;
        adj = new ArrayList[v];
        for (int i = 0; i < v; i++) {
            adj[i] = new ArrayList<>();
        }
    }

    public void addEdge(int source, int destination) {
        adj[source].add(destination);
        adj[destination].add(source);
    }

    public void PrintGraph() {
        System.out.println("Adjacency List : ");
        for (int i = 0; i < V; i++) {
            System.out.print("Node " + i + "  :  ");
            for (int x : adj[i]) {
                System.out.print("->" + x);
            }
            System.out.println();

        }

    }


    public void BFS(int start) {
        ArrayList<Integer> ar = new ArrayList<Integer>();

        boolean visited[] = new boolean[V];
        Queue<Integer> q = new LinkedList<Integer>();
        q.add(start);
        visited[start] = true;
        System.out.print("BFS Traversal starting from vertex 0 : ");
        while (!q.isEmpty()) {
            int node = q.poll();
            System.out.print(node + "  ");

            for (int x : adj[node]) {
                if (!visited[x]) {
                    visited[x] = true;
                    q.add(x);
                }
            }
        }
    }

    public int BFS(int source, int destination) {

        boolean[] visited = new boolean[adj.length];
        int[] Parent = new int[adj.length];
        Queue<Integer> q = new LinkedList<>();
        q.add(source);
        Parent[source] = -1;
        visited[source] = true;

        while (!q.isEmpty()) {
            int cur = q.poll();
            if (cur == destination)
                break;
            for (int neighbour : adj[cur]) {
                if (!visited[neighbour]) {
                    visited[neighbour] = true;
                    q.add(neighbour);
                    Parent[neighbour] = cur;
                }
            }
        }
        int cur = destination;
        int distance = 0;
        while (Parent[cur] != -1) {
            System.out.print(cur + "->");
            cur = Parent[cur];
            distance++;
        }
        System.out.println();

        return distance;

    }

    public static void main(String[] args) {



    }
}


