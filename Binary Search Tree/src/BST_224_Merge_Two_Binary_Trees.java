public class BST_224_Merge_Two_Binary_Trees {
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

    // https://leetcode.com/problems/merge-two-binary-trees/
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null)
            return null;
        TreeNode node;
        if (root1 != null && root2 != null) {
            node = new TreeNode(root1.val + root2.val);
            node.left = mergeTrees(root1.left, root2.left);
            node.right = mergeTrees(root1.right, root2.right);
        } else if (root1 != null) {
            node = new TreeNode(root1.val);
            node.left = mergeTrees(root1.left, null);
            node.right = mergeTrees(root1.right, null);
        } else {
            node = new TreeNode(root2.val);
            node.left = mergeTrees(null, root2.left);
            node.right = mergeTrees(null, root2.right);
        }
        return node;
    }
}
