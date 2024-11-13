import java.util.ArrayList;
import java.util.HashSet;
// https://practice.geeksforgeeks.org/problems/hamiltonian-path2522/1/?company[]=Amazon&company[]=Amazon&difficulty[]=1&page=11&query=company[]Amazondifficulty[]1page11company[]Amazon#

public class Hamiltonian_Path {
    boolean flag;

    boolean check(int N, int M, ArrayList<ArrayList<Integer>> Edges) {
        flag = false;
        ArrayList<ArrayList<Integer>> arrayList = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            arrayList.add(new ArrayList<>());
        }
        for (ArrayList<Integer> al : Edges) {
            arrayList.get(al.get(0)).add(al.get(1));
            arrayList.get(al.get(1)).add(al.get(0));
        }
        boolean[] visited = new boolean[N + 1];
        for (int i = 1; i <= N; i++) {
            dfs(arrayList, i, visited, 1);
        }
        return flag;
    }

    public void dfs(ArrayList<ArrayList<Integer>> arrayList, int src, boolean[] visited, int count) {
        visited[src] = true;
        if (count == arrayList.size() - 1) {
            flag = true;
            return;
        }
        for (int i : arrayList.get(src)) {
            if (!visited[i]) {
                dfs(arrayList, i, visited, count + 1);
            }
        }
        visited[src] = false;
    }

    public static void main(String[] args) {
//        10 14
        int[][] edges = {{8, 1}, {8, 2}, {1, 3}, {5, 4}, {1, 5}, {8, 6}, {1, 7}, {2, 9}, {5, 10}, {7, 8}, {6, 3}, {3, 5}, {7, 9}, {6, 10}};
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < edges.length; i++) {
            ArrayList<Integer> al = new ArrayList<>();
            al.add(edges[i][0]);
            al.add(edges[i][1]);
            graph.add(al);
        }
        Hamiltonian_Path a = new Hamiltonian_Path();
        System.out.println(a.check(10, graph.size(), graph));
    }
}
