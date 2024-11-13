package Weekly_Contest_311;

import java.sql.Array;
import java.util.Arrays;

public class Sum_of_Prefix_Scores_of_Strings {
    public static void main(String[] args) {
        String[] arr = {"abcd"};
        System.out.println(Arrays.toString(sumPrefixScores(arr)));
    }

    public static int[] sumPrefixScores(String[] words) {
        Trie obj = new Trie();
        for (String word : words)
            obj.insert(word);
        int[] res = new int[words.length];
        for (int i = 0; i < words.length; i++) {
            res[i] = obj.search(words[i]);
        }
        return res;
    }
}

class Trie {

    private class Node {
        Node[] child;
        boolean isEnd;
        int count = 0;
        ;

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
//        System.out.println(word);
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
//            System.out.println(ch);
            if (curr.child[ch - 'a'] == null) {
                curr.child[ch - 'a'] = new Node();
            }
//            System.out.println(ch-'a');
            curr = curr.child[ch - 'a'];
            curr.count++;
        }
        curr.isEnd = true;
//        System.out.println("\n");
    }

    /**
     * Returns if the word is in the trie.
     */
    public int search(String word) {

        int count = 0;
        Node curr = root;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            if (curr.child[ch - 'a'] == null)
                return count;
            count = count + curr.child[ch-'a'].count;
            curr = curr.child[ch - 'a'];
        }
        return count;
    }

}