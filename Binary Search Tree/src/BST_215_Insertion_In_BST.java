public class BST_215_Insertion_In_BST {
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

    //  https://practice.geeksforgeeks.org/problems/insert-a-node-in-a-bst/1/
    Node insert(Node root, int key) {

        if (!search(root, key))
            insertNode(root, key);
        return root;
    }

    public Node insertNode(Node root, int key) {
        if (root == null)
            return new Node(key);
        if (key < root.data)
            root.left = insertNode(root.left, key);
        else
            root.right = insertNode(root.right, key);
        return root;
    }

    boolean search(Node root, int x) {
        if (root == null)
            return false;
        if (root.data == x)
            return true;
        if (x < root.data)
            return search(root.left, x);
        return search(root.right, x);

    }
}
