import java.util.ArrayList;
import java.util.Stack;

public class BT_194_Binary_Tree_to_DLL {
    class Node {
        Node left, right;
        int data;

        Node(int d) {
            data = d;
            left = right = null;
        }
    }

    // https://practice.geeksforgeeks.org/problems/binary-tree-to-dll/1#
    // Approach 1
    // Inorder iteratively
    Node bToDLL(Node root) {
        if (root == null)
            return null;
        Node dummy = new Node(-1);
        Node temp = dummy;
        Stack<Node> st = new Stack<>();
        while (!st.isEmpty() || root != null) {
            if (root != null) {
                st.push(root);
                root = root.left;
            } else {
                root = st.pop();
                Node right = root.right;

                root.left = temp;
                temp.right = root;
                temp = root;


                root = right;
            }
        }
        temp.right = null;
        Node ans = dummy.right;
        dummy.right.left = null;
        return ans;
    }


    // Approach 2
    // Inorder Recursively
    int f = 0;
    Node head = null;
    Node prev = null;

    Node bToDLL1(Node root) {
        if (root == null)
            return null;
        solve(root);
        return head;
    }

    void solve(Node root) {
        if (root == null)
            return;
        solve(root.left);
        if (f == 0) {
            f = 1;
            prev = root;
            head = root;
        } else {
            prev.right = root;
            root.left = prev;
            prev = prev.right;
        }
        solve(root.right);
    }
}
