import java.util.ArrayList;
// https://practice.geeksforgeeks.org/problems/phone-directory4628/1
public class A_Trie_406_Phone_directory {
    static class TrieNode {
        TrieNode[] children = new TrieNode[26];
        boolean isEnd;
        String string;
    }

    public static void insert(TrieNode node, String s) {
        TrieNode curr = node;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (curr.children[ch - 'a'] == null)
                curr.children[ch - 'a'] = new TrieNode();
            curr = curr.children[ch - 'a'];
        }
        curr.isEnd = true;
        curr.string = s;
    }

    static ArrayList<ArrayList<String>> displayContacts(int n, String[] contact, String s) {
        TrieNode root = new TrieNode();
        for (String con : contact)
            insert(root, con);
        ArrayList<ArrayList<String>> res = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            ArrayList<String> al = new ArrayList<>();
            TrieNode node = getNode(root, s.substring(0, i + 1));

            if (node == null) {
                al.add("0");
            } else {
                DFS(root, al);
            }

            res.add(al);
        }
        return res;
    }

    public static TrieNode getNode(TrieNode node, String str) {
//        System.out.println(str);
        TrieNode curr = node;
        for (int i = 0; i < str.length(); i++) {
            if (curr.children[str.charAt(i) - 'a'] == null)
                return null;
            curr = curr.children[str.charAt(i) - 'a'];
        }
        return curr;
    }

    public static void DFS(TrieNode curr, ArrayList<String> al) {
        if (curr.isEnd) {
            al.add(curr.string);
        }
        for (TrieNode node : curr.children) {
            if (node != null) {
                DFS(node, al);
            }
        }
    }

    public static void main(String[] args) {
        int n = 3;
        String[] contact = {"geeikistest", "geeksforgeeks", "geeksfortest"};
        String s = "geeips";
        System.out.println(displayContacts(n, contact, s));
    }
}
