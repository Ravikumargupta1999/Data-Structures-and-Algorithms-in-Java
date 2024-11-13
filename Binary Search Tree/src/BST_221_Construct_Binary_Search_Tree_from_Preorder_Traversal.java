import java.util.ArrayList;

public class BST_221_Construct_Binary_Search_Tree_from_Preorder_Traversal {
    class TreeNode {
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
    // [8,5,1,7,10,12]
    public TreeNode bstFromPreorder1(int[] preorder) {
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


//    https://practice.geeksforgeeks.org/problems/preorder-to-postorder4423/1


    static class Node {
        int data;
        Node left;
        Node right;

        public Node(int data) {
            this.data = data;
        }
    }

    public static Node post_order(int preorder[], int size) {
        return constructBST1(preorder, 0, preorder.length - 1);
    }

    public static Node constructBST1(int[] preOrder, int l, int r) {
        if (l > r)
            return null;
        else if (l == r)
            return new Node(preOrder[l]);
        int index = -1;
        for (int i = l + 1; i <= r; i++) {
            if (preOrder[i] > preOrder[l]) {
                index = i;
                break;
            }
        }

        Node root = new Node(preOrder[l]);
        if (index == -1) {
            root.left = constructBST1(preOrder, l + 1, r);
        } else {
            root.left = constructBST1(preOrder, l + 1, index - 1);
            root.right = constructBST1(preOrder, index, r);
        }
        return root;
    }
}
