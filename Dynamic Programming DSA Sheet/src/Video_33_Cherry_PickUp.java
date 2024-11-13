import java.util.ArrayList;

public class Video_33_Cherry_PickUp {
    public int cherryPickup(int[][] grid) {
        ArrayList<Integer> res = new ArrayList<>();
        res.add(0);

        pickUpBottomRight(grid, 0, 0, 0, res);
        return res.get(0);
    }

    public void pickUpBottomRight(int[][] grid, int row, int col, int che, ArrayList<Integer> res) {
        if (row < 0 || row >= grid.length || col < 0 || col >= grid[0].length || grid[row][col] == -1)
            return;

        if (row == grid.length - 1 && col == grid[0].length - 1) {

        }
        int cherry = grid[row][col];
        grid[row][col] = 0;
        pickUpBottomRight(grid, row + 1, col, che + cherry, res);
        pickUpBottomRight(grid, row, col + 1, che + cherry, res);
        grid[row][col] = cherry;
    }

    public void pickLeftUP(int[][] grid, int row, int col, int cherry, ArrayList<Integer> res) {
        if (row < 0 || row >= grid.length || col < 0 || col >= grid[0].length || grid[row][col] == -1)
            return;
        if (row == 0 && col == 0) {
            res.set(0, Math.max(res.get(0), cherry));
            return;
        }
        int che = grid[row][col];
        grid[row][col] = 0;
        pickLeftUP(grid, row - 1, col, cherry + che, res);
        pickLeftUP(grid, row, col - 1, cherry + che, res);
        grid[row][che] = che;
    }

}
