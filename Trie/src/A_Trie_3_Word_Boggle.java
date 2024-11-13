import java.util.HashSet;
import java.util.Iterator;
// https://practice.geeksforgeeks.org/problems/word-boggle4143/1
// https://www.youtube.com/watch?v=h0kSTsLaZ-U&list=PL-Jc9J83PIiHgzR2UIDD7MI2ABIIZztON&index=3
public class A_Trie_3_Word_Boggle {
    public static class Node {
        Node[] children = new Node[58];
        String str;
    }

    public static void insert(Node curr, String s) {
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (curr.children[ch - 'A'] == null) {
                curr.children[ch - 'A'] = new Node();
            }
            curr = curr.children[ch - 'A'];
        }
        curr.str = s;
        return;
    }

    public String[] wordBoggle(char board[][], String[] words) {
        Node root = new Node();
        for (String str : words) {
            insert(root, str);
        }
        boolean[][] visited = new boolean[board.length][board[0].length];

        HashSet<String> ans = new HashSet<>();
        for (int i = 0; i < board.length; i++)
            for (int j = 0; j < board[0].length; j++)
                dfs(board, i, j, root, ans, visited);
        String[] a = new String[ans.size()];
        Iterator<String> it = ans.iterator();
        int i = 0;
        while (it.hasNext()) {
            a[i++] = it.next();
        }
        return a;
    }

    public static void dfs(char[][] board, int i, int j, Node root, HashSet<String> ans, boolean[][] visited) {
        if (i < 0 || j < 0 || i >= board.length || j >= board[0].length || visited[i][j]) {
            return;
        }
        if (root.children[board[i][j] - 'A'] == null)
            return;
        Node child = root.children[board[i][j] - 'A'];
        if (child.str != null) {
            ans.add(child.str);
            child.str = null;
        }
        visited[i][j] = true;
        dfs(board, i - 1, j - 1, child, ans, visited);

        dfs(board, i - 1, j, child, ans, visited);

        dfs(board, i - 1, j + 1, child, ans, visited);

        dfs(board, i, j + 1, child, ans, visited);

        dfs(board, i + 1, j + 1, child, ans, visited);

        dfs(board, i + 1, j, child, ans, visited);

        dfs(board, i + 1, j - 1, child, ans, visited);

        dfs(board, i, j - 1, child, ans, visited);

        visited[i][j] = false;
    }
}
