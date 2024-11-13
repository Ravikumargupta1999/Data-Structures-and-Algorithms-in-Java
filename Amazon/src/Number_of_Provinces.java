import java.util.ArrayList;
import java.util.Arrays;

//https://practice.geeksforgeeks.org/problems/number-of-provinces/1/?company[]=Amazon&company[]=Amazon&difficulty[]=1&page=2&category[]=Graph&query=company[]Amazondifficulty[]1page2company[]Amazoncategory[]Graph

public class Number_of_Provinces {
    static int numProvinces(ArrayList<ArrayList<Integer>> adj, int v) {
        int ans = 0;
        boolean[] visited = new boolean[v];
        for (int i = 0; i < v; i++) {
            if (visited[i] == true)
                continue;
            System.out.println("For ");
            ans++;
            visited[i] = true;
            for (int j = 0; j < adj.get(i).size(); j++) {
                if (j != i && adj.get(i).get(j) == 1)
                    bfs(j, adj, visited);
            }
        }
        return ans;
    }

    static void bfs(int node, ArrayList<ArrayList<Integer>> adj,boolean[] visited) {
        System.out.println(Arrays.toString(visited));
        if( visited[node])
            return;
        visited[node] = true;
        for (int j = 0; j < adj.get(node).size(); j++) {
            if (j != node && adj.get(node).get(j) == 1)
                bfs(j, adj, visited);
        }

    }

    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> al = new ArrayList<>();
        ArrayList<Integer> al1 = new ArrayList<>();
        al1.add(1);
        al1.add(0);
        al1.add(1);
        al.add(al1);

        ArrayList<Integer> al2 = new ArrayList<>();
        al2.add(1);
        al2.add(0);
        al2.add(0);
        al.add(al2);

        ArrayList<Integer> al3 = new ArrayList<>();
        al3.add(1);
        al3.add(0);
        al3.add(1);
        al.add(al3);

        System.out.println(al);

        Number_of_Provinces a= new Number_of_Provinces();
        System.out.println(numProvinces(al,3));
    }
}
