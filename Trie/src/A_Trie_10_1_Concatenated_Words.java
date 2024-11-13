import java.util.*;

public class A_Trie_10_1_Concatenated_Words {
    // TLE
    public  class Node {
        Node[] childs = new Node[26];
        String str;
    }

    public  void insert(Node curr, String s) {
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (curr.childs[ch - 'a'] == null) {
                curr.childs[ch - 'a'] = new Node();
            }
            curr = curr.childs[ch - 'a'];
        }
        curr.str = s;
    }

    public  void search(Node curr, Node nWord) {
        if (curr.str != null && nWord.str != null) {
            ans.add(curr.str);
        }
        if (nWord.str != null) {
            search(curr, root);
        }
        for (int i = 0; i < 26; i++) {
            if (curr.childs[i] != null && nWord.childs[i] != null) {
                search(curr.childs[i], nWord.childs[i]);
            }
        }
    }

    public  void search1(Node curr) {
        if (curr.str != null) {
            search(curr, root);
        }
        for (Node child : curr.childs) {
            if (child != null) {
                search1(child);
            }
        }
    }

    Node root;
    HashSet<String> ans = new HashSet<>();
    public List<String> findAllConcatenatedWordsInADict(String[] words){
        root = new Node();
        for (String s : words) {
            if(s.length() == 0)
                continue;
            insert(root, s);
        }
        search1(root);
        List<String> al = new ArrayList<>(ans);
        return al;
    }

//    public static void main(String[] args) throws Exception {
//        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
//
//        int n = Integer.parseInt(read.readLine());
//
//        String[] words = new String[n];
//
//        for (int i = 0; i < n; i++) {
//            words[i] = read.readLine();
//        }
//
//        List<String> result = findAllConcatenatedWordsInADict(words);
//        Collections.sort(result);
//        PrintWriter out = new PrintWriter(System.out);
//        for (String s : result) {
//            out.println(s);
//        }
//        out.close();
//    }
}