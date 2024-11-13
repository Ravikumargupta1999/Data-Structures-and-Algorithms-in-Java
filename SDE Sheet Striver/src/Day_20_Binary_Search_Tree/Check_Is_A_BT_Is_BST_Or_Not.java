package Day_20_Binary_Search_Tree;

import com.sun.source.tree.BreakTree;

public class Check_Is_A_BT_Is_BST_Or_Not {
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

    public boolean isValidBST(TreeNode root) {
        return validBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    public boolean validBST(TreeNode node, long min, long max) {
        if (node == null)
            return true;
        if (node.val <= min || node.val >= max)
            return false;
        return validBST(node.left, min, node.val) && validBST(node.right, node.val, max);
    }
}
