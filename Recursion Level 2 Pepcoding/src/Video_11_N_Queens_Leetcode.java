import java.util.ArrayList;
import java.util.List;
// https://leetcode.com/problems/n-queens/
public class Video_11_N_Queens_Leetcode {
    public List<List<String>> solveNQueens(int n) {
        boolean[][] chess = new boolean[n][n];
        nqueens(0, n, chess, -1);
        return ans;
    }

     List<List<String>> ans = new ArrayList<>();

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
            List<String> temp = new ArrayList<>();
            for (int row = 0; row < chess.length; row++) {
                StringBuilder str = new StringBuilder();
                for (int col = 0; col < chess.length; col++) {
                    if (chess[row][col]) {
                        str.append("Q");
                    } else {
                        str.append(".");
                    }
                }
                temp.add(str.toString());
            }
            ans.add(temp);
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

    public static void main(String[] args) {
        Video_11_N_Queens_Leetcode a = new Video_11_N_Queens_Leetcode();
        System.out.println(a.solveNQueens(2));
    }

}
