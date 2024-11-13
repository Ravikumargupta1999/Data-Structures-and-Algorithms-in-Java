public class Leetcode_235_Lowest_Common_Ancestor_of_a_Binary_Search_Tree {
    // https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree/submissions/
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

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode n1, TreeNode n2) {
        if (root == null)
            return root;
        if (n1.val < root.val && n2.val < root.val)
            return lowestCommonAncestor(root.left, n1, n2);
        else if (n1.val > root.val && n2.val > root.val)
            return lowestCommonAncestor(root.right, n1, n2);
        else
            return root;
    }
}
