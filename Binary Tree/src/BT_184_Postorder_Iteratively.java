import java.util.ArrayList;
import java.util.Stack;

public class BT_184_Postorder_Iteratively {
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

    // https://practice.geeksforgeeks.org/problems/postorder-traversal-iterative/0/?fbclid=IwAR0hBdYqYX4QO4D0pil25OqEKVDYB6RCEY_ilup_-n5f5cffgv611Rl9HXY
    ArrayList<Integer> iterative_Postorder(Node root) {

        ArrayList<Integer> al = new ArrayList<>();
        if (root == null)
            return al;
        Stack<Node> st = new Stack<>();
        st.push(root);
        Stack<Node> out = new Stack<>();

        while (!st.isEmpty())
        {
            root = st.pop();
            out.push(root);
            if(root.left != null)
            {
                st.push(root.left);
            }
            if(root.right != null)
            {
                st.push(root.right);
            }

        }
        while (!out.isEmpty())
        {
            root = out.pop();
            al.add(root.data);
        }
        return al;
    }
}
