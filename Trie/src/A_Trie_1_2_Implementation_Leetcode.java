public class A_Trie_1_2_Implementation_Leetcode {

    public static void main(String[] args) {

        Trie object = new Trie();
        object.insert("ravi");
        object.insert("ris");
        object.insert("priyanka");
        System.out.println(object.startsWith("pri"));
    }

    static class Trie {

        private class Node {
            Node[] child;
            boolean isEnd;

            Node() {
                child = new Node[26];
            }
        }


        final private Node root;

        /**
         * Initialize your data structure here.
         */
        public Trie() {
            root = new Node();
        }


        /**
         * Inserts a word into the trie.
         */
        public void insert(String word) {
            Node curr = root;
            for (int i = 0; i < word.length(); i++) {
                char ch = word.charAt(i);
                if (curr.child[ch - 'a'] == null) {
                    curr.child[ch - 'a'] = new Node();
                }
                curr = curr.child[ch - 'a'];
            }
            curr.isEnd = true;
        }

        /**
         * Returns if the word is in the trie.
         */
        public boolean search(String word) {
            Node curr = root;
            for (int i = 0; i < word.length(); i++) {
                char ch = word.charAt(i);
                if (curr.child[ch - 'a'] == null)
                    return false;
                curr = curr.child[ch - 'a'];
            }
            return curr.isEnd;
        }

        /**
         * Returns if there is any word in the trie that starts with the given prefix.
         */
        public boolean startsWith(String word) {
            Node curr = root;
            for (int i = 0; i < word.length(); i++) {
                char ch = word.charAt(i);
                if (curr.child[ch - 'a'] == null)
                    return false;
                curr = curr.child[ch - 'a'];
            }
            return true;
        }

    }
}