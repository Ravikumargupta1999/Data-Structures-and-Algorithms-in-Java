import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Video_6_Queens_Combinations_1_2d_As_2d_Box_Chooses {
    public static void queensCombinations(int qpsf, int tq, int row, int col, String asf) {
        if (row == tq) {
            if (qpsf == tq) {
                System.out.println(asf);
            }
            return;
        }
        int nr = 0;
        int nc = 0;
        String yasf = "";
        String nasf = "";
        if (col == tq - 1) {
            nr = row + 1;
            nc = 0;
            yasf = asf + "q\n";
            nasf = asf + "-\n";
        } else {
            nr = row;
            nc = col + 1;
            yasf = asf + "q";
            nasf = asf + "-";
        }
        queensCombinations(qpsf + 1, tq, nr, nc, yasf);
        queensCombinations(qpsf , tq, nr, nc, nasf);
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        queensCombinations(0, n, 0, 0, "");
    }
}
