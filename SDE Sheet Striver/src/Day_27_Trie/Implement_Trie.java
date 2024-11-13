package Day_27_Trie;

public class Implement_Trie {


    class Trie {
        private class TrieNode{
            TrieNode[] child;
            boolean isEnd;

            TrieNode() {
                child = new TrieNode[26];
            }
        }
        final private TrieNode root;

        public Trie() {
            root = new TrieNode();
        }

        public void insert(String word) {
            TrieNode curr = root;

            for (char ch : word.toCharArray()){
                if(curr.child[ch-'a'] == null)
                    curr.child[ch-'a'] = new TrieNode();
                curr = curr.child[ch-'a'];
            }
            curr.isEnd = true;
        }

        public boolean search(String word) {
            TrieNode curr = root;

            for (char ch : word.toCharArray()){
                if(curr.child[ch-'a'] == null)
                    return false;
                curr = curr.child[ch-'a'];
            }
            return curr.isEnd;
        }

        public boolean startsWith(String prefix) {
            TrieNode curr = root;

            for (char ch : prefix.toCharArray()){
                if(curr.child[ch-'a'] == null)
                    return false;
                curr = curr.child[ch-'a'];
            }
            return true;
        }
    }

}
