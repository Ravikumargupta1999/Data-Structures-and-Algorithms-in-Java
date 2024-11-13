package Day_10_Recursion_and_Backtracking;

public class Sudoku_Solver {
    public void solveSudoku1(char[][] board) {
        SolveSudoku(board);
        return;
    }

    static boolean SolveSudoku(char[][] grid) {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] != '.')
                    continue;
                for (char k = '1'; k <= '9'; k++) {
                    if (valid(i, j, grid, k)) {
                        grid[i][j] = k;
                        if (SolveSudoku(grid))
                            return true;
                        else
                            grid[i][j] = '.';
                    }
                }
                return false;
            }
        }
        return true;
    }

    static boolean valid(int i, int j, char[][] grid, char val) {
        // horizental check
        for (int col = 0; col < 9; col++) {
            if (grid[i][col] == val)
                return false;
        }

        // vertical check
        for (int row = 0; row < 9; row++) {
            if (grid[row][j] == val)
                return false;
        }


        // Box Checking
        int startRow = (3 * (i / 3));
        int startCol = (3 * (j / 3));

        for (int k = 0; k < 3; k++) {
            for (int l = 0; l < 3; l++) {
                int newRow = startRow + k;
                int newCol = startCol + l;
                if(grid[newRow][newCol] == val)
                    return false;
            }
        }
        return true;
    }

}
