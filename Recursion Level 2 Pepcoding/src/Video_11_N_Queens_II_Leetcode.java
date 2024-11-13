public class Video_11_N_Queens_II_Leetcode {
    // https://leetcode.com/problems/n-queens-ii/
    public int totalNQueens(int n) {
        boolean[][] chess = new boolean[n][n];
        nqueens(0, n, chess, -1);
        return ans;
    }
    int ans = 0;
    public boolean IsQueenSafe(boolean[][] chess, int row, int col) {
        for (int i = row, j = col; j >= 0 && i >= 0; i--, j--) {
            if (chess[i][j])
                return false;
        }

        for (int i = row, j = col; i >= 0; i--) {
            if (chess[i][j])
                return false;
        }

        for (int i = row, j = col; j < chess.length && i >= 0; i--, j++) {
            if (chess[i][j])
                return false;
        }

        for (int i = row, j = col; j < chess.length; j++) {
            if (chess[i][j])
                return false;
        }

        for (int i = row, j = col; j < chess.length && i < chess.length; i++, j++) {
            if (chess[i][j])
                return false;
        }

        for (int i = row, j = col; i < chess.length; i++) {
            if (chess[i][j])
                return false;
        }

        for (int i = row, j = col; j >= 0 && i < chess.length; i++, j--) {
            if (chess[i][j])
                return false;
        }

        for (int i = row, j = col; j >= 0; j--) {
            if (chess[i][j])
                return false;
        }
        return true;
    }

    public void nqueens(int qpsf, int tq, boolean[][] chess, int lcno) {
        if (qpsf == tq) {
            ans++;
            return;
        }

        for (int i = lcno + 1; i < chess.length * chess.length; i++) {
            int row = i / chess.length;
            int col = i % chess.length;

            if (chess[row][col] == false && IsQueenSafe(chess, row, col)) {
                chess[row][col] = true;
                nqueens(qpsf + 1, tq, chess, row * chess.length + col);
                chess[row][col] = false;
            }
        }
    }

}
