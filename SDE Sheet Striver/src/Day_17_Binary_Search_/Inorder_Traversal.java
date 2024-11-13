package Day_17_Binary_Search_;

import java.util.ArrayList;
import java.util.List;

public class Inorder_Traversal {
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

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> al = new ArrayList<>();
        Inorder(root, al);
        return al;
    }

    void Inorder(TreeNode root, List<Integer> al) {
        if (root == null)
            return;
        Inorder(root.left, al);
        al.add(root.val);
    }
}
