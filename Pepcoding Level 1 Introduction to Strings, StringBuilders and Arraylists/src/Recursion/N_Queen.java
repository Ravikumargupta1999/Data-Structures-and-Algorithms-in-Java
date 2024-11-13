package Recursion;
// http://www.durangobill.com/N_Queens.html
public class N_Queen {
    public static void main(String[] args) {
        int n = 6;
        int[][] chess = new int[n][n];
        printNqueen(chess, "", 0);
        if (count == 0)
            System.out.println(-1);
        else
            System.out.println(count);
    }

    static int count = 0;

    public static void printNqueen(int[][] chess, String asf, int row) {
        if (chess.length == row) {
            System.out.println(asf);
            count++;
            return;
        }
        for (int col = 0; col < chess.length; col++) {
            if (isItSafeToPlaceQueen(chess, row, col)) {
                chess[row][col] = 1;
                printNqueen(chess, asf + row + " - " + col + ", ", row + 1);
                chess[row][col] = 0;
            }
        }
    }

    public static boolean isItSafeToPlaceQueen(int[][] chess, int row, int col) {
        // Checking if can be placed in Upward direction
        for (int i = row - 1, j = col; i >= 0; i--) {
            if (chess[i][j] == 1)
                return false;
        }
        // Checking for left diagonal
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (chess[i][j] == 1)
                return false;
        }
        // Checking for right diagonal
        for (int i = row - 1, j = col + 1; i >= 0 && j < chess[0].length; i--, j++) {
            if (chess[i][j] == 1)
                return false;
        }
        return true;
    }
}
