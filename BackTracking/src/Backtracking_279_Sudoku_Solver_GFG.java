public class Backtracking_279_Sudoku_Solver_GFG {
    // https://practice.geeksforgeeks.org/problems/solve-the-sudoku-1587115621/1#
    // https://www.youtube.com/watch?v=FWAIf_EVUKE
    public boolean SolveSudoku(int[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == 0) {
                    // 1 to 9 if any value is applicable then return true else return store value
                    // and try for next values
                    // if none from 1 to 9 gives true
                    // return false
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
        }
        return true;
    }

    public boolean isValid(int[][] board, int row, int col, int ch) {
        // Row checking
        for (int i = 0; i < board[0].length; i++) {
            if (board[row][i] == ch) {
                return false;
            }
        }

        // Col checking
        for (int i = 0; i < board.length; i++) {
            if (board[i][col] == ch) {
                return false;
            }
        }
        // Same Box checking
        int startRowPoint = 3 * (row / 3);
        int startColPoint = 3 * (col / 3);

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[startRowPoint + i][startColPoint + j] == ch) {
                    return false;
                }
            }
        }
        return true;

    }


}
