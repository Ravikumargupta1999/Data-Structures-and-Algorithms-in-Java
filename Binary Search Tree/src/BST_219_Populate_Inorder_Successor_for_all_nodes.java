public class BST_219_Populate_Inorder_Successor_for_all_nodes {
    public static class Node {
        int data;
        Node left;
        Node right;
        Node next;

        public Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
            this.next = null;
        }
    }

    // GFg code
    Node prev = null;

    public void populateNext(Node root) {
        Inorder(root);
    }

    public void Inorder(Node root) {
        if (root == null)
            return;
        Inorder(root.left);
        if (prev != null) {
            prev.next = root;
        }
        prev = root;
        Inorder(root.right);
    }


}
