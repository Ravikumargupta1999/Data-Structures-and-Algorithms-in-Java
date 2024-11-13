import java.util.ArrayList;
import java.util.Stack;

public class BT_182_Inorder_Iteratively {
    class Node {
        int data;
        Node left;
        Node right;

        public Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    // https://www.techiedelight.com/inorder-tree-traversal-iterative-recursive/
    // https://practice.geeksforgeeks.org/problems/inorder-traversal-iterative/0/?fbclid=IwAR2_lL0T84DnciLyzMTQuVTMBOi82nTWNLuXjUgahnrtBgkphKiYk6xcyJU
    ArrayList<Integer> iterative_Inorder(Node root) {
        ArrayList<Integer> al = new ArrayList<>();
        Stack<Node> st = new Stack<>();
        while (!st.isEmpty() || root != null) {
            if (root != null) {
                st.push(root);
                root = root.left;
            } else {
                root = st.pop();
                al.add(root.data);
                root = root.right;
            }
        }
        return al;
    }
}
