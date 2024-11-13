public class Video_13_N_Knights_Combinations_Gfg_Solution1 {
    public static void Nknight(int m, int n, int k) {
        boolean[][] board = new boolean[m][n];
        solve(board, 0, 0, k);
    }

    public static void solve(boolean[][] board, int i, int j, int knight) {
        if (knight == 0) {
            for (int row = 0; row < board.length; row++) {
                for (int col = 0; col < board[row].length; col++) {

                    if (board[row][col])
                        System.out.print("K ");
                    else
                        System.out.print("A ");
                }
                System.out.print("\n");
            }
            System.out.print("\n\n");
            return;
        }
        for (int col = j + 1; col < board[0].length; col++) {
//            System.out.println(i+"  "+col+"  "+IsKnightSafe(board, i, col));
            if (IsKnightSafe(board, i, col)) {
//                System.out.println(IsKnightSafe(board, i, col));
//                System.out.println(board.length+"  "+board[0].length);
                board[i][col] = true;
                solve(board, i, col, knight - 1);
                board[i][col] = false;
            }
        }

        for (int row = i + 1; row < board.length; row++) {
            for (int col = 0; col < board[row].length; col++) {
                if (IsKnightSafe(board, row, col)) {
                    board[row][col] = true;
                    solve(board, row, col, knight - 1);
                    board[row][col] = false;
                }

            }
        }
    }

    public static boolean IsKnightSafe(boolean[][] chess, int i, int j) {
        if (i - 1 >= 0 && j - 2 >= 0 && chess[i - 1][j - 2])
            return false;
        if (i - 2 >= 0 && j - 1 >= 0 && chess[i - 2][j - 1])
            return false;
        if (i - 1 >= 0 && j + 2 < chess[0].length && chess[i - 1][j + 2])
            return false;
        if (i - 2 >= 0 && j + 1 < chess[0].length && chess[i - 2][j + 1])
            return false;

        if (i + 1 < chess.length && j - 2 >= 0 && chess[i + 1][j - 2])
            return false;
        if (i + 2 < chess.length && j - 1 >= 0 && chess[i + 2][j - 1])
            return false;
        if (i + 1 < chess.length && j + 2 < chess[0].length && chess[i + 1][j + 2])
            return false;
        if (i + 2 < chess.length && j + 1 < chess[0].length && chess[i + 2][j + 1])
            return false;

        return true;
    }

    public static void main(String[] args) {
        Nknight(4, 3, 6);
    }
}
