package InterviewQuestion;

public class Video_84_Solve_Sudoku {
    // https://practice.geeksforgeeks.org/problems/solve-the-sudoku-1587115621/1
    static boolean SolveSudoku(int[][] grid) {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] != 0)
                    continue;
                for (int k = 1; k <= 9; k++) {
                    if (valid(i, j, grid, k)) {
                        grid[i][j] = k;
                        if (SolveSudoku(grid))
                            return true;
                        else
                            grid[i][j] = 0;
                    }
                }
                return false;
            }
        }
        return true;
    }

    static boolean valid(int i, int j, int[][] grid, int val) {
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

    //Function to print grids of the Sudoku.
    static void printGrid(int grid[][]) {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                System.out.print(grid[i][j] + " ");
            }
        }
        return;
    }
}
