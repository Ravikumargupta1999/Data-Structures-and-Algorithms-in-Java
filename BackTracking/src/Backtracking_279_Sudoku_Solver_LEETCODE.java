public class Backtracking_279_Sudoku_Solver_LEETCODE {
    // https://leetcode.com/problems/sudoku-solver/submissions/
    // https://www.youtube.com/watch?v=FWAIf_EVUKE
    public void solveSudoku(char[][] board) {
        solve(board);
    }
    public boolean solve(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == '.') {
                    for (char c = '1'; c <= '9'; c++) {
                        if (isValid(board, i, j, c)) {
                            board[i][j] = c;
                            if (solve(board))
                                return true;
                            else
                                board[i][j] = '.';
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }

    public boolean isValid(char[][] board, int row, int col, char ch) {
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
