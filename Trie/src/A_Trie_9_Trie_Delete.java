import java.util.LinkedList;
// https://practice.geeksforgeeks.org/problems/trie-delete/1/?category[]=Trie&category[]=Trie&page=1&query=category[]Triepage1category[]Trie#
public class A_Trie_9_Trie_Delete {
    class TrieNode {
        char content;
        boolean isEnd;
        int count;
        LinkedList<TrieNode> childList;

        public TrieNode(char c) {
            childList = new LinkedList<>();
            isEnd = false;
            content = c;
            count = 0;
        }

        public TrieNode subNode(char c) {
            if (childList != null)
                for (TrieNode eachChild : childList)
                    if (eachChild.content == c)
                        return eachChild;
            return null;
        }
    }


    public static void deleteKey(TrieNode root, char[] key) {
        delete(root, key, 0);
    }
    static boolean delete(TrieNode current, char[] key, int index) {
        if (index == key.length) {
            if (!current.isEnd) {
                return false;
            }
            current.isEnd = false;
            return current.childList.size() == 0;
        }
        char ch = key[index];
        TrieNode node = current.subNode(ch);
        if (node == null) {
            return false;
        }
        boolean shouldDeleteCurrentNode = delete(node, key, index + 1);
        if (shouldDeleteCurrentNode) {
            current.childList.remove(node);
            return current.childList.size() == 0;
        }
        return false;
    }
}
