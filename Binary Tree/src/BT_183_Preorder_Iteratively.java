import java.util.ArrayList;
import java.util.Stack;

public class BT_183_Preorder_Iteratively {
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
    // https://practice.geeksforgeeks.org/problems/preorder-traversal-iterative/0/
    ArrayList<Integer> iterative_Preorder(Node root)
    {

        ArrayList<Integer> al = new ArrayList<>();
        if (root == null)
            return al;
        Stack<Node> st = new Stack<>();
        st.push(root);
        while (!st.isEmpty())
        {
            root = st.pop();
            al.add(root.data);
            if(root.right != null)
            {
                st.push(root.right);
            }
            if(root.left != null)
            {
                st.push(root.left);
            }

        }
        return al;
    }
}
