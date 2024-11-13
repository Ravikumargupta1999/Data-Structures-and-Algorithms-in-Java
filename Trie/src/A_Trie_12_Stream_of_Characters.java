
// https://leetcode.com/problems/stream-of-characters/submissions/
// https://www.youtube.com/watch?v=zlp-dKw77YE&list=PL-Jc9J83PIiHgzR2UIDD7MI2ABIIZztON&index=10
public class A_Trie_12_Stream_of_Characters {
    class TrieNode {
        boolean isEnd;
        TrieNode[] children;

        public TrieNode() {
            isEnd = false;
            children = new TrieNode[26];
        }
    }

    class StreamChecker {


        StringBuilder sb = new StringBuilder();

        TrieNode root;

        public StreamChecker(String[] words) {

            root = new TrieNode();


            for (String word : words) {

                TrieNode curr = root;
                for (int i= word.length()-1;i>=0;i--) {
                    char ch = word.charAt(i);
                    if (curr.children[ch - 'a'] == null)
                        curr.children[ch - 'a'] = new TrieNode();
                    curr = curr.children[ch - 'a'];
                }
                curr.isEnd = true;
            }
        }

        public boolean query(char letter) {

            sb.append(letter);


            TrieNode curr = root;
            for (int i = sb.length() - 1; i >= 0; i--) {

                char ch = sb.charAt(i);
                if(curr.children[ch-'a'] == null)
                    return false;

                curr = curr.children[ch-'a'];
                if(curr.isEnd)
                    return true;

            }
            return false;
        }
    }
}
