//https://practice.geeksforgeeks.org/problems/tic-tac-toe2412/1/?company[]=Amazon&company[]=Amazon&difficulty[]=1&page=10&query=company[]Amazondifficulty[]1page10company[]Amazon#

public class Tic_Tac_Toe {
    int win[][] = {{0, 1, 2}, // Check first row.
            {3, 4, 5}, // Check second Row
            {6, 7, 8}, // Check third Row
            {0, 3, 6}, // Check first column
            {1, 4, 7}, // Check second Column
            {2, 5, 8}, // Check third Column
            {0, 4, 8}, // Check first Diagonal
            {2, 4, 6}};

    boolean isValid(char[] board) {
        int xCount = 0, oCount = 0;
        for (int i = 0; i < 9; i++) {
            if (board[i] == 'X') {
                xCount++;
            }
            if (board[i] == 'O') {
                oCount++;
            }
        }
        if (xCount == oCount || xCount == oCount + 1) {
            if (isCWin(board, 'O')) {
                if (isCWin(board, 'X')) {
                    return false;
                }
                return (xCount == oCount);
            }
            if (isCWin(board, 'X') && xCount != oCount + 1) {
                return false;
            }
            return true;
        }
        return false;
    }

    boolean isCWin(char[] board, char c) {
        for (int i = 0; i < 8; i++) {
            if (board[win[i][0]] == c && board[win[i][1]] == c && board[win[i][2]] == c) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Tic_Tac_Toe a = new Tic_Tac_Toe();
        System.out.println(a.isValid(new char[]{'0', 'X', 'X', 'X', '0', 'X', '0', '0', 'X'}));
    }
}
