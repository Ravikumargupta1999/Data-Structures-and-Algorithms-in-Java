public class BT_198_Check_if_Binary_tree_is_Sum_tree_or_not {
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


    boolean isSumTree(Node root) {
        if (root == null)
            return true;
        else if (root.left == null && root.right == null)
            return true;

        int sum = solve(root.left) + solve(root.right);

        return sum == root.data && isSumTree(root.left) && isSumTree(root.right);
    }

    int solve(Node root) {
        if (root == null)
            return 0;
        else if (root.left == null && root.right == null)
            return root.data;
        return root.data + solve(root.left) + solve(root.right);
    }


}
