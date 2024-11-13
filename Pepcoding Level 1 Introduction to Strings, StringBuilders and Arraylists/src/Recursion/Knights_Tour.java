package Recursion;

public class Knights_Tour {
    static int total ;
    public static void main(String[] args) {
        int[][] chess = new int[5][5];
        total = 0;
        printKnightTour(chess, 0, 0, 1);
        System.out.println("Total Solution : "+total);
    }
    public static void printKnightTour(int[][] chess, int row, int col, int move) {
        if (row < 0 || col < 0 || row >= chess.length || col >= chess.length || chess[row][col] > 0) {
            return;
        } else if (move == chess.length * chess.length) {
            total++;
            chess[row][col] = move;
            displayBoard(chess);
            chess[row][col] = 0;
            return;
        }
        chess[row][col] = move;
        printKnightTour(chess, row - 2, col + 1, move + 1);
        printKnightTour(chess, row - 1, col + 2, move + 1);
        printKnightTour(chess, row + 1, col + 2, move + 1);
        printKnightTour(chess, row + 2, col + 1, move + 1);
        printKnightTour(chess, row + 2, col - 1, move + 1);
        printKnightTour(chess, row + 1, col - 2, move + 1);
        printKnightTour(chess, row - 1, col - 2, move + 1);
        printKnightTour(chess, row - 2, col - 1, move + 1);
        chess[row][col] = 0;
    }

    public static void displayBoard(int[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                System.out.print(board[i][j] + "  ");
            }
            System.out.println("\n");
        }
        System.out.println("\n\n\n");
    }
}
