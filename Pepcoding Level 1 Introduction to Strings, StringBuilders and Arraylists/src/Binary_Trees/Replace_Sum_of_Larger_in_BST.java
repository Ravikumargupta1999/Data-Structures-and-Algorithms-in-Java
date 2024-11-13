package Binary_Trees;

public class Replace_Sum_of_Larger_in_BST {
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

    // https://leetcode.com/problems/binary-search-tree-to-greater-sum-tree/submissions/
    int sum = 0;
    public TreeNode bstToGst(TreeNode root) {
        transForm(root);
        return root;
    }
    public void transForm(TreeNode node)
    {
        if(node == null)
            return;
        transForm(node.right);
        int temp = node.val;
        node.val = node.val + sum;
        sum =  temp + sum;
        transForm(node.left);
    }
}
