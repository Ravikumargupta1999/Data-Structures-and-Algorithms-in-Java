package Day_19_Binary_Tree_III;

public class Construct_Binary_Tree_From_Preorder_and_Inorder_Traversal {
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

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return formTree(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }

    public TreeNode formTree(int[] preOrder, int preLeft, int preRight, int[] inorder, int inLeft, int inRight) {
        if (preLeft == preRight) {
            return new TreeNode(preOrder[preLeft]);
        }
        if (preLeft > preRight)
            return null;

        TreeNode node = new TreeNode(preOrder[preLeft]);

        int index = -1;

        for (int i = inLeft; i <= inRight; i++) {
            if (inorder[i] == preOrder[preLeft]) {
                index = i;
                break;
            }
        }

        int leftSize = index - inLeft;

        node.left = formTree(preOrder,preLeft+1,preLeft+leftSize,inorder,inLeft,index-1);
        node.right = formTree(preOrder,preLeft+leftSize+1,preRight,inorder,inLeft+1,inRight);
        return node;

    }
}
