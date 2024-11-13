public class Maximum_Difference_Between_Node_and_Ancestor {
// https://leetcode.com/problems/maximum-difference-between-node-and-ancestor/submissions/

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
    int difference = 0;
    public int maxAncestorDiff(TreeNode root) {
        helper(root);
        return difference;
    }
    public int[] helper(TreeNode root)
    {
        if(root == null)
            return new int[]{Integer.MAX_VALUE,Integer.MIN_VALUE};
        if(root.left == null && root.right == null)
            return new int[]{root.val,root.val};
        int[] left = helper(root.left);
        int[] right = helper(root.right);
        int min = Math.min(left[0],right[0]);
        int max = Math.max(left[1],right[1]);
        difference = Math.max(difference,Math.max(Math.abs(max-root.val),Math.abs(min-root.val)));
        min = Math.min(min,root.val);
        max = Math.max(max,root.val);
        return new int[]{min,max};
    }
}