import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Video_8_Queens_Combination_2_Queen_Chooses {


    public static void queensCombinations(int qpsf, int tq, boolean[][] chess, int i, int j){
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


        for (int col = j + 1; col < chess.length; col++) {
            chess[i][col] = true;
            queensCombinations(qpsf + 1, tq, chess, i, col);
            chess[i][col] = false;

        }

        for (int row = i + 1; row < chess.length; row++) {
            for (int col = 0; col < chess.length; col++) {
                chess[row][col] = true;
                queensCombinations(qpsf + 1, tq, chess, row, col);
                chess[row][col] = false;

            }
        }

    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        boolean[][] chess = new boolean[n][n];

        queensCombinations(0, n, chess, 0, 0);
    }

}
//    q	q
//-	-
//
//        q	-
//        q	-
//
//        q	-
//        -	q
//
//        -	q
//        q	-
//
//        -	q
//        -	q
//
//        -	-
//        q	q