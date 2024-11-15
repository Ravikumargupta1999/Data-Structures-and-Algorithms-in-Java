import java.util.ArrayList;
import java.util.List;

//https://leetcode.com/problems/word-search-ii/

public class A_Trie_3_2_Word_Search_II {
    public static class Node {
        Node[] childs = new Node[26];
        String str;
        int count = 0;
    }

    public static void insert(Node curr, String s) {
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (curr.childs[ch - 'a'] == null) {
                curr.childs[ch - 'a'] = new Node();
                curr.count++;
            }
            curr = curr.childs[ch - 'a'];
        }
        curr.str = s;

    }

    public static List<String> findWords(char[][] board, String[] words) {
        Node root = new Node();
        for (String str : words) {
            insert(root, str);
        }
        boolean[][] visited = new boolean[board.length][board[0].length];

        List<String> ans = new ArrayList<>();
        for (int i = 0; i < board.length; i++)
            for (int j = 0; j < board[0].length; j++)
                dfs(board, i, j, root, ans, visited);
        return ans;
    }

    public static void dfs(char[][] board, int i, int j, Node root, List<String> ans, boolean[][] visited) {
        if (i < 0 || j < 0 || i >= board.length || j >= board[0].length || visited[i][j] || root.count == 0) {
            return;
        }
        if (root.childs[board[i][j] - 'a'] == null)
            return;
        Node child = root.childs[board[i][j] - 'a'];
        if (child.str != null) {
            ans.add(child.str);
            child.str = null;
        }
        visited[i][j] = true;
        dfs(board, i + 1, j, child, ans, visited);
        dfs(board, i - 1, j, child, ans, visited);
        dfs(board, i, j + 1, child, ans, visited);
        dfs(board, i, j - 1, child, ans, visited);
        visited[i][j] = false;
        if (child.count == 0)
            root.count--;
    }

    public static void main(String[] args) {

    }
}
