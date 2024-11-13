public class BT_190_Balanced_Subtree {
    public class Node {
        int data;
        Node left;
        Node right;

        public Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    // https://practice.geeksforgeeks.org/problems/check-for-balanced-tree/1
    boolean isBalanced(Node root) {
        if (root == null)
            return true;
        int left_height = height(root.left);
        int right_height = height(root.right);

        if ((Math.abs(right_height - left_height) <= 1) && isBalanced(root.left) && isBalanced(root.right))
            return true;
        return false;
    }

    int height(Node root) {
        if (root == null)
            return 0;
        int leftHeight = height(root.left);
        int rightHeight = height(root.right);
        return Math.max(leftHeight, rightHeight) + 1;
    }
}