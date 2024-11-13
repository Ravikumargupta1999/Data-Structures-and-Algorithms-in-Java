import java.util.Arrays;
import java.util.HashSet;

public class A_Trie_11_Longest_Word_in_Dictionary {
    // brute force
    public String longestWord1(String[] words) {
        HashSet<String> set = new HashSet<>();
        Arrays.sort(words, (a, b) -> (b.length() - a.length()));
        for (String word : words)
            set.add(word);
        String ans = "";
        for (String word : words) {
            int i = 0;
            for (i = 0; i < word.length(); i++) {
                if (!set.contains(word.substring(0, i + 1)))
                    break;
            }
            if (i == word.length()) {
                if (word.length() < ans.length()) {
                    return ans;
                } else if (word.length() > ans.length()) {
                    ans = word;
                } else {
                    if (word.compareTo(ans) < 0) {
                        ans = word;
                    }
                }
            }
        }
        return ans;
    }

    // Trie Solution
    class Node {
        Node[] child = new Node[26];
        String str;
    }

    public void insert(Node curr, String s) {
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (curr.child[ch - 'a'] == null) {
                curr.child[ch - 'a'] = new Node();
            }
            curr = curr.child[ch - 'a'];
        }
        curr.str = s;
    }

    public void dfs(Node root) {
        for (Node child : root.child) {
            if (child != null && child.str != null) {
                if (child.str.length() > ans.length()) {
                    ans = child.str;
                }
                dfs(child);
            }
        }
    }

    String ans = "";

    public String longestWord(String[] words) {
        Node root = new Node();
        for (String s : words) {
            insert(root, s);
        }
        dfs(root);
        return ans;
    }
}
