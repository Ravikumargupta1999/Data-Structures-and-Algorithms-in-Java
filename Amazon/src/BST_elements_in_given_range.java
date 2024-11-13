import java.util.ArrayList;
import java.util.Stack;

public class BST_elements_in_given_range {
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
    public static ArrayList<Integer> printNearNodes(Node root, int low, int high) {
        ArrayList<Integer> al = iterative_Inorder(root);
        ArrayList<Integer> res = new ArrayList<>();
        for(int i=0;i<al.size();i++)
        {
            if(al.get(i)>=low && al.get(i) <= high )
                res.add(al.get(i));
        }
        return res;
    }
    static ArrayList<Integer> iterative_Inorder(Node root) {
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
