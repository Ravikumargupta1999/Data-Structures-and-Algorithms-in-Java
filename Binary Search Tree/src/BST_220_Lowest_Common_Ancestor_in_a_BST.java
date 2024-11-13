public class BST_220_Lowest_Common_Ancestor_in_a_BST {
    public static class Node {
        int data;
        Node left;
        Node right;

        public Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }

    }

    // https://practice.geeksforgeeks.org/problems/lowest-common-ancestor-in-a-bst/1
    public static Node LCA(Node root, int n1, int n2) {
        if (root == null)
            return null;
        if (n1 < root.data && n2 < root.data)
            return LCA(root.left, n1, n2);
        else if (n1 > root.data && n2 > root.data)
            return LCA(root.right, n1, n2);
        else
            return root;
    }

}
