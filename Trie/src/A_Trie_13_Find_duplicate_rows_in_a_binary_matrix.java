import java.util.ArrayList;

public class A_Trie_13_Find_duplicate_rows_in_a_binary_matrix {
    static class TrieNode {
        TrieNode[] children = new TrieNode[2];
        boolean isEnd;
    }

    public static ArrayList<Integer> repeatedRows(int matrix[][], int m, int n) {
        ArrayList<Integer> ans = new ArrayList<>();
        TrieNode node = new TrieNode();
        int i = 0;
        for (int[] mat : matrix) {
            TrieNode curr = node;
            for (int val : mat) {
                if (val == 0) {
                    if (curr.children[0] == null)
                        curr.children[0] = new TrieNode();
                    curr = curr.children[0];
                } else {
                    if (curr.children[1] == null)
                        curr.children[1] = new TrieNode();
                    curr = curr.children[1];
                }
            }
            if (curr.isEnd)
                ans.add(i);
            curr.isEnd = true;
            i++;
        }
        return ans;
    }

    public static void main(String[] args) {
        String s1 = "apple";
        String s2 = "apply";
        System.out.println(s1.compareTo(s2));
    }
}
