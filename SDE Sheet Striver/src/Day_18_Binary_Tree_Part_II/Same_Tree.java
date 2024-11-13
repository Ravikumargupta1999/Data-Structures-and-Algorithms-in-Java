package Day_18_Binary_Tree_Part_II;

public class Same_Tree {
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
    // https://leetcode.com/problems/same-tree/submissions/
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p == null && q == null)
            return true;
        else if(p == null || q == null || p.val != q.val)
            return false;
        return isSameTree(p.left,q.left) && isSameTree(p.right,q.right);

    }
}
