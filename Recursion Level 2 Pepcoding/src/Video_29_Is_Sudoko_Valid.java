public class Video_29_Is_Sudoko_Valid {
    // https://practice.geeksforgeeks.org/problems/is-sudoku-valid4820/1/#
    static int isValid(int mat[][]){
        for (int i=0;i<mat.length;i++){
            for (int j=0;j<mat[0].length;j++){
                if(mat[i][j] != 0 ){
                    if(!isValid(mat,i,j,mat[i][j]))
                        return 0;
                }
            }
        }
        return 1;
    }
    public static boolean isValid(int[][] board, int row, int col, int ch) {
        // Row checking
        for (int i = 0; i < board[0].length; i++) {
            if( i == col)
                continue;
            if (board[row][i] == ch) {
                return false;
            }
        }

        // Col checking

        for (int i = 0; i < board.length; i++) {
            if(i == row)
                continue;
            if (board[i][col] == ch) {
                return false;
            }
        }

        // Check 3*3 box in that box itself
        int startRowPoint = 3 * (row / 3);
        int startColPoint = 3 * (col / 3);

        for (int i = 0; i < 3; i++) {

            for (int j = 0; j < 3; j++) {

                if(startRowPoint + i == row && startColPoint + j == col)
                    continue;
                if (board[startRowPoint + i][startColPoint + j] == ch) {
                    return false;
                }
            }
        }
        return true;
    }
}
