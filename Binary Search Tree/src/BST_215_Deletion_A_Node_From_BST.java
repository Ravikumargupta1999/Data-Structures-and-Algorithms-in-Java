public class BST_215_Deletion_A_Node_From_BST {
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

    // https://practice.geeksforgeeks.org/problems/delete-a-node-from-bst/1
    // https://leetcode.com/problems/delete-node-in-a-bst/submissions/
    public static Node deleteNode(Node root, int data) {
        if (!search(root, data))
            return root;
        return delete(root, data);

    }

    public static Node delete(Node root, int data) {
        if (root == null)
            return null;
        if (data < root.data)
            root.left = deleteNode(root.left, data);
        else if (data > root.data)
            root.right = deleteNode(root.right, data);
        else {
            // leaf node
            if (root.left == null && root.right == null)
                return null;

                // // 1 children
            else if (root.left == null)
                root = root.right;
            else if (root.right == null)
                root = root.left;
            else {
                Node temp = findMin(root.right);
                root.data = temp.data;
                root.right = deleteNode(root.right, temp.data);
            }
        }
        return root;
    }

    public static Node findMin(Node root) {
        if (root == null) {
            return null;
        } else if (root.left == null) {
            return root;
        } else
            return findMin(root.left);
    }

    public static boolean search(Node root, int key) {
        if (root == null)
            return false;
        if (root.data == key)
            return true;
        if (key < root.data)
            return search(root.left, key);
        return search(root.right, key);
    }
}
