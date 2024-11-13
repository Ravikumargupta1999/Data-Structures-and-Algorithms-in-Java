public class A_Trie_8_Count_of_Distinct_Substrings {
    static class Node {
        Node links[];
        boolean flag;

        public Node() {
            links = new Node[26];
            flag = false;
        }
    }

    public static int countDistinctSubstring(String s) {
        Node root = new Node();
        int n = s.length();
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            Node node = root;
            for (int j = i; j < n; j++) {
                if (node.links[s.charAt(j)-'a'] == null) {
                    node.links[s.charAt(j)-'a'] = new Node();
                    cnt++;
                }
                node = node.links[s.charAt(j)-'a'];
            }
        }
        return cnt + 1;
    }

    public static void main(String[] args) {
        String str = "ababa";
        System.out.println(countDistinctSubstring(str));
    }
}
