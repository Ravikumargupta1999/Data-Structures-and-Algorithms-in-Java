import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

// https://practice.geeksforgeeks.org/problems/huffman-encoding3345/1#
// https://www.youtube.com/watch?v=vt_Z6tdV81Q&t=7s
public class Greedy_240_Huffman_Coding {
    static class Node implements Comparable<Node> {
        char ch;
        int freq;
        Node right;
        Node left;

        Node(char ch, int freq) {
            this.ch = ch;
            this.freq = freq;
            this.right = null;
            this.left = null;
        }

        public int compareTo(Node other) {
            if (this.freq == other.freq) {
                return 1;
            }
            return this.freq - other.freq;
        }
    }

    static ArrayList<String> encoding;

    public void preorder(Node root, String str) {

        if (root == null)
            return;
        if (root.left == null && root.right == null) {
            encoding.add(str);
            return;
        }
        preorder(root.left, str + "0");
        preorder(root.right, str + "1");

    }


    public ArrayList<String> huffmanCodes(String S, int[] f, int N) {

        PriorityQueue<Node> q = new PriorityQueue<>();
        for (int i = 0; i < N; i++) {
            // these nodes will be leaf nodes
            q.add(new Node(S.charAt(i), f[i]));
        }

        while (q.size() > 1) {
            Node left = q.remove();
            Node right = q.remove();

            Node root = new Node('#', left.freq + right.freq);
            root.left = left;
            root.right = right;

            q.add(root);
        }
        Node root = q.remove();
        encoding = new ArrayList<>();
        preorder(root, "");

        return encoding;
    }


}
