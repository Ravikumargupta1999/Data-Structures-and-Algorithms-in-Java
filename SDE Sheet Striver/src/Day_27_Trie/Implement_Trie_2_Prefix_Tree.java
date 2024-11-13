package Day_27_Trie;

// https://www.codingninjas.com/codestudio/problems/implement-trie_1387095?topList=striver-sde-sheet-problems&utm_source=striver&utm_medium=website&leftPanelTab=1
public class Implement_Trie_2_Prefix_Tree {
    static class TrieNode {
        TrieNode[] child;
        int count;
        boolean isEnd;
        int word;

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
                curr.child[ch - 'a'].count++;
                curr = curr.child[ch - 'a'];
            }
            curr.isEnd = true;
            curr.word++;

        }

        public int countWordsEqualTo(String word) {
            TrieNode curr = root;

            for (char ch : word.toCharArray()) {
                if (curr.child[ch - 'a'] == null)
                    return 0;
                curr = curr.child[ch - 'a'];
            }

            return curr.word;
        }

        public int countWordsStartingWith(String word) {
            TrieNode curr = root;
            for (char ch : word.toCharArray()) {
                if (curr.child[ch - 'a'] == null)
                    return 0;
                curr = curr.child[ch - 'a'];
            }
            return curr.count;
        }

        public void erase(String word) {
            TrieNode curr = root;

            for (char ch : word.toCharArray()) {
                if (curr.child[ch - 'a'] == null)
                    curr.child[ch - 'a'] = new TrieNode();
                curr.child[ch - 'a'].count--;
                curr = curr.child[ch - 'a'];
            }
            curr.word--;
        }
    }


    public static void main(String[] args) {
        Trie obj = new Trie();
        obj.insert("coding");
        System.out.println(obj.countWordsEqualTo("coding"));
        obj.insert("coding");
        System.out.println(obj.countWordsEqualTo("coding"));
        obj.erase("coding");
        System.out.println(obj.countWordsEqualTo("coding"));
        System.out.println(obj.countWordsStartingWith("nin"));

    }
}
//    insert coding
//    insert ninja
//    countWordsEqualTo coding
//    countWordsStartingWith nin
//    erase coding