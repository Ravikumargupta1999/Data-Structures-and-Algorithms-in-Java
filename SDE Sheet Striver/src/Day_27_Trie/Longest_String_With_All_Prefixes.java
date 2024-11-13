package Day_27_Trie;

import java.util.Arrays;

public class Longest_String_With_All_Prefixes {
    static class TrieNode {
        TrieNode[] child;
        boolean isEnd;


        TrieNode() {
            child = new TrieNode[26];
        }
    }

    public static class Trie {

        TrieNode root;

        public Trie() {
            root = new TrieNode();
        }

        public void insert(String word) {
            TrieNode curr = root;
            for (char ch : word.toCharArray()) {
                if (curr.child[ch - 'a'] == null)
                    curr.child[ch - 'a'] = new TrieNode();
                curr = curr.child[ch - 'a'];
            }
            curr.isEnd = true;
        }

        public boolean check(String word) {
            TrieNode curr = root;
            for (char ch : word.toCharArray()) {
                if (curr.child[ch - 'a'] == null || !curr.child[ch - 'a'].isEnd)
                    return false;
                curr = curr.child[ch - 'a'];
            }
            return curr.isEnd;
        }
    }

    public static String completeString(int n, String[] words) {
        Arrays.sort(words, (a, b) -> {
            for (int i = 0; i < Math.min(a.length(), b.length()); i++) {
                if (a.charAt(i) != b.charAt(i))
                    return a.charAt(i) - b.charAt(i);
            }
            return a.length() - b.length();
        });
        Trie obj = new Trie();
        for (String word : words)
            obj.insert(word);

        String str = "";

        for (String word : words) {
            if (obj.check(word)) {
                if (str.length() == 0 || word.length() > str.length())
                    str = word;
            }
        }
        return str.length() == 0 ? "None" : str;

    }
}
