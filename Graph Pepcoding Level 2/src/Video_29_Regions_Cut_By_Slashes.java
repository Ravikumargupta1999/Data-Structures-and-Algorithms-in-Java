public class Video_29_Regions_Cut_By_Slashes {
    int[] par;
    int[] rank;
    int count;

    public int find(int x) {
        if (par[x] == x)
            return x;
        return par[x] = find(par[x]);
    }

    public void union(int x, int y) {
        int lx = find(x);
        int ly = find(y);
        if (lx != ly) {
            if (rank[lx] > rank[ly]) {
                par[ly] = lx;
            } else if (rank[lx] < rank[ly]) {
                par[lx] = ly;
            } else {
                par[lx] = ly;
                rank[ly]++;
            }
        }
        else
        {
            count++;
        }
    }

    public int regionsBySlashes(String[] grid) {
        int n = grid.length;
        int dots = n + 1;
        par = new int[dots * dots];
        rank = new int[dots * dots];
        count = 1;

        for (int i = 0; i < par.length; i++) {
            par[i] = i;
            rank[i] = 1;
        }
        for (int i = 0; i < dots; i++) {
            for (int j = 0; j < dots; j++) {
                if (i == 0 || j == 0 || i == dots - 1 || j == dots - 1) {
                    int cellNo = i * dots + j;
                    if (cellNo != 0) {
                        union(0, cellNo);
                    }
                }
            }
        }

        for (int i = 0; i < grid.length; i++) {
            char[] ch = grid[i].toCharArray();
            for (int j = 0; j < ch.length; j++) {
                if (ch[j] == '/') {
                    int cellNo1 = i * dots + j + 1;
                    int cellNo2 = (i + 1) * dots + j;
                    union(cellNo1, cellNo2);
                } else if (ch[j] == '\\') {
                    int cellNo1 = i * dots + j;
                    int cellNo2 = (i + 1) * dots + j + 1;
                    union(cellNo1, cellNo2);
                }
            }
        }
        return count;
    }
}
