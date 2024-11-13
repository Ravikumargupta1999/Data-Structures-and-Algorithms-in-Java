import java.util.ArrayList;
import java.util.Stack;

public class Sum_of_k_smallest_elements_in_BST {
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
    int sum(Node root, int k) {
        int sum = 0;
        if(root == null)
            return 0;
        int temp = 1;
        Stack<Node> st = new Stack<>();
        while (!st.isEmpty() || root != null) {
            if (root != null) {
                st.push(root);
                root = root.left;
            } else {
                root = st.pop();
                sum += (root.data);
                if(temp >= k)
                    return sum;
                temp++;
                root = root.right;
            }
        }

        return sum;

    }
}
