import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Stack;

public class Tarjasns_Algorithm {
    HashSet<Integer> adj = new HashSet<>();
    static int time = 0;
    static ArrayList<ArrayList<Integer>> al = new ArrayList<>();
    void DFS(int u, int[] disc, int[] low, Stack<Integer> mystack, boolean[] presentInStack)
    {
      //  static int time = 0;
        disc[u] = low[u] = time;
        time+=1;
        mystack.push(u);
        presentInStack[u] = true;

        for(int v: adj)
        {
            if(disc[v]==-1)	//If v is not visited
            {
                DFS(v,disc,low,mystack,presentInStack);
                low[u] = Math.min(low[u],low[v]);
            }
            //Differentiate back-edge and cross-edge
            else if(presentInStack[v])	//Back-edge case
                low[u] = Math.min(low[u],disc[v]);
        }

        if(low[u]==disc[u])	//If u is head node of SCC
        {
           /// cout<<"SCC is: ";
            while(mystack.peek()!=u)
            {
                System.out.println(mystack.peek());
                presentInStack[mystack.peek()] = false;
                mystack.pop();
            }
            System.out.println(mystack.peek()+"\n");
            presentInStack[mystack.peek()] = false;
            mystack.pop();
        }
    }

    public ArrayList<ArrayList<Integer>> tarjans(int V, ArrayList<ArrayList<Integer>> a)
    {
        int[] disc = new int[V];
        int[] low = new int[V];
        boolean[] presentInStack = new boolean[V];
        Arrays.fill(disc,-1);
        Arrays.fill(disc,-1);
        Arrays.fill(presentInStack,false);
        Stack<Integer> mystack = new Stack<>();

        for(int i=0;i<V;++i)
            if(disc[i]==-1)
                DFS(i,disc,low,mystack,presentInStack);
        return al;
    }

    public static void main(String[] args) {

    }
}
