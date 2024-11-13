package InterviewQuestion;

public class Video_71_Solve_The_Sudoku {
    // https://practice.geeksforgeeks.org/problems/solve-the-sudoku-1587115621/1
    //Function to find a solved Sudoku.
    static boolean SolveSudoku(int[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {

                if (board[i][j] != 0)
                    continue;

                for (char c = 1; c <= 9; c++) {
                    if (isValid(board, i, j, c)) {
                        board[i][j] = c;
                        if (SolveSudoku(board))
                            return true;
                        else
                            board[i][j] = 0;
                    }
                }
                return false;

            }
        }
        return true;
    }

    static boolean isValid(int[][] board, int row, int col, int ch) {
        // same col checking
        for (int i = 0; i < board[0].length; i++) {
            if (board[row][i] == ch)
                return false;
        }

        // Col checking
        for (int i = 0; i < board.length; i++) {
            if (board[i][col] == ch)
                return false;
        }
        // Same Box checking
        int startRow = 3 * (row / 3);
        int startCol = 3 * (col / 3);

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[startRow + i][startCol + j] == ch)
                    return false;
            }
        }
        return true;
    }

    static void printGrid(int[][] grid) {
        for (int[] temp : grid) {
            for (int val : temp) {
                System.out.print(val + " ");
            }

        }
    }

}
