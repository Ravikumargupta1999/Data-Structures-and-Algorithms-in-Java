package InterviewQuestion;

public class Video_71_Is_Valid_Sudoku {
    static int isValid(int mat[][]) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (mat[i][j] != 0) {
                    int val = mat[i][j];
                    if (!check(mat, i, j, val))
                        return 0;
                }
            }
        }
        return 1;
    }

    public static boolean check(int[][] grid, int row, int col, int val) {

        // check same row
        for (int i = 0; i < 9; i++) {
            if (i != col) {
                if (grid[row][i] == val)
                    return false;
            }
        }

        // check same col
        for (int i = 0; i < 9; i++) {
            if (i != row) {
                if (grid[i][col] == val)
                    return false;
            }
        }

        // check box
        int startRow = 3 * (row / 3);
        int startCol = 3 * (col / 3);

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                int newRow = startRow + i;
                int newCol = startCol + j;
                if (newCol != col && newRow != row) {
                    if (grid[newRow][newCol] == val)
                        return false;
                }
            }
        }
        return true;
    }
}
