// https://leetcode.com/problems/satisfiability-of-equality-equations/
public class Video_38_Satisfiability_of_equality_equation {
    int[] par;
    int[] rank;

    public int find(int x) {
        if (par[x] == x)
            return x;
        return par[x] = find(par[x]);
    }

    public boolean union(int x, int y) {
        int lx = find(x);
        int ly = find(y);
        if (lx != ly) {
            if (rank[x] > rank[y]) {
                par[ly] = lx;
            } else if (rank[x] < rank[y]) {
                par[lx] = ly;
            } else {
                par[lx] = ly;
                rank[ly]++;
            }
            return false;
        }
        return true;
    }

    public boolean equationsPossible(String[] equations) {
        par = new int[26];
        rank = new int[26];
        for (int i = 0; i < 26; i++) {
            par[i] = i;
            rank[i] = 1;
        }
        for (String str : equations) {
            if (str.charAt(1) == '=') {
                union(str.charAt(0) - 'a', str.charAt(3) - 'a');
            }
        }
        for (String str : equations) {
            if (str.charAt(1) == '!') {
                int lx = find(str.charAt(0) - 'a');
                int ly = find(str.charAt(3) - 'a');
                if (lx == ly)
                    return false;
            }
        }
        return true;
    }
}
