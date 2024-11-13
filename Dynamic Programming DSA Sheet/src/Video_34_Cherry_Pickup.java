public class Video_34_Cherry_Pickup {
    // https://leetcode.com/problems/cherry-pickup/
    public int cherryPickup(int[][] grid) {
        return Math.max(0, solve(0, 0, 0, 0, grid, new int[grid.length][grid.length][grid.length][grid.length]));
    }

    public int solve(int r1, int c1, int r2, int c2, int[][] grid, int[][][][] dp) {
        if (r1 >= grid.length || c1 >= grid[0].length || r2 >= grid.length || c2 >= grid[0].length || grid[r1][c1] == -1 || grid[r2][c2] == -1) {
            return Integer.MIN_VALUE;
        }

        if (r1 == grid.length - 1 && c1 == grid[0].length - 1) {
            return grid[r1][c1];
        }
        if (dp[r1][c1][r2][c2] != 0) {
            return dp[r1][c1][r2][c2];
        }
        int cherries = 0;
        if (r1 == r2 && c1 == c2) {
            cherries += grid[r1][c1];
        } else {
            cherries += grid[r1][c1] + grid[r2][c2];
        }
        int f1 = solve(r1, c1 + 1, r2, c2 + 1, grid, dp);
        int f2 = solve(r1 + 1, c1, r2, c2 + 1, grid, dp);
        int f3 = solve(r1 + 1, c1, r2 + 1, c2, grid, dp);
        int f4 = solve(r1, c1 + 1, r2 + 1, c2, grid, dp);

        cherries += Math.max(Math.max(f1, f2), Math.max(f3, f4));
        dp[r1][c1][r2][c2] = cherries;
        return cherries;
    }

    public static void main(String[] args) {
        Video_34_Cherry_Pickup a = new Video_34_Cherry_Pickup();
        System.out.println(a.cherryPickup(new int[2][]));
    }
}
