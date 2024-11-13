//https://practice.geeksforgeeks.org/problems/replace-os-with-xs0052/1#
//https://leetcode.com/problems/surrounded-regions/submissions/
//https://www.youtube.com/watch?v=0ZJViJEdtEc
public class Practice_14_Surrounded_Regions {
    boolean seen = false;

    public void solve(char[][] board) {
        int r = board.length;
        int c = board[0].length;
        if (r <= 1 || c <= 1)
            return;
        boolean[][] visited = new boolean[r][c];

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (board[i][j] == 'O' && !visited[i][j]) {
                    seen = false;
                    dfs(board, i, j, r, c, visited);
                    if (seen == false) {
                        mark(board, i, j, r, c);
                    }

                }

            }
        }
    }

    void dfs(char[][] board, int i, int j, int r, int c, boolean[][] visited) {
        if (i < 0 || i > r - 1 || j < 0 || j > c - 1) {
            return;
        }
        if (board[i][j] == 'X' || visited[i][j])
            return;
        if (i <= 0 || i >= r - 1 || j <= 0 || j >= c - 1)
            seen = true;

        visited[i][j] = true;
        dfs(board, i - 1, j, r, c, visited);
        dfs(board, i + 1, j, r, c, visited);
        dfs(board, i, j - 1, r, c, visited);
        dfs(board, i, j + 1, r, c, visited);
    }

    void mark(char[][] board, int i, int j, int r, int c) {
        if (i < 0 || i > r - 1 || j < 0 || j > c - 1)
            return;
        if (board[i][j] == 'X')
            return;
        board[i][j] = 'X';
        mark(board, i - 1, j, r, c);
        mark(board, i + 1, j, r, c);
        mark(board, i, j - 1, r, c);
        mark(board, i, j + 1, r, c);
    }

}

//https://practice.geeksforgeeks.org/problems/replace-os-with-xs0052/1#
class Solution {
    static boolean seen = false;

    static char[][] fill(int n, int m, char board[][]) {
        int r = board.length;
        int c = board[0].length;
        if (r <= 1 || c <= 1)
            return board;
        boolean[][] visited = new boolean[r][c];
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (board[i][j] == 'O' && !visited[i][j]) {
                    seen = false;
                    dfs(board, i, j, r, c, visited);
                    if (seen == false) {
                        mark(board, i, j, r, c);
                    }
                    seen = true;
                }

            }
        }
        return board;
    }

    static void dfs(char[][] board, int i, int j, int r, int c, boolean[][] visited) {
        if (i < 0 || i > r - 1 || j < 0 || j > c - 1) {
            return;
        }
        if (board[i][j] == 'X' || visited[i][j])
            return;
        if (i <= 0 || i >= r - 1 || j <= 0 || j >= c - 1)
            seen = true;

        visited[i][j] = true;
        dfs(board, i - 1, j, r, c, visited);
        dfs(board, i + 1, j, r, c, visited);
        dfs(board, i, j - 1, r, c, visited);
        dfs(board, i, j + 1, r, c, visited);
    }

    static void mark(char[][] board, int i, int j, int r, int c) {
        if (i < 0 || i > r - 1 || j < 0 || j > c - 1)
            return;
        if (board[i][j] == 'X')
            return;
        board[i][j] = 'X';
        mark(board, i - 1, j, r, c);
        mark(board, i + 1, j, r, c);
        mark(board, i, j - 1, r, c);
        mark(board, i, j + 1, r, c);
    }
}
