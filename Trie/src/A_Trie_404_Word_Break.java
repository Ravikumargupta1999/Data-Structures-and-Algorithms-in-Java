import java.util.ArrayList;
import java.util.Scanner;

// https://practice.geeksforgeeks.org/problems/d857113143f69fab217cf5dab978535542f3cbb1/0/
public class A_Trie_404_Word_Break {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n;
            n = sc.nextInt();
            ArrayList<String> arr = new ArrayList<String>();
            for (int i = 0; i < n; i++) {
                String p = sc.next();
                arr.add(p);
            }
            String line = sc.next();
            Solution1 obj = new Solution1();
            System.out.println(obj.wordBreak(line, arr));

        }
    }

    static class Solution1 {
        public final int ALPHABET_SIZE = 26;

        public class TrieNode {
            TrieNode[] children = new TrieNode[ALPHABET_SIZE];
            boolean isEndOfWord;

            TrieNode() {
                isEndOfWord = false;
                for (int i = 0; i < ALPHABET_SIZE; i++)
                    children[i] = null;
            }
        }

        public void insert(TrieNode root, String word) {
            TrieNode curr = root;
            for (int i = 0; i < word.length(); i++) {
                char ch = word.charAt(i);
                if (curr.children[ch - 'a'] == null) {
                    curr.children[ch - 'a'] = new TrieNode();
                }
                curr = curr.children[ch - 'a'];
            }
            curr.isEndOfWord = true;
        }

        public boolean search(TrieNode root, String word) {
            TrieNode curr = root;
            for (int i = 0; i < word.length(); i++) {
                char ch = word.charAt(i);
                if (curr.children[ch - 'a'] == null)
                    return false;
                curr = curr.children[ch - 'a'];
            }
            return curr.isEndOfWord;
        }

        public  int wordBreak(String A, ArrayList<String> keys) {
            TrieNode root = new TrieNode();
            for (int i = 0; i < keys.size(); i++) {
                insert(root, keys.get(i));
            }
            boolean value = wordBreak1(A, root);
            if (value)
                return 1;
            else
                return 0;
        }

        public  boolean wordBreak1(String str, TrieNode root) {
            int size = str.length();
            if (size == 0)
                return true;

            for (int i = 1; i <= size; i++) {
                if (search(root, str.substring(0, i)) && wordBreak1(str.substring(i, size), root))
                    return true;
            }
            return false;
        }
    }
}