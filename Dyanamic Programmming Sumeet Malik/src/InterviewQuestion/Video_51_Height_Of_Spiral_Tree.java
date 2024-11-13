package InterviewQuestion;

public class Video_51_Height_Of_Spiral_Tree {
    // https://practice.geeksforgeeks.org/problems/height-of-spiral-tree/1
    static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
            left = right = null;
        }
    }

    public static int findTreeHeight(Node root) {
        if (root == null)
            return 0;
        if (isLeaf(root))
            return 1;
        return 1 + Math.max(findTreeHeight(root.left), findTreeHeight(root.right));
    }

    public static boolean isLeaf(Node node) {
        return (node.left != null && node.left.right == node && node.right != null && node.right.left == node);
    }
}
