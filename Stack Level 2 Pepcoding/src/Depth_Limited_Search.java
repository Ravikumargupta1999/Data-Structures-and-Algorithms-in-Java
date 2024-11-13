import java.util.*;

public class Depth_Limited_Search {
    LinkedList<Integer> adj[];
    int V;

    class Pair {
        int node;
        int level;
    }

    public Depth_Limited_Search(int v) {
        this.V = v;
        adj = new LinkedList[v + 1];
        for (int i = 0; i < v + 1; i++) {
            adj[i] = new LinkedList<Integer>();
        }
    }

    public void addEdge(int source, int destination) {
        adj[source].add(destination);
        adj[destination].add(source);
    }

    public void PrintGraph() {
        System.out.println("Adjacency List : ");
        for (int i = 1; i < V + 1; i++) {
            System.out.print("Node " + i + "  :  ");
            for (int x : adj[i]) {
                System.out.print(" -> " + x);
            }
            System.out.println();

        }

    }

    public int DLS(int source, int destination, int limit) {
        Stack<Pair> stack = new Stack<>();
        Pair p = new Pair();
        p.level = 0;
        p.node = source;
        stack.add(p);
        boolean[] visited = new boolean[V + 1];
        visited[p.node] = true;
        ArrayList<Integer> al = new ArrayList<>();
        Pair res = solve(destination, limit, stack, al, visited);
        if (res.node != -1) {
            System.out.println("Goal Found on level " + res.level);
            System.out.print("The Path is : ");
            for (int i = 0; i < al.size(); i++)
                if (i != al.size() - 1)
                    System.out.print(al.get(i) + " -> ");
                else
                    System.out.print(al.get(i) + " . ");
            System.out.println("");

        } else {
            System.out.println("Goal Not Found");
        }
        return -1;
    }

    public Pair solve(int destination, int limit, Stack<Pair> st, ArrayList<Integer> al, boolean[] visited) {
        while (!st.isEmpty()) {
            System.out.println(al);
            Pair p = st.pop();
            al.add(p.node);
            if (p.node == destination) {

                return p;
            }
            if (p.level < limit) {
                System.out.println(adj[p.node]);
                for (int i = adj[p.node].size() - 1; i >= 0; i--) {
                    Pair q = new Pair();
                    System.out.println(adj[p.node].get(i));
                    if (visited[adj[p.node].get(i)]) {
                        continue;
                    } else {
                        visited[adj[p.node].get(i)] = true;
                        q.node = adj[p.node].get(i);
                        q.level = p.level + 1;
                        st.add(q);
                        System.out.println(q.node + "  " + q.level);
                    }
                }
            }
            System.out.println("");
        }
        Pair p = new Pair();
        p.node = -1;
        p.level = -1;
        return p;
    }


    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter no of vertices and edge : ");
        int v = sc.nextInt();
        int e = sc.nextInt();
        Depth_Limited_Search a = new Depth_Limited_Search(v);
        System.out.println("Enter " + e + " edges  ");
        for (int i = 1; i < e + 1; i++) {
            System.out.print("Enter source and destination of edge no : " + (i) + "  : ");
            int source = sc.nextInt();
            int destination = sc.nextInt();
            a.addEdge(source, destination);
            System.out.println();
        }
        a.PrintGraph();
        a.PrintGraph();
        System.out.print("Enter source of search : ");
        int s = sc.nextInt();
        System.out.print("Enter destination of search : ");
        int d = sc.nextInt();
        System.out.print("Enter limit of  depth : ");
        int l = sc.nextInt();
        a.DLS(s, d, l);
    }
}