public class A_Trie_2_1_Design_Add_and_Search_Words_Data_Structure {

    // https://leetcode.com/problems/design-add-and-search-words-data-structure/submissions/
    class WordDictionary {
        class Node {
            boolean isEnd;
            Node[] children;

            public Node() {
                isEnd = false;
                children = new Node[26];
            }


            public boolean find(String word, int index) {
                if (index == word.length()) {
                    return isEnd;
                }
                char ch = word.charAt(index);
                if (ch == '.') {
                    for (Node child : children) {
                        if (child == null)
                            continue;
                        if (child.find(word, index + 1))
                            return true;
                    }
                    return false;
                } else {
                    return children[ch - 'a'] != null && children[ch - 'a'].find(word, index + 1);
                }

            }
        }

        Node root;

        public WordDictionary() {
            root = new Node();
        }

        public void addWord(String word) {

            Node curr = root;

            for (char ch : word.toCharArray()) {
                if (curr.children[ch - 'a'] == null)
                    curr.children[ch - 'a'] = new Node();
                curr = curr.children[ch - 'a'];
            }
            curr.isEnd = true;
        }

        public boolean search(String word) {
            return root.find(word, 0);
        }
    }
}