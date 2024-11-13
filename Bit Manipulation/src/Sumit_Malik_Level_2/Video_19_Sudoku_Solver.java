package Sumit_Malik_Level_2;

public class Video_19_Sudoku_Solver {
    // https://leetcode.com/problems/sudoku-solver/submissions/
    public void solveSudoku(char[][] board) {
        int[] rows = new int[9];
        int[] cols = new int[9];
        int[][] grid = new int[3][3];
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                int digit =board[i][j] + '0';
                rows[i] |= (1 << digit);
                cols[j] |= (1 << digit);
                grid[i / 3][j / 3] |= (1 << digit);
            }
        }
        solveSudoku(board, rows, cols, grid, 0, 0);
    }
    public static boolean solveSudoku(char[][] arr, int[] rows, int[] cols, int[][] grid, int i, int j) {
        // write your code here. Use display function to display arr
        if (i == arr.length) {
            return true;
        }
        if (arr[i][j] == '.') {
            for (int nums = 1; nums <= 9; nums++) {
                char val =(char) (nums + '0');
                if ((rows[i] & (1 << nums)) == 0 && (cols[j] & (1 << nums)) == 0 && (grid[i / 3][j / 3] & (1 << nums)) == 0) {
                    arr[i][j] = val;
                    rows[i] ^= (1 << nums);
                    cols[j] ^= (1 << nums);
                    grid[i / 3][j / 3] ^= (1 << nums);
                    if (solveSudoku(arr, rows, cols, grid, j < 8 ? i : i + 1, j < 8 ? j + 1 : 0))
                        return true;
                    else {
                        arr[i][j] = '.';
                        rows[i] ^= (1 << nums);
                        cols[j] ^= (1 << nums);
                        grid[i / 3][j / 3] ^= (1 << nums);
                    }
                }
            }
            return false;
        }
        return solveSudoku(arr, rows, cols, grid, j < 8 ? i : i + 1, j < 8 ? j + 1 : 0);
    }
}
