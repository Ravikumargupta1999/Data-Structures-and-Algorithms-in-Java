import java.util.ArrayList;
import java.util.Stack;

public class G_Graph_358_DFS_OF_Graph {
    // Iterative
    public static ArrayList<Integer> dfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        ArrayList<Integer> res = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();
        boolean[] vis = new boolean[V];
        stack.push(0);
        while (!stack.isEmpty()) {
//            System.out.println(stack);
            int temp = stack.pop();
            res.add(temp);
            vis[temp] = true;
            for (int j= 0; j < adj.get(temp).size(); j++) {
                int neighbours = adj.get(temp).get(j);
                if (!vis[neighbours]) {
                    stack.push(neighbours);
                }
            }
        }
//        System.out.println("\n\n");
        return res;
    }

    // Recursive
    public ArrayList<Integer> dfsOfGraph1(int V, ArrayList<ArrayList<Integer>> adj)
    {
        ArrayList<Integer> ar = new ArrayList<Integer>();
        boolean visited[]=new boolean[V];
        ar  = DfsUtil(0,visited,adj,ar);
        return ar;
    }
    public ArrayList<Integer> DfsUtil(int node, boolean visited[],ArrayList<ArrayList<Integer>> adj, ArrayList<Integer> ar)
    {
        visited[node]=true;
        ar.add(node);
        for (int j = 0; j < adj.get(node).size(); j++)
        {
            int x = adj.get(node).get(j);
            if(visited[x]==false)
            {
                DfsUtil(x,visited,adj,ar);
            }
        }
        return ar;

    }

}
//1
//        5 4
//        0 1
//        0 2
//        0 3
//        2 4
