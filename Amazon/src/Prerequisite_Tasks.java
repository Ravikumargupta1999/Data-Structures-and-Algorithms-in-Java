import java.util.ArrayList;
import java.util.Scanner;
///https://practice.geeksforgeeks.org/problems/prerequisite-tasks/1/?company[]=Amazon&company[]=Amazon&difficulty[]=1&page=1&query=company[]Amazondifficulty[]1page1company[]Amazon#

public class Prerequisite_Tasks {
    boolean checkCycle(int node, ArrayList<ArrayList<Integer>> adj, int vis[], int dfsVis[]) {
        vis[node] = 1;
        dfsVis[node] = 1;

        for (Integer it : adj.get(node)) {
            if (vis[it] == 0) {
                if (checkCycle(it, adj, vis, dfsVis) == true) {
                    return true;
                }
            } else if (dfsVis[it] == 1) {
                return true;
            }
        }
        dfsVis[node] = 0;
        return false;
    }

    public boolean isCyclic(int N, ArrayList<ArrayList<Integer>> adj) {
        int vis[] = new int[N];
        int dfsVis[] = new int[N];

        for (int i = 0; i < N; i++) {
            if (vis[i] == 0) {
                if (checkCycle(i, adj, vis, dfsVis) == true) return true;
            }
        }
        return false;

    }

    public boolean isPossible(int N, int[][] prerequisites)
    {

        ArrayList<ArrayList<Integer>> al = new ArrayList<ArrayList<Integer>>();
        int v = N+1;
        int e =prerequisites.length;
        for (int i = 0; i < v + 1; i++)
            al.add(new ArrayList<Integer>());
        for(int i=0;i<e;i++)
        {
            int source = prerequisites[i][0];
            int desti = prerequisites[i][1];

            al.get(source).add(desti);
        }
        return !isCyclic(v, al);
    }

    public static void main(String[] args) {
        int n = 3;
        int[][] prerequisites = {{1,0},{0,1}};
        Prerequisite_Tasks a = new Prerequisite_Tasks();
        System.out.println(a.isPossible(n,prerequisites));
    }
}
