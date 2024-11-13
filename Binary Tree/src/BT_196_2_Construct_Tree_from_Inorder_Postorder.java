public class BT_196_2_Construct_Tree_from_Inorder_Postorder {
    //https://leetcode.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/
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
        return constructTree(postorder, 0, postorder.length - 1, inorder, 0, inorder.length - 1);
    }

    public TreeNode constructTree(int[] postorder, int psi, int pei, int[] inorder, int isi, int iei) {
        if (isi > iei)
            return null;

        TreeNode node = new TreeNode(postorder[pei]);
        int idx = isi;
        while (inorder[idx] != postorder[pei])
            idx++;
        int count = idx - isi;

        node.left = constructTree(postorder, psi, psi + count - 1, inorder, isi, idx - 1);
        node.right = constructTree(postorder, psi + count, pei - 1, inorder, idx + 1, iei);
        return node;
    }


    // https://practice.geeksforgeeks.org/problems/construct-tree-1/1#
    static class Node {
        int data;
        Node left, right;

        Node(int key) {
            data = key;
            left = right = null;
        }
    }

    // https://practice.geeksforgeeks.org/problems/tree-from-postorder-and-inorder/1
    Node buildTree(int in[], int post[], int n) {
        return constructTreeNode(post, 0, post.length - 1, in, 0, in.length - 1);
    }

    public Node constructTreeNode(int[] postorder, int psi, int pei, int[] inorder, int isi, int iei) {
        if (isi > iei)
            return null;

        Node node = new Node(postorder[pei]);
        int idx = isi;
        while (inorder[idx] != postorder[pei])
            idx++;
        int count = idx - isi;

        node.left = constructTreeNode(postorder, psi, psi + count - 1, inorder, isi, idx - 1);
        node.right = constructTreeNode(postorder, psi + count, pei - 1, inorder, idx + 1, iei);
        return node;
    }
}
