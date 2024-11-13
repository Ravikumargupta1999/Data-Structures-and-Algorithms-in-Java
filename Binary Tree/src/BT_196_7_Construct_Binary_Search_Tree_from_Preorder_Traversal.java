import java.util.ArrayList;

public class BT_196_7_Construct_Binary_Search_Tree_from_Preorder_Traversal {

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
        }
    }

    // https://leetcode.com/problems/construct-binary-search-tree-from-preorder-traversal/
    public TreeNode bstFromPreorder(int[] preorder) {
        return constructBST(preorder, 0, preorder.length - 1);
    }

    public TreeNode constructBST(int[] preOrder, int l, int r) {
        if (l > r)
            return null;
        else if (l == r)
            return new TreeNode(preOrder[l]);
        int index = -1;
        for (int i = l + 1; i <= r; i++) {
            if (preOrder[i] > preOrder[l]) {
                index = i;
                break;
            }
        }

        TreeNode root = new TreeNode(preOrder[l]);
        if (index == -1) {
            root.left = constructBST(preOrder, l + 1, r);
        } else {
            root.left = constructBST(preOrder, l + 1, index - 1);
            root.right = constructBST(preOrder, index, r);
        }
        return root;
    }
}
