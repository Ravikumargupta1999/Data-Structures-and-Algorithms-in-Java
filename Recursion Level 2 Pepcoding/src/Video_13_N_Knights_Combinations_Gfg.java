import java.util.HashSet;
/// https://www.geeksforgeeks.org/place-k-knights-such-that-they-do-not-attack-each-other/
public class Video_13_N_Knights_Combinations_Gfg {
    static int count = 0;

    public static void Nknight(int m, int n, int k) {
        boolean[][] board = new boolean[m][n];
        solve(board, 0, -1, k);
        System.out.println("Total Solution : " + count);
        System.out.println(set);
        System.out.println(set.size());
    }

    static HashSet<String> set = new HashSet<>();

    public static void solve(boolean[][] board, int i, int j, int knight) {
        if (knight == 0) {
            count++;
            String str = "";
            for (int row = 0; row < board.length; row++) {
                for (int col = 0; col < board[row].length; col++) {
                    if (board[row][col]) {
                        str += "K";
                        System.out.print("K ");
                    } else {
                        str += "A";
                        System.out.print("A ");
                    }
                }
                System.out.print("\n");
            }
            set.add(str);
            System.out.print("\n\n");
            return;
        }
        for (int col = j + 1; col < board[0].length; col++) {
            if (IsKnightSafe(board, i, col)) {
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
// these are redundant check as knight are placed above not below
//        if (i + 1 < chess.length && j - 2 >= 0 && chess[i + 1][j - 2])
//            return false;
//        if (i + 2 < chess.length && j - 1 >= 0 && chess[i + 2][j - 1])
//            return false;
//        if (i + 1 < chess.length && j + 2 < chess[0].length && chess[i + 1][j + 2])
//            return false;
//        if (i + 2 < chess.length && j + 1 < chess[0].length && chess[i + 2][j + 1])
//            return false;

        return true;
    }

    public static void main(String[] args) {
        Nknight(4, 4, 4);
    }
}
