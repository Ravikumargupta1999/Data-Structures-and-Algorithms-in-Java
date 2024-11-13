import org.omg.Messaging.SYNC_WITH_TRANSPORT;

import java.util.HashSet;


public class Is_Sudoku_Valid {
    //https://practice.geeksforgeeks.org/problems/is-sudoku-valid4820/1/?company[]=Amazon&company[]=Amazon&difficulty[]=1&page=1&query=company[]Amazondifficulty[]1page1company[]Amazon#
    static int isValid(int board[][]) {
        HashSet<String> set = new HashSet<>();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if(board[i][j] != 0)
                {
                    int box = ((i/3)*3 + (j/3));
                    String str1 = "Col"+j+board[i][j];
                    String str2 = "Row"+i+board[i][j];
                    String str3 = "Box"+box+board[i][j];
                    if(set.contains(str1) || set.contains(str2) || set.contains(str3))
                        return 0;
                    else
                    {
                        set.add(str1);
                        set.add(str2);
                        set.add(str3);
                    }
                }
            }
        }
        return 1;
    }
    // https://leetcode.com/problems/valid-sudoku/submissions/
    public boolean isValidSudoku(char[][] board) {
        HashSet<String> set = new HashSet<>();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if(board[i][j] != '.')
                {
                    int box = ((i/3)*3 + (j/3));
                    String str1 = "Col"+j+board[i][j];
                    String str2 = "Row"+i+board[i][j];
                    String str3 = "Box"+box+board[i][j];
                    if(set.contains(str1) || set.contains(str2) || set.contains(str3))
                        return false;
                    else
                    {
                        set.add(str1);
                        set.add(str2);
                        set.add(str3);
                    }
                }
            }
        }
        return true;
    }




    public static void main(String[] args) {
        int mat[][] = {
                {3, 0, 6, 5, 0, 8, 4, 0, 0},
                {5, 2, 0, 0, 0, 0, 0, 0, 0},
                {0, 8, 7, 0, 0, 0, 0, 3, 1},
                {0, 0, 3, 0, 1, 0, 0, 8, 0},
                {9, 0, 0, 8, 6, 3, 0, 0, 5},
                {0, 5, 0, 0, 9, 0, 6, 0, 0},
                {1, 3, 0, 0, 0, 0, 2, 5, 0},
                {0, 0, 0, 0, 0, 0, 0, 7, 4},
                {0, 0, 5, 2, 0, 6, 3, 0, 0}

        };
        System.out.println(isValid(mat));

    }
}