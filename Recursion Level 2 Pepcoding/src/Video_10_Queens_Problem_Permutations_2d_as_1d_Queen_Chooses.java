import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Video_10_Queens_Problem_Permutations_2d_as_1d_Queen_Chooses {
    static int count = 0;

    public static boolean IsQueenSafe(int[][] chess, int row, int col) {
        for (int i = row, j = col; j >= 0 && i >= 0; i--, j--) {
            if (chess[i][j] != 0)
                return false;
        }

        for (int i = row, j = col; i >= 0; i--) {
            if (chess[i][j] != 0)
                return false;
        }

        for (int i = row, j = col; j < chess.length && i >= 0; i--, j++) {
            if (chess[i][j] != 0)
                return false;
        }

        for (int i = row, j = col; j < chess.length; j++) {
            if (chess[i][j] != 0)
                return false;
        }

        for (int i = row, j = col; j < chess.length && i < chess.length; i++, j++) {
            if (chess[i][j] != 0)
                return false;
        }

        for (int i = row, j = col; i < chess.length; i++) {
            if (chess[i][j] != 0)
                return false;
        }

        for (int i = row, j = col; j >= 0 && i < chess.length; i++, j--) {
            if (chess[i][j] != 0)
                return false;
        }

        for (int i = row, j = col; j >= 0; j--) {
            if (chess[i][j] != 0)
                return false;
        }
        return true;
    }

    public static void nQueens(int qpsf, int tq, int[][] chess) {
        if (qpsf == tq) {
            count++;
            for (int row = 0; row < chess.length; row++) {
                for (int col = 0; col < chess.length; col++) {
                    if (chess[row][col] == 0)
                        System.out.print("-\t");
                    else
                        System.out.print("q" + (chess[row][col]) + "\t");
                }
                System.out.print("\n");
            }
            System.out.println();
            return;
        }
        for (int cell = 0; cell < chess.length * chess.length; cell++) {
            int row = cell / chess.length;
            int col = cell % chess.length;
            if (chess[row][col] == 0 && IsQueenSafe(chess, row, col)) {
                chess[row][col] = qpsf + 1;
                nQueens(qpsf + 1, tq, chess);
                chess[row][col] = 0;
            }
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] chess = new int[n][n];

        nQueens(0, n, chess);
        System.out.println("\n\n" + count);
    }
}
