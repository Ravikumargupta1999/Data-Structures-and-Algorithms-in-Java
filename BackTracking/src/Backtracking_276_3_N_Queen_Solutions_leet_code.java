import java.util.*;

public class Backtracking_276_3_N_Queen_Solutions_leet_code {
    ArrayList<String> result = new ArrayList<>();

    public void solve(boolean[][] board, int row, boolean[] cols, boolean[] ndiag, boolean[] rdiag, String asf) {
        if (row == board.length) {
            result.add(asf);
            return;
        }
        for (int col = 0; col < board[0].length; ++col) {
            if (!cols[col] && !ndiag[row + col] && !rdiag[row - col + board.length - 1]) {
                board[row][col] = cols[col] = ndiag[row + col] = rdiag[row - col + board.length - 1] = true;
                solve(board, row + 1, cols, ndiag, rdiag, asf + +col + "");
                board[row][col] = cols[col] = ndiag[row + col] = rdiag[row - col + board.length - 1] = false;
            }
        }

    }

    public List<List<String>> solveNQueens(int n) {
        boolean[][] board = new boolean[n][n];
        boolean[] cols = new boolean[n];
        boolean[] n_diagonal = new boolean[2 * n - 1];
        boolean[] r_diagonal = new boolean[2 * n - 1];
        solve(board, 0, cols, n_diagonal, r_diagonal, "");
        List<List<String>> lists = new ArrayList<>();

        for (int i = 0; i < result.size(); i++)
            lists.add(i, new ArrayList<String>());
        for (int i = 0; i < result.size(); i++) {
            String temp = result.get(i);
            for (int k = 0; k < temp.length(); k++) {

                char c2 = temp.charAt(k);
                int b = c2 - '0';
                String t = "";
                for (int l = 0; l < temp.length(); l++) {
                    if (l == b)
                        t = t + "Q";
                    else
                        t = t + ".";
                }

                lists.get(i).add(t);
            }
        }
        return lists;
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        boolean[][] arr = new boolean[n][n];
        for (int i = 0; i < arr.length; i++)
            for (int j = 0; j < arr[i].length; j++)
                arr[i][j] = false;
        List<List<String>> result1 = new Backtracking_276_3_N_Queen_Solutions_leet_code().solveNQueens(n);
        System.out.println(result1.size());
        System.out.println(result1);
    }
}
