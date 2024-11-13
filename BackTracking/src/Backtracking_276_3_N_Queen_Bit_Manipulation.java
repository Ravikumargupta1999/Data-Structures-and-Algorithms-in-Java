import java.util.ArrayList;
import java.util.Scanner;

public class Backtracking_276_3_N_Queen_Bit_Manipulation {
    static ArrayList<String> result = new ArrayList<>();
    public static void solve(boolean[][] board, int row, int cols, int nDia, int rDia, String asf) {
        if (row == board.length) {
            result.add(asf);
            return;
        }
        for (int col = 0; col < board.length; ++col) {
            if (((cols & (1 << col)) == 0) && ((nDia & (1 << (row + col))) == 0) && ((rDia & (1 << (row - col + board.length - 1))) == 0)) {
                board[row][col] = true;
                cols ^= (1 << col);
                nDia ^= (1 << (row + col));
//                System.out.println(1 << (row - col + board.length - 1));
                rDia ^= (1 << (row - col + board.length - 1));
                solve(board, row + 1, cols, nDia, rDia, asf + col + "");
                cols ^= (1 << col);
                nDia ^= (1 << (row + col));
                rDia ^= (1 << (row - col + board.length - 1));
                board[row][col] = false;
            }
        }

    }

    public static ArrayList<ArrayList<Integer>> nQueen(int n) {
        boolean[][] board = new boolean[n][n];
        int cols = 0;
        int nDig = 0;
        int rDig = 0;
        solve(board, 0, cols, nDig, rDig, "");
        System.out.println(result);
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
        return result_arr;
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        boolean[][] arr = new boolean[n][n];
        for (int i = 0; i < arr.length; i++)
            for (int j = 0; j < arr[i].length; j++)
                arr[i][j] = false;
        ArrayList<ArrayList<Integer>> result1 = nQueen(n);
        System.out.println(result1.size());
        System.out.println(result1);
    }
}

