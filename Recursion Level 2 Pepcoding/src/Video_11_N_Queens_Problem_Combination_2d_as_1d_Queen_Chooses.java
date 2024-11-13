import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Video_11_N_Queens_Problem_Combination_2d_as_1d_Queen_Chooses {

    public static boolean IsQueenSafe(boolean[][] chess, int row, int col) {
        for (int i = row, j = col; j >= 0; j--) {
            if (chess[i][j])
                return false;
        }
        for (int i = row, j = col; i >= 0 && j >= 0; i--, j--) {
            if (chess[i][j])
                return false;
        }

        for (int i = row, j = col; i >= 0; i--) {
            if (chess[i][j])
                return false;
        }

        for (int i = row, j = col; i >= 0 && j < chess.length; i--, j++) {
            if (chess[i][j])
                return false;
        }

        for (int i = row, j = col; j < chess.length; j++) {
            if (chess[i][j])
                return false;
        }


        return true;
    }

    public static void nQueens(int qpsf, int tq, boolean[][] chess, int lcno, ArrayList<Integer> temp, ArrayList<ArrayList<Integer>> result) {
        if (qpsf == tq) {
            result.add(new ArrayList<>(temp));
            return;
        }

        for (int i = lcno + 1; i < chess.length * chess.length; i++) {
            int row = i / chess.length;
            int col = i % chess.length;

            if (!chess[row][col] && IsQueenSafe(chess, row, col)) {
                chess[row][col] = true;
                temp.add(col);
                nQueens(qpsf + 1, tq, chess, row * chess.length + col, temp, result);
                chess[row][col] = false;
                temp.remove(temp.size() - 1);
            }
        }
    }

    static ArrayList<ArrayList<Integer>> nQueen(int n) {

        boolean[][] chess = new boolean[n][n];
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        nQueens(0, n, chess, -1, new ArrayList<>(), result);
        Collections.sort(result, new Comparator<ArrayList<Integer>>() {
            @Override
            public int compare(ArrayList<Integer> o1, ArrayList<Integer> o2) {
                for (int i = 0; i < o1.size(); i++) {
                    if (o1.get(i) != o2.get(i))
                        return o1.get(i) - o2.get(i);
                }
                return o1.get(0) - o2.get(0);
            }
        });

        return result;
    }

    public static void main(String[] args) {
        int n = 8;
        ArrayList<ArrayList<Integer>> arrayList = nQueen(n);
        System.out.println(arrayList);
        System.out.println(arrayList.size());

    }

}
