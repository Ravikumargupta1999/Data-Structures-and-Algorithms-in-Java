import java.util.Arrays;

// https://leetcode.com/problems/remove-max-number-of-edges-to-keep-graph-fully-traversable/
public class Video_27_Remove_Max_Number_of_Edges_to_Keep_Graph_Fully_Traversable {
    public int maxNumEdgesToRemove(int n, int[][] edges) {
        Arrays.sort(edges, (a, b) -> Integer.compare(b[0], a[0]));
        int[] parentA = new int[n + 1];
        int[] parentB = new int[n + 1];
        int[] rankA = new int[n + 1];
        int[] rankB = new int[n + 1];
        for (int i = 0; i < parentA.length; i++) {
            parentA[i] = i;
            parentB[i] = i;
            rankA[i] = 1;
            rankB[i] = 1;
        }
        int mergedA = 1;
        int mergedB = 1;
        int removedEdge = 0;
        for (int[] e : edges) {
            if (e[0] == 3) {
                boolean tempA = union(e[1], e[2], parentA, rankA);
                boolean tempB = union(e[1], e[2], parentB, rankB);
                if (tempA)
                    mergedA++;
                if (tempB)
                    mergedB++;
                if (!tempA && !tempB)
                    removedEdge++;
            } else if (e[0] == 1) {
                boolean tempA = union(e[1], e[2], parentA, rankA);
                if (tempA)
                    mergedA++;
                else
                    removedEdge++;
            } else {
                boolean tempB = union(e[1], e[2], parentB, rankB);
                if (tempB)
                    mergedB++;
                else
                    removedEdge++;
            }
        }
        if (mergedA != n || mergedB != n)
            return -1;
        return removedEdge;
    }

    public int find(int x, int[] parent) {
        if (parent[x] == x)
            return x;
        return parent[x] = find(parent[x], parent);
    }

    public boolean union(int x, int y, int[] parent, int[] rank) {
        int lx = find(x, parent);
        int ly = find(y, parent);
        if (lx != ly) {
            if (rank[x] > rank[y]) {
                parent[ly] = lx;
            } else if (rank[x] < rank[y]) {
                parent[lx] = ly;
            } else {
                parent[lx] = ly;
                rank[ly]++;
            }
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] edges = {{3, 1, 2}, {3, 2, 3}, {1, 1, 3}, {1, 2, 4}, {1, 1, 2}, {2, 3, 4}};
        int n = 4;

    }
}
