import java.util.Arrays;
import java.util.HashMap;

public class A_Trie_403_Shortest_Unique_prefix_for_every_word {
    static class TrieNode {
        HashMap<Character, TrieNode> child;
        boolean isEnd;

        public TrieNode() {
            child = new HashMap<>();
            isEnd = false;
        }
    }

    static String[] findPrefixes(String[] arr, int N) {
        TrieNode node = new TrieNode();
        for (String st : arr) {
            TrieNode curr = node;
            for (char ch : st.toCharArray()) {
                if (!curr.child.containsKey(ch))
                    curr.child.put(ch, new TrieNode());
                curr = curr.child.get(ch);
            }
            curr.isEnd = true;
        }
//        System.out.print("Trie :  ");
//        printTrie(node, "");
//        System.out.println("\n");
        String[] ans = new String[N];
        int i = 0;
        for (String st : arr) {
            TrieNode curr = node;
            int index = -1;
            System.out.println(st);
            for (int j = 0; j < st.length(); j++) {
                char ch = st.charAt(j);
                curr = curr.child.get(ch);
                System.out.println(ch + "  " + curr.child.size());
                if ((curr.child.size() == 1 || curr.child.size() == 0) && index == -1) {
                    index = j;
                } else if (index != -1 && curr.child.size() > 1) {
                    index = -1;
                }
            }
            if (index != -1) {
                ans[i] = st.substring(0, index + 1);
            }
            i++;
            System.out.println("\n");
        }
        return ans;
    }

    public static void printTrie(TrieNode node, String ans) {
        if (node.child.size() == 0) {
            System.out.print(ans + "  ");
            return;
        }

        for (char ch : node.child.keySet()) {
            printTrie(node.child.get(ch), ans + ch);
        }

    }

    public static void main(String[] args) {
//        String[] arr = {"zebra", "dog", "duck", "dove"};
        String arr[] = {"geeksgeeks", "geeksquiz", "geeksforgeeks"};
        System.out.println(Arrays.toString(findPrefixes(arr, arr.length)));
    }
}
