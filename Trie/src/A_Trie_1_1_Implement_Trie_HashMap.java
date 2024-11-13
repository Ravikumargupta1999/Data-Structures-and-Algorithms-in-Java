import java.util.HashMap;

public class A_Trie_1_1_Implement_Trie_HashMap {
    class Trie {

        class Node {

            HashMap<Character, Node> children;
            boolean isEnd;

            public Node() {
                children = new HashMap<>();
            }
        }

        Node root;

        public Trie() {
            root = new Node();
        }

        public void insert(String word) {

            Node curr = root;

            for (char ch : word.toCharArray()) {
                if (!curr.children.containsKey(ch)) {
                    curr.children.put(ch, new Node());
                }
                curr = curr.children.get(ch);
            }
            curr.isEnd = true;

        }

        public boolean search(String word) {
            Node curr = root;

            for (char ch : word.toCharArray()) {
                if (!curr.children.containsKey(ch)) {
                    return false;
                }
                curr = curr.children.get(ch);
            }
            return curr.isEnd ;
        }

        public boolean startsWith(String prefix) {
            Node curr = root;

            for (char ch : prefix.toCharArray()) {
                if (!curr.children.containsKey(ch)) {
                    return false;
                }
                curr = curr.children.get(ch);
            }
            return true;
        }
    }

}
