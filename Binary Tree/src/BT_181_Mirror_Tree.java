public class BT_181_Mirror_Tree {
    // https://leetcode.com/problems/invert-binary-tree/submissions/
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

    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode mirror = new TreeNode(root.val);
        mirror.left = invertTree(root.right);
        mirror.right = invertTree(root.left);
        return mirror;
    }

    // // https://practice.geeksforgeeks.org/problems/mirror-tree/1
    class Node {
        int data;
        Node left;
        Node right;

        public Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    void mirror(Node node) {
        node = mirror1(node);
    }

    Node mirror1(Node node) {
        if (node == null)
            return null;
        Node left = mirror1(node.left);
        Node right = mirror1(node.right);
        node.left = right;
        node.right = left;
        return node;

    }
}
