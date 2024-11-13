import java.util.ArrayList;
import java.util.Arrays;
// https://leetcode.com/problems/rank-transform-of-a-matrix/submissions/
public class Rank_Transform_of_a_Matrix {
    public class Pair implements Comparable<Pair> {
        int ele;
        int r;
        int c;

        Pair(int ele, int r, int c) {
            this.ele = ele;
            this.c = c;
            this.r = r;

        }

        public int compareTo(Pair o) {
            return this.ele - o.ele;
        }
    }

    int[] rows;
    int[] cols;

    public int findPair(int u, int[] par) {
        if (par[u] < 0)
            return u;
        return par[u] = findPair(par[u], par);
    }

    public void process(ArrayList<Pair> al, int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;
        int[] par = new int[n + m];
        Arrays.fill(par, -1);
        for (Pair p : al) {
            int i = p.r;
            int j = p.c;
            int p1 = findPair(i, par);
            int p2 = findPair(j + n, par);
            if (p1 != p2) {
                int maxRank = Math.min(par[p1], Math.min(par[p2], -Math.max(rows[i], cols[j]) - 1));
                par[p1] = maxRank;
                // grouping
                par[p2] = p1;
            }
        }
        for (Pair p : al) {
            int i = p.r;
            int j = p.c;
            int p1 = findPair(i, par);
            int rank = -par[p1];
            mat[i][j] = rank;
            rows[i] = rank;
            cols[j] = rank;
        }
    }

    public int[][] matrixRankTransform(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        rows = new int[n];
        cols = new int[m];
        Pair[] arr = new Pair[n * m];
        int k = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                arr[k++] = new Pair(matrix[i][j], i, j);
            }
        }
        Arrays.sort(arr);
        ArrayList<Pair> al = new ArrayList<>();
        int last = Integer.MIN_VALUE;
        for (int i = 0; i < n * m; i++) {
            int val = arr[i].ele;
            if (val != last) {
                process(al, matrix);
                last = val;
                al = new ArrayList<>();
            }
            al.add(arr[i]);
        }
        process(al, matrix);
        return matrix;
    }
}
