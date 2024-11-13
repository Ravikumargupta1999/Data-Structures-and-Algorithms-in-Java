import java.util.HashMap;
import java.util.HashSet;

public class Backtracking_279_Valid_Sudoku {

    // https://leetcode.com/problems/valid-sudoku/submissions/
    // Solution 1
    public boolean isValidSudoku(char[][] board) {
        HashSet<String> set = new HashSet<>();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] != '.') {
                    String s1 = "Col" + j + board[i][j];
                    String s2 = "Row" + i + board[i][j];
                    int boxNo = ((i / 3) * 3 + (j / 3));
                    String s3 = "Box" + boxNo + board[i][j];
                    if (set.contains(s1) || set.contains(s2) || set.contains(s3))
                        return false;
                    else {
                        set.add(s1);
                        set.add(s2);
                        set.add(s3);
                    }
                }
            }
        }
        return true;
    }
//    https://practice.geeksforgeeks.org/problems/is-sudoku-valid4820/1/
    static int isValid1(int board[][]){
        HashSet<String> set = new HashSet<>();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] != 0 ) {
                    String s1 = "Col" + j + board[i][j];
                    String s2 = "Row" + i + board[i][j];
                    int boxNo = ((i / 3) * 3 + (j / 3));
                    String s3 = "Box" + boxNo + board[i][j];
                    if (set.contains(s1) || set.contains(s2) || set.contains(s3))
                        return 0;
                    else {
                        set.add(s1);
                        set.add(s2);
                        set.add(s3);
                    }
                }
            }
        }
        return 1;
    }
    // Solution 2
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
        // Same Box checking
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
