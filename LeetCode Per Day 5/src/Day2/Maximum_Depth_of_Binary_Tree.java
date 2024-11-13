package Day2;

public class Maximum_Depth_of_Binary_Tree {
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

    //    https://leetcode.com/problems/maximum-depth-of-binary-tree/submissions/
    public int maxDepth(TreeNode root) {
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
        else if (right == -1)
            min = left;
        else
            min = Math.max(left, right);
        return min + 1;
    }

}
