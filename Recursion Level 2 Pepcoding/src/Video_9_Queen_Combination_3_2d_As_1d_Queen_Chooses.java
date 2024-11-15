import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Video_9_Queen_Combination_3_2d_As_1d_Queen_Chooses {
    public static void queensCombinations(int qpsf, int tq, boolean[][] chess, int lcno) {
        if (qpsf == tq) {
            for (int row = 0; row < chess.length; row++) {
                for (int col = 0; col < chess.length; col++) {
                    if (chess[row][col]) {
                        System.out.print("q\t");
                    } else
                        System.out.print("-\t");
                }
                System.out.println();
            }
            System.out.println();
            return;
        }


        for (int cell = lcno + 1; cell < chess.length * chess.length; cell++)
        {
            int row = cell/chess.length;
            int col = cell % chess.length;
            chess[row][col] = true;
            queensCombinations(qpsf + 1, tq, chess, cell);
            chess[row][col] = false;
        }

    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        boolean[][] chess = new boolean[n][n];

        queensCombinations(0, n, chess, -1);
    }
}

