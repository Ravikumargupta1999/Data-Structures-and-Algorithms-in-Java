import java.util.Arrays;

public class BT_196_4_Construct_Tree_from_Preorder_Postorder {
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
    // https://leetcode.com/problems/construct-binary-tree-from-preorder-and-postorder-traversal/submissions/
    public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
        return constructTree(preorder, 0, preorder.length - 1, postorder, 0, postorder.length - 1);
    }

    public TreeNode constructTree(int[] pre, int psi, int pei, int[] post, int posi, int poei) {
        if (psi > pei)
            return null;
        else if (psi == pei)
            return new TreeNode(pre[psi]);

        TreeNode node = new TreeNode(pre[psi]);
        int idx = posi;
        while (post[idx] != pre[psi + 1])
            idx++;
        int count = idx - posi + 1;

        node.left = constructTree(pre, psi + 1, psi + count, post, posi, idx);
        node.right = constructTree(pre, psi + count + 1, pei, post, idx + 1, poei - 1);
        return node;
    }


}
