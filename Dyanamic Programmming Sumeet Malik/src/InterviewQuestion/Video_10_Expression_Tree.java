package InterviewQuestion;

public class Video_10_Expression_Tree {
    // https://practice.geeksforgeeks.org/problems/expression-tree/1
    public static int evalTree(Node root) {
        if (root.left == null && root.right == null) {
            return Integer.parseInt(root.data);
        } else {
            int l_val = evalTree(root.left);
            int r_val = evalTree(root.right);
            if (root.data.equals("+")) {
                return l_val + r_val;
            } else if (root.data.equals("-")) {
                return l_val - r_val;
            } else if (root.data.equals("*")) {
                return l_val * r_val;
            } else
                return l_val / r_val;
        }
    }

    static class Node {
        String data;
        Node left;
        Node right;

        Node(String data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }
}
