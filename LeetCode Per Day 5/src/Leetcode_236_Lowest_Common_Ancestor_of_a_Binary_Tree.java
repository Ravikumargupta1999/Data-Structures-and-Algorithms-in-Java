public class Leetcode_236_Lowest_Common_Ancestor_of_a_Binary_Tree {
    // https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/submissions/
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

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null)
            return null;
        if (root == p)
            return root;
        if (root == q)
            return root;
        TreeNode l = lowestCommonAncestor(root.left, p, q);
        TreeNode r = lowestCommonAncestor(root.right, p, q);
        if(l != null && r != null)
            return root;
        if(l != null)
            return l;
        return r;
    }
}
