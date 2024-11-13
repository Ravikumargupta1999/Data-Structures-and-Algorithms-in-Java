package Day_21_Binary_Search_Tree_Part_II;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Kth_Largest_Element_In_BST {
    class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
            left = null;
            right = null;
        }
    }

    public int kthLargest(Node root, int k) {
        k = size(root) - k + 1;

        int i = 1;
        Stack<Node> st = new Stack<Node>();
        while (!st.isEmpty() || root != null) {
            if (root != null) {
                st.push(root);
                root = root.left;
            } else {
                root = st.pop();
                if (i == k) {
                    return root.data;
                } else
                    i++;
                root = root.right;
            }
        }
        return -1;
    }

    public int size(Node node) {
        int size = 0;
        Queue<Node> queue = new LinkedList<>();
        queue.add(node);
        while (!queue.isEmpty()) {
            size++;
            Node temp = queue.poll();
            if (temp.left != null)
                queue.add(temp.left);
            if (temp.right != null)
                queue.add(temp.right);
        }
        return size;
    }
}
