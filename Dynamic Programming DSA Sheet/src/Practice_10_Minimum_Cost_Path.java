import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class Practice_10_Minimum_Cost_Path {
    // right
//    public int minimumCostPath(int[][] grid)
//    {
//        ArrayList<Integer> arrayList = new ArrayList<>();
//        arrayList.add(Integer.MAX_VALUE);
//        boolean[][] visited = new boolean[grid.length][grid[0].length];
//
//        DFS(0, 0, grid[0][0], grid, visited, arrayList);
//
//        return arrayList.get(0);
//    }
//
//    int[][] moves = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
//
//    public  void DFS(int i, int j, int sum, int[][] grid, boolean[][] visited, ArrayList<Integer> arrayList) {
//        if (i == grid[0].length - 1 && j == grid[0].length-1) {
//            arrayList.set(0, Math.min(arrayList.get(0), sum));
//            return;
//        }
//        visited[i][j] = true;
//
//        for (int k = 0; k < moves.length;k++ ){
//            int newRow = i + moves[k][0];
//            int newCol = j + moves[k][1];
//
//            if(isValid(newRow,newCol,visited))
//            {
//                DFS(newRow,newCol,sum+grid[newRow][newCol],grid,visited,arrayList);
//            }
//        }
//        visited[i][j] = false;
//    }
//
//    public boolean isValid(int i,int j,boolean[][] visited){
//        return i >=0 && i < visited.length && j>=0 && j < visited[0].length && !visited[i][j];
//    }


    // wrong DP Approach
//    public int minimumCostPath(int[][] grid) {
//        boolean[][] visited = new boolean[grid.length][grid[0].length];
//        int[][] dp = new int[grid.length][grid[0].length];
//        for (int[] temp : dp)
//            Arrays.fill(temp, -1);
//        visited[0][0] = true;
//        return DFS(0, 0, grid[0][0], grid, visited, dp);
//
//
//    }
//
//    int[][] moves = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
//
//    public int DFS(int i, int j, int sum, int[][] grid, boolean[][] visited, int[][] dp) {
//        if (i == grid[0].length - 1 && j == grid[0].length - 1) {
//            return sum;
//        }
//        if (dp[i][j] != -1)
//            return dp[i][j];
//        visited[i][j] = true;
//        int res = Integer.MAX_VALUE;
//        for (int k = 0; k < moves.length; k++) {
//            int newRow = i + moves[k][0];
//            int newCol = j + moves[k][1];
//
//            if (isValid(newRow, newCol, visited)) {
//                visited[newRow][newCol] = true;
//                int temp = DFS(newRow, newCol, sum + grid[newRow][newCol], grid, visited, dp);
//                res = Math.min(res,temp);
//
//
//            }
//        }
//        visited[i][j] = false;
//        return dp[i][j] = res;
//    }
//
//    public boolean isValid(int i, int j, boolean[][] visited) {
//        return i >= 0 && i < visited.length && j >= 0 && j < visited[0].length && !visited[i][j];
//    }

    class Pair{
        int first;
        int[] second;
        public Pair(int first,int[] second){
            this.first = first;
            this.second = second;
        }
    }
    public int minimumCost(int[][] grid) {
        int n = grid.length;
        int[][] dp = new int[n][n];
        for (int[] temp : dp)
            Arrays.fill(temp, -1);
        boolean[][] visited = new boolean[n][n];

        dp[0][0] = grid[0][0];
        int[] dx = {1, -1, 0, 0};
        int[] dy = {0, 0, 1, -1};
        PriorityQueue<Pair> queue = new PriorityQueue<>();
//        priority_queue<pair<int, pair<int, int>>, vector<pair<int, pair<int, int>>>, greater<pair<int, pair<int, int>>>> pq;
        queue.add(new Pair(grid[0][0], new int[]{0, 0}));
        while (queue.size() > 0) {
            Pair p = queue.poll();

            int disttillyet = p.first;
            int r = p.second[0];
            int c = p.second[1];
            for (int k = 0; k < 4; k++) {
                int i = dx[k] + r;
                int j = dy[k] + c;
                if (i >= 0 && j >= 0 && i < n && j < n && !visited[i][j]) {
                    visited[i][j] = true;
                    if (disttillyet + grid[i][j] < dp[i][j]) {
                        dp[i][j] = disttillyet + grid[i][j];
                        queue.add(new Pair(dp[i][j], new int[]{i, j}));
                    }
                }
            }
        }
        return dp[n - 1][n - 1];
    }
}
//4
//        9 4 9 9
//        6 7 6 4
//        8 3 3 7
//        7 4 9 10
