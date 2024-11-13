import java.util.*;

// https://www.youtube.com/watch?v=yvt0emtFiIE
public class Backtracking_276_2_N_Queen_Branch_and_Bound {
    static ArrayList<String> result = new ArrayList<>();
    public static ArrayList<ArrayList<Integer>> nQueen(int n) {
        boolean[][] board = new boolean[n][n];
        boolean[] cols = new boolean[n];
        Arrays.fill(cols, false);
        boolean[] n_diagonal = new boolean[2 * n - 1];
        Arrays.fill(n_diagonal, false);
        boolean[] r_diagonal = new boolean[2 * n - 1];
        Arrays.fill(r_diagonal, false);

        solve(board, 0, cols, n_diagonal, r_diagonal, "");

        ArrayList<ArrayList<Integer>> result_arr = new ArrayList<ArrayList<Integer>>();
        for (int i = 0; i < result.size(); i++)
            result_arr.add(i, new ArrayList<Integer>());
        for (int i = 0; i < result.size(); i++) {
            String temp = result.get(i);
            for (int k = 0; k < temp.length(); k++) {
                char c2 = temp.charAt(k);
                int b = c2 - '0';
                result_arr.get(i).add(b + 1);
            }
        }
        Collections.sort(result_arr, new Comparator<ArrayList<Integer>>() {
            @Override
            public int compare(ArrayList<Integer> o1, ArrayList<Integer> o2) {
                for (int i = 0; i < o1.size(); i++) {
                    if (o1.get(i) != o2.get(i))
                        return o1.get(i) - o2.get(i);
                }
                return o1.get(0) - o2.get(0);
            }
        });

        return result_arr;
    }
    public static void solve(boolean[][] board, int row, boolean[] cols, boolean[] nDiag, boolean[] rdiag, String asf) {
        if (row == board.length) {
            result.add(asf);
            return;
        }
        for (int col = 0; col < board[0].length; ++col) {
            if (!cols[col] && !nDiag[row + col] && !rdiag[row - col + board.length - 1]) {
                board[row][col] = true;
                cols[col] = true;
                nDiag[row + col] = true;
                rdiag[row - col + board.length - 1] = true;
                solve(board, row + 1, cols, nDiag, rdiag, asf + +col + "");
                board[row][col] = false;
                cols[col] = false;
                nDiag[row + col] = false;
                rdiag[row - col + board.length - 1] = false;
            }
        }

    }
}
