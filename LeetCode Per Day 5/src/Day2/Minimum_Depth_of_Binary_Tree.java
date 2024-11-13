package Day2;

import java.util.Map;

public class Minimum_Depth_of_Binary_Tree {
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

    // Important question
    public int minDepth(TreeNode root) {
        if (root == null)
            return 0;
        if (root.left == null && root.right == null)
            return 1;
        return minDepth1(root);
    }

    public int minDepth1(TreeNode root) {
        if (root == null)
            return -1;
        else if (root.left == null && root.right == null)
            return 1;
        int left = minDepth1(root.left);
        int right = minDepth1(root.right);
        int min;
        if (left == -1)
            min = right;
        else if(right == -1)
            min = left;
        else
            min = Math.min(left,right);
        return min + 1;
    }
}
