package Day_20_Binary_Search_Tree;

public class Construct_Binary_Search_Tree_from_Preorder_Traversal {

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

    // https://leetcode.com/problems/construct-binary-search-tree-from-preorder-traversal/submissions/
    public TreeNode bstFromPreorder(int[] preorder) {
        return formBST(preorder, 0, preorder.length - 1);
    }

    public TreeNode formBST(int[] preOrder, int start, int end) {
        if (start > end)
            return null;
        if (start == end) {
            return new TreeNode(preOrder[start]);
        }

        TreeNode node = new TreeNode(preOrder[start]);


        int i = start+1;
        for (i = start + 1; i <= end; i++) {
            if(preOrder[i] > preOrder[start])
                break;
        }
        node.left = formBST(preOrder,start+1,i-1);
        node.right = formBST(preOrder,i,end);
        return node;
    }
}