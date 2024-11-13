package Day_18_Binary_Tree_Part_II;

public class LCA_Of_Binary_Tree {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    // https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/submissions/
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null)
            return null;
        if (root == p || root == q)
            return root;
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right,p,q);
        if(left != null && right != null)
            return root;
        else if(left != null)
            return left;
        return right;
    }
}
