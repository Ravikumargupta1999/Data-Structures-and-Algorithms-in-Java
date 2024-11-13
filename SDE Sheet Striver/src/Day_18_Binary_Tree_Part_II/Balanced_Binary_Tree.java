package Day_18_Binary_Tree_Part_II;

// https://leetcode.com/problems/balanced-binary-tree/submissions/
public class Balanced_Binary_Tree {
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

    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null)
            return 1;
        if (root.left != null && root.right != null) {
            return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
        } else if (root.left == null)
            return maxDepth(root.right) + 1;
        else
            return maxDepth(root.left) + 1;
    }

    public boolean isBalanced(TreeNode root) {
        if(root == null)
            return true;
        int lf = maxDepth(root.left);
        int rf = maxDepth(root.right);
        return (lf-rf >= -1 && lf-rf <= 1) &&  isBalanced(root.left)&&  isBalanced(root.right);
    }
}
