public class Backtracking_283_The_Knights_tour_problem_All_Path {
    // https://www.techiedelight.com/print-possible-knights-tours-chessboard/
    static int count = 1;
    static int[][] moves = {{2, 1}, {1, 2}, {-1, 2}, {-2, 1}, {-2, -1}, {-1, -2}, {1, -2}, {2, -1}};

    public static void KnightWalk(int n) {
        int[][] matrix = new int[n][n];
        knightTour(matrix, 0, 0, 1);
    }

    public static void knightTour(int[][] matrix, int x, int y, int pos) {
        matrix[x][y] = pos;
        if (pos == matrix.length * matrix.length) {
            printPaths(matrix);
            matrix[x][y] = 0;
            return;
        }
        for (int i = 0; i < moves.length; i++) {
            int row = x + moves[i][0];
            int col = y + moves[i][1];
            if (isValid(matrix, row, col) && matrix[row][col] == 0)
                knightTour(matrix, row, col, pos + 1);
        }
        matrix[x][y] = 0;
    }

    public static boolean isValid(int[][] grid, int x, int y) {
        if (x < 0 || x >= grid.length || y < 0 || y >= grid[0].length)
            return false;
        return true;
    }

    public static void printPaths(int[][] matrix) {
        System.out.println("Solution : " + count + "");
        count++;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j] + "  ");
            }
            System.out.println("");
        }
        System.out.println("\n\n\n");
    }

    public static void main(String[] args) {
        KnightWalk(5);
    }
}
