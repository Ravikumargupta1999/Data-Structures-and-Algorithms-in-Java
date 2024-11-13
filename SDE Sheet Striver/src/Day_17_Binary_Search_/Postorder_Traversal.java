package Day_17_Binary_Search_;

import java.util.ArrayList;
import java.util.List;

public class Postorder_Traversal {
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

    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> al = new ArrayList<>();
        Preorder(root, al);
        return al;
    }

    void Preorder(TreeNode root, List<Integer> al) {
        if (root == null)
            return;

        Preorder(root.left, al);
        Preorder(root.right, al);

    }
}
