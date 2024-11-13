package Day_20_Binary_Search_Tree;

public class Lowest_Common_Ancestor_of_a_Binary_Search_Tree {
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
        if(root == null)
            return null;
        if(p.val < root.val && q.val < root.val)
            return lowestCommonAncestor(root.left,p,q);
        else if(p.val > root.val && q.val > root.val)
            return lowestCommonAncestor(root.right,p,q);
        return root;

    }
}
