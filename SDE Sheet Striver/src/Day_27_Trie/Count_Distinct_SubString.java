package Day_27_Trie;

public class Count_Distinct_SubString {

    static class TrieNode {
        TrieNode children[];
        boolean isEnd;

        TrieNode() {
            this.children = new TrieNode[26];
            this.isEnd = false;
        }
    }

    static TrieNode root = new TrieNode();

    static void insert(String str) {
        TrieNode cur = root;
        for (char ch : str.toCharArray()) {
            int idx = ch - 'a';

            if (cur.children[idx] == null)
                cur.children[idx] = new TrieNode();

            cur = cur.children[idx];
        }
        cur.isEnd = true;
    }

    public static int countDistinctSubstrings(String str) {
        int count = 1;
        for (int i = 0; i < str.length(); i++) {

            TrieNode curr = root;
            for (int j = i; j < str.length(); j++) {
                char ch = str.charAt(j);

                if (curr.children[ch - 'a'] == null) {
//                    System.out.print("if"+" ");
                    curr.children[ch - 'a'] = new TrieNode();
                    curr.isEnd = true;
                    count++;
                }
                curr = curr.children[ch - 'a'];
//                System.out.print(ch+" ");
            }
//            System.out.println("\n");
        }
        root = new TrieNode();
        return count;
    }

    public static void main(String[] args) {
        System.out.println(countDistinctSubstrings("sds"));
        System.out.println(countDistinctSubstrings("abc"));
        System.out.println(countDistinctSubstrings("aa"));
        System.out.println(countDistinctSubstrings("abab"));
    }
}
