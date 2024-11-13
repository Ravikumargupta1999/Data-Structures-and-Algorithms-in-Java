import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BST_225_Kth_Largest_Element_In_BST {
    public static class Node {
        int data;
        Node left;
        Node right;

        public Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }

    }

    // https://practice.geeksforgeeks.org/problems/kth-largest-element-in-bst/1
    // Method - 1
    public int kthLargest(Node root, int k) {
        k = size(root) - k + 1;

        int i = 1;
        Stack<Node> st = new Stack<>();
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

    // Method - 2

    int ans;
    int count = 1;

    public int kthLargest1(Node root, int k) {
        ans = -1;
        solve(root, k);
        return ans;
    }

    void solve(Node root, int k) {
        if (root == null)
            return;
        solve(root.right, k);
        if (k == count) {
            ans = root.data;

            return;
        } else
            count++;
        solve(root.left, k);
    }

}
