import java.util.Comparator;
import java.util.PriorityQueue;

public class Minimum_Cost_Path {
//    https://practice.geeksforgeeks.org/problems/minimum-cost-path3833/1?page=6&company[]=Amazon&curated[]=1&sortBy=submissions
    public int minimumCostPath(int[][] grid)
    {
        // Code here
        PriorityQueue<Triplet> pq = new PriorityQueue<>(new Comparator<Triplet>() {
            @Override
            public int compare(Triplet t1, Triplet t2) {
                return t1.dist - t2.dist;
            }
        });

        int[] row = {1, -1, 0, 0};
        int[] col = {0, 0, 1, -1};

        int[][] dist = new int[grid.length][grid[0].length];
        boolean[][] isVisited = new boolean[grid.length][grid[0].length];

        for(int i=0;i<grid.length;i++) {
            for(int j=0;j<grid[0].length;j++) {
                dist[i][j] = Integer.MAX_VALUE;
            }
        }

        dist[0][0] = grid[0][0];

        pq.add(new Triplet(0, 0, dist[0][0]));
        isVisited[0][0] = true;

        while(pq.isEmpty() == false) {
            Triplet top = pq.remove();

            int i = top.row;
            int j = top.col;
            int currDist = top.dist;

            for(int k=0;k<4;k++) {
                int nRow = i + row[k];
                int nCol = j + col[k];

                if(nRow >= 0 && nRow < grid.length && nCol >=0 && nCol < grid[0].length) {
                    if(isVisited[nRow][nCol] == false) {
                        isVisited[nRow][nCol] = true;
                        pq.add(new Triplet(nRow, nCol, currDist + grid[nRow][nCol]));
                    }
                    dist[nRow][nCol] = Math.min(dist[nRow][nCol], currDist + grid[nRow][nCol]);
                }
            }
        }

        return dist[grid.length-1][grid[0].length-1];
    }

    class Triplet {
        int row;
        int col;
        int dist;

        Triplet(int row, int col, int dist) {
            this.row = row;
            this.col = col;
            this.dist = dist;
        }

    }
}
