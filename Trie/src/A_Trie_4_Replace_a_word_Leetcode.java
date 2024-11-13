import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.StringTokenizer;
//https://leetcode.com/problems/replace-words/
//https://www.youtube.com/watch?v=yx0go-S4RXI&list=PL-Jc9J83PIiHgzR2UIDD7MI2ABIIZztON&index=4

public class A_Trie_4_Replace_a_word_Leetcode {
    // Brute Force
    // Accepted
    public String replaceWords1(List<String> dictionary, String sentence) {
        HashSet<String> dict = new HashSet<>();
        for (String str : dictionary)
            dict.add(str);
        String[] arr = sentence.split(" ");
        String[] ans = sentence.split("");
        for (int i = 0; i < arr.length; i++) {
            String str = arr[i];
            boolean found = false;
            for (int j = 0; j < str.length(); j++) {
                if (dict.contains(str.substring(0, j + 1))) {
                    ans[i] = str.substring(0, j + 1);
                    found = true;
                    break;
                }
            }
            if (!found)
                ans[i] = str;
        }
        String res = "";
        for (int i = 0; i < arr.length; i++) {
            res += ans[i] + " ";
        }
        return res.substring(0, res.length() - 1);
    }

    class Node {
        Node[] children = new Node[26];
        String str;
    }

    public void insert(Node root, String s) {
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (root.children[ch - 'a'] == null) {
                root.children[ch - 'a'] = new Node();
            }
            root = root.children[ch - 'a'];
        }
        root.str = s;
    }

    public String searchPrefix(Node root, String s) {
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (root.children[ch - 'a'] == null)
                return null;
            root = root.children[ch - 'a'];
            if (root.str != null)
                return root.str;
        }
        return null;
    }

    public String replaceWords(List<String> dictionary, String sentence) {
        Node root = new Node();
        for (String s : dictionary) {
            insert(root, s);
        }
        StringBuffer sb = new StringBuffer();
        String[] arr = sentence.split(" ");

        for (String word : arr) {

            String prefix = searchPrefix(root, word);
            if (prefix != null)
                sb.append(prefix);
            else
                sb.append(word);
            sb.append(" ");
        }
        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }


}
