package Day3;

import java.util.ArrayList;
// https://leetcode.com/problems/path-sum/submissions/
public class Path_Sum {
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

    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }

        return getLeafNodeSum(root, 0, targetSum);

    }

    public boolean getLeafNodeSum(TreeNode root, int sum, int targetSum) {
        if (root == null)
            return false;
        if (root.left == null && root.right == null) {
            if (sum + root.val == targetSum) {
                return true;
            } else {
                return false;
            }
        }
        if (getLeafNodeSum(root.left, sum + root.val, targetSum))
            return true;
        return getLeafNodeSum(root.right, sum + root.val, targetSum);

    }
}
