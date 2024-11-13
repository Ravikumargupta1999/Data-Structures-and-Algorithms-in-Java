package Biweekly_Contest_92;

public class Difference_Between_Ones_and_Zeros_In_Row_And_Column {
    public int[][] onesMinusZeros(int[][] grid) {
        int[] onesRow = new int[grid.length];
        int[] zeroRow = new int[grid.length];

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 0)
                    zeroRow[i]++;
                else
                    onesRow[i]++;
            }
        }

        int[] onesCol = new int[grid[0].length];
        int[] zeroCol = new int[grid[0].length];
        for (int j = 0; j < grid[0].length; j++) {
            for (int i = 0; i < grid.length; i++) {
                if (grid[i][j] == 0)
                    zeroCol[j]++;
                else
                    onesCol[j]++;
            }
        }
        int[][] res = new int[grid.length][grid[0].length];
        for (int j = 0; j < grid[0].length; j++) {
            for (int i = 0; i < grid.length; i++) {
                res[i][j] = onesRow[i] + onesCol[j] - zeroRow[i] - zeroCol[j];
            }
        }
        return res;
    }
}
