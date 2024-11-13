import java.util.ArrayList;
import java.util.*;
public class Graph_394_Paths_To_Travel_Each_Nodes_Using_Each_Edge {
    // A class that represents an undirected graph
    static class Graph
    {
        // No. of vertices
        int V;

        // A dynamic array of adjacency lists
        ArrayList<ArrayList<Integer>> adj;

        // Constructor
        Graph(int V)
        {
            this.V = V;
            adj = new ArrayList<ArrayList<Integer>>();

            for(int i=0; i<V; i++){
                adj.add(new ArrayList<Integer>());
            }
        }


        // functions to add and remove edge
        void addEdge(int u, int v)
        {
            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        // This function removes edge u-v from graph.
        // It removes the edge by replacing adjacent
        // vertex value with -1.
        void rmvEdge(int u, int v)
        {
            // Find v in adjacency list of u and replace
            // it with -1
            int iv = find(adj.get(u), v);
            adj.get(u).set(iv, -1);


            // Find u in adjacency list of v and replace
            // it with -1
            int iu = find(adj.get(v), u);
            adj.get(v).set(iu, -1);
        }

        int find(ArrayList<Integer> al, int v){

            for(int i=0; i<al.size(); i++){
                if(al.get(i) == v){
                    return i;
                }
            }

            return -1;
        }

        // Methods to print Eulerian tour
        /* The main function that print Eulerian Trail.
        It first finds an odd degree vertex (if there is any)
        and then calls printEulerUtil() to print the path */
        void printEulerTour()
        {

            // Find a vertex with odd degree
            int u = 0;

            for (int i = 0; i < V; i++){
                if (adj.get(i).size() % 2 == 1)
                {
                    u = i;
                    break;
                }
            }

            // Print tour starting from oddv
            printEulerUtil(u);
            System.out.println();
        }

        // Print Euler tour starting from vertex u
        void printEulerUtil(int u)
        {

            // Recur for all the vertices adjacent to
            // this vertex
            for (int i = 0; i<adj.get(u).size(); ++i)
            {
                int v = adj.get(u).get(i);

                // If edge u-v is not removed and it's a a
                // valid next edge
                if (v != -1 && isValidNextEdge(u, v))
                {
                    System.out.print(u + "-" + v + " ");
                    rmvEdge(u, v);
                    printEulerUtil(v);
                }
            }
        }

        // This function returns count of vertices
        // reachable from v. It does DFS
        // A DFS based function to count reachable
        // vertices from v
        int DFSCount(int v, boolean visited[])
        {
            // Mark the current node as visited
            visited[v] = true;
            int count = 1;

            // Recur for all vertices adjacent to this vertex
            for (int i = 0; i<adj.get(v).size(); ++i){
                int u = adj.get(v).get(i);

                if (u != -1 && !visited[u]){
                    count += DFSCount(u, visited);
                }
            }

            return count;
        }

        // Utility function to check if edge u-v
        // is a valid next edge in Eulerian trail or circuit
        // The function to check if edge u-v can be considered
        // as next edge in Euler Tout
        boolean isValidNextEdge(int u, int v)
        {

            // The edge u-v is valid in one of the following
            // two cases:

            // 1) If v is the only adjacent vertex of u
            int count = 0; // To store count of adjacent vertices
            for (int i = 0; i<adj.get(u).size(); ++i)
                if (adj.get(u).get(i) != -1)
                    count++;
            if (count == 1)
                return true;


            // 2) If there are multiple adjacents, then u-v
            // is not a bridge
            // Do following steps to check if u-v is a bridge

            // 2.a) count of vertices reachable from u
            boolean visited[] = new boolean[V];
            Arrays.fill(visited, false);
            int count1 = DFSCount(u, visited);

            // 2.b) Remove edge (u, v) and after removing
            // the edge, count vertices reachable from u
            rmvEdge(u, v);
            Arrays.fill(visited, false);
            int count2 = DFSCount(u, visited);

            // 2.c) Add the edge back to the graph
            addEdge(u, v);

            // 2.d) If count1 is greater, then edge (u, v)
            // is a bridge
            return (count1 > count2)? false: true;
        }
    }

    // Driver program to test above function
    public static void main(String args[])
    {
        // Let us first create and test
        // graphs shown in above figure
        Graph g1 = new Graph(4);
        g1.addEdge(0, 1);
        g1.addEdge(0, 2);
        g1.addEdge(1, 2);
        g1.addEdge(2, 3);
        g1.printEulerTour();

        Graph g3 = new Graph(4);
        g3.addEdge(0, 1);
        g3.addEdge(1, 0);
        g3.addEdge(0, 2);
        g3.addEdge(2, 0);
        g3.addEdge(2, 3);
        g3.addEdge(3, 1);

        // comment out this line and you will see that
        // it gives TLE because there is no possible
        // output g3.addEdge(0, 3);
        g3.printEulerTour();
    }
}
