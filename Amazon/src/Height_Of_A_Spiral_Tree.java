public class Height_Of_A_Spiral_Tree {
    static class Node {
        int data;
        Node left, right;

        Node(int d) {
            data = d;
            left = right = null;
        }
    }

    // Return the height of the given special binary tree
    public static int findTreeHeight(Node root) {
        if (root == null)
            return 0;
        if (isLeaf(root))
            return 1;
        int leftheight = findTreeHeight(root.left);
        int rightheight = findTreeHeight(root.right);
        return Math.max(leftheight, rightheight) + 1;
    }

    static boolean isLeaf(Node node) {

        return (node.left != null && node.left.right == node && node.right != null && node.right.left == node);
    }
}
