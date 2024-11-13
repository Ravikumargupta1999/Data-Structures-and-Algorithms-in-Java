package Binary_Trees;

public class Delete_Node_in_a_BST {
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
    // https://leetcode.com/problems/delete-node-in-a-bst/submissions/
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null)
            return root;
        else if (key < root.val)
            root.left = deleteNode(root.left, key);
        else if (key > root.val)
            root.right = deleteNode(root.right, key);
        else {
            if (root.left == null && root.right == null) {
                root = null;
            } else if (root.left == null) {
                root = root.right;
            } else if (root.right == null) {
                root = root.left;
            } else {
                TreeNode temp = FindMin(root.right);
                root.val = temp.val;
                root.right = deleteNode(root.right, temp.val);
            }
        }
        return root;
    }

    public static TreeNode FindMin(TreeNode root) {
        if (root == null) {
            return root;
        } else if (root.left == null) {
            return root;
        } else
            return FindMin(root.left);

    }

}