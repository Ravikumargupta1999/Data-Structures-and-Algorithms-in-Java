package Day_19_Binary_Tree_III;

public class Construct_Binary_Tree_from_Inorder_and_Postorder_Traversal {
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

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return conStruct(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1);
    }

    public TreeNode conStruct(int[] inorder, int startIN, int endIn, int[] postorder, int startPo, int endPo) {
        if (startIN > endIn)
            return null;
        else if (startIN == endIn) {
            return new TreeNode(inorder[startIN]);
        }

        TreeNode root = new TreeNode(postorder[endPo]);

        int temp = postorder[endPo];
        int index = 0;
        int count = 0;
        for (int i = startIN; i <= endIn; i++) {
            if (inorder[i] == temp) {
                index = i;
                break;
            }
            count++;
        }
        root.left = conStruct(inorder, startIN, index - 1, postorder, startPo, startPo + count - 1);
        root.right = conStruct(inorder, index + 1, endIn, postorder, startPo + count, endPo - 1);
        return root;

    }
}
