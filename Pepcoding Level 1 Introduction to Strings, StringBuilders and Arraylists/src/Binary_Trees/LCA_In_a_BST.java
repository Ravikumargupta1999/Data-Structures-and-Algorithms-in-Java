package Binary_Trees;

public class LCA_In_a_BST {
    class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
        }
    }
    // https://practice.geeksforgeeks.org/problems/lowest-common-ancestor-in-a-bst/1#
    Node LCA(Node root, int n1, int n2) {
        if (root == null)
            return null;
        if (n1 < root.data && n2 < root.data)
            return LCA(root.left, n1, n2);
        else if (n1 > root.data && n2 > root.data)
            return LCA(root.right, n1, n2);
        return root;
    }

}
