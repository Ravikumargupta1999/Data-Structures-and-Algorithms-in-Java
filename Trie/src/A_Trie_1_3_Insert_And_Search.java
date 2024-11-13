public class A_Trie_1_3_Insert_And_Search {
    static int ALPHABET_SIZE = 26;

    static class TrieNode {
        TrieNode[] children = new TrieNode[ALPHABET_SIZE];

        // isEndOfWord is true if the node represents
        // end of a word
        boolean isEndOfWord;

        TrieNode() {
            isEndOfWord = false;
            for (int i = 0; i < ALPHABET_SIZE; i++)
                children[i] = null;
        }
    }


    //Function to insert string into TRIE.
    static void insert(TrieNode root, String key) {

        TrieNode curr = root;

        for (char ch : key.toCharArray()) {

            if(curr.children[ch-'a'] == null)
                curr.children[ch-'a'] = new TrieNode();
            curr = curr.children[ch-'a'];
        }
        curr.isEndOfWord = true;
    }

    //Function to use TRIE data structure and search the given string.
    static boolean search(TrieNode root, String key) {

        TrieNode curr = root;

        for (char ch : key.toCharArray()) {

            if(curr.children[ch-'a'] == null)
                return false;
            curr = curr.children[ch-'a'];
        }

       return curr.isEndOfWord;

    }
}
