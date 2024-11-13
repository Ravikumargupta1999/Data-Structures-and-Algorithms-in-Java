import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.Stack;

public class Iterative_Deepening_Depth_First_Search {
    LinkedList<Integer> adj[];
    int V;

    class Pair {
        int node;
        int level;
    }

    public Iterative_Deepening_Depth_First_Search(int v) {
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


    public void IDDFS(int source, int destination) {
        int total_nodes = 0;
        boolean found = false;
        int l = 0;
        while (total_nodes < V) {
            if (found)
                break;
            total_nodes = 0;
            Stack<Pair> st = new Stack<>();
            Pair temp = new Pair();
            temp.level = 0;
            temp.node = source;
            st.add(temp);
            boolean[] visited = new boolean[V + 1];
            visited[temp.node] = true;
            ArrayList<Integer> al = new ArrayList<>();
            while (!st.isEmpty()) {
                Pair p = st.pop();
                al.add(p.node);
                total_nodes++;
                if (p.node == destination) {
                    found = true;
                    System.out.println("Goal found at level " + p.level + " and iteration " + (l + 1));
                    break;
                }
                if (p.level < l) {
                    for (int i = adj[p.node].size() - 1; i >= 0; i--) {
                        Pair q = new Pair();
//                        System.out.println(adj[p.node].get(i));
                        if (visited[adj[p.node].get(i)]) {
                            continue;
                        } else {
                            visited[adj[p.node].get(i)] = true;
                            q.node = adj[p.node].get(i);
                            q.level = p.level + 1;
                            st.add(q);
                        }
                    }
                }


            }
            System.out.print("Node traversed in iteration " + (l + 1) + "  : ");
            for (int i = 0; i < al.size(); i++) {
                System.out.print(al.get(i) + "  ");
            }
            System.out.println("");
            if (found)
                break;
            l++;
        }
        if (!found)
            System.out.println("Goal not found .");

    }


    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter no of vertices and edge : ");
        int v = sc.nextInt();
        int e = sc.nextInt();
        Iterative_Deepening_Depth_First_Search a = new Iterative_Deepening_Depth_First_Search(v);
        System.out.println("Enter " + e + " edges  ");
        for (int i = 1; i < e + 1; i++) {
            System.out.print("Enter source and destination of edge no : " + (i) + "  : ");
            int source = sc.nextInt();
            int destination = sc.nextInt();
            a.addEdge(source, destination);
            System.out.println();
        }
        a.PrintGraph();
        System.out.print("Enter source of search : ");
        int s = sc.nextInt();
        System.out.print("Enter destination of search : ");
        int d = sc.nextInt();
        a.IDDFS(s, d);
    }
}