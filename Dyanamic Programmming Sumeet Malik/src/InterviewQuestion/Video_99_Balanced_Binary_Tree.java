package InterviewQuestion;

public class Video_99_Balanced_Binary_Tree {
    // https://leetcode.com/problems/balanced-binary-tree/
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

    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        int val = height(root.left) - height(root.right);
        return val >= -1 && val <= 1 && isBalanced(root.left) && isBalanced(root.right);
    }

    int height(TreeNode node) {
        if (node == null) {
            return 0;
        }
        return Math.max(height(node.left), height(node.right)) + 1;
    }
}
