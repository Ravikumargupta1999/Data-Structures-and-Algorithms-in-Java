import java.util.Arrays;

public class Backtracking_283_The_Knights_Tour_Problem_Single_Path {
    // https://www.geeksforgeeks.org/the-knights-tour-problem-backtracking-1/
    static int[][] moves = {{2, 1}, {1, 2}, {-1, 2}, {-2, 1}, {-2, -1}, {-1, -2}, {1, -2}, {2, -1}};

    public static void KnightWalk(int n) {
        int[][] sol = new int[n][n];
        for (int[] a : sol)
            Arrays.fill(a, -1);
        int[] xMove = {2, 1, -1, -2, -2, -1, 1, 2};
        int[] yMove = {1, 2, 2, 1, -1, -2, -2, -1};
        sol[0][0] = 1;
        if (!knightTour(sol, 0, 0, 2)) {
            System.out.println("No Solution Exist");
        } else
            printPaths(sol);

    }


    public static boolean knightTour(int[][] matrix, int x, int y, int pos) {
        if (pos == matrix.length * matrix.length + 1) {
            return true;
        }
        for (int i = 0; i < moves.length; i++) {
            int row = x + moves[i][0];
            int col = y + moves[i][1];
            if (isValid(matrix, row, col)) {
                matrix[row][col] = pos;
                if (knightTour(matrix, row, col, pos + 1))
                    return true;
                else
                    matrix[row][col] = -1;
            }
        }
        return false;
    }

    public static boolean isValid(int[][] matrix, int x, int y) {
        return (x >= 0 && x < matrix.length && y >= 0 && y < matrix.length && matrix[x][y] == -1);
    }

    public static void printPaths(int[][] matrix) {

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j] + "  ");
            }
            System.out.println("");
        }
        System.out.println("\n\n\n");
    }

    public static void main(String[] args) {
        KnightWalk(8);
    }
}
