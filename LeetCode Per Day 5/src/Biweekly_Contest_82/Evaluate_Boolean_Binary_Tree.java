package Biweekly_Contest_82;

public class Evaluate_Boolean_Binary_Tree {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public boolean evaluateTree(TreeNode root) {
        if(root == null)
            return true;
        if(root.left == null && root.right == null)
            return root.val == 1 ? true : false;
        if(root.val == 2)
            return evaluateTree(root.left) || evaluateTree(root.right);
        return evaluateTree(root.left) && evaluateTree(root.right);
    }
}
