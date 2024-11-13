import java.util.Arrays;

public class A_Trie_403_Shortest_Unique_prefix_for_every_word_GFG {
    static class TrieNode {
        TrieNode[] children;
        int count;

        public TrieNode() {
            count = 0;
            children = new TrieNode[26];
        }
    }


    public static void insert(TrieNode root, String str) {

        TrieNode curr = root;

        for (char ch : str.toCharArray()) {
            if (curr.children[ch - 'a'] == null)
                curr.children[ch - 'a'] = new TrieNode();
            curr.count++;
            curr = curr.children[ch - 'a'];
        }

    }

    public static String shortestUniquePrefix(TrieNode root, String str) {

        TrieNode curr = root;

        for (int i = 0; i < str.length(); i++) {

            char ch = str.charAt(i);

            curr = curr.children[ch - 'a'];

            if (curr.count == 1)
                return str.substring(0, i + 1);
        }
        return str;
    }

    public static String[] findPrefixes(String[] arr, int n) {

        TrieNode root = new TrieNode();

        for (String str : arr)
            insert(root, str);

        String[] res = new String[n];
        for (int i = 0; i < n; i++) {

            res[i] = shortestUniquePrefix(root, arr[i]);
        }
        System.out.println(Arrays.toString(res));
        return res;
    }

    public static void main(String[] args) {
        String[] arr =  {"geeksgeeks", "geeksquiz", "geeksforgeeks"};
        System.out.println(findPrefixes(arr,arr.length));
    }
}
