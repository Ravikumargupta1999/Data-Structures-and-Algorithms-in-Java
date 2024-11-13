public class BST_232_BST_From_Preorder {

    //https://practice.geeksforgeeks.org/problems/preorder-to-postorder4423/1
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

    public static Node root;


    public BST_232_BST_From_Preorder() {
        root = null;
    }

    public static Node constructTree(int arr[], int size) {
        if (arr.length == 0)
            return null;

        Node root = null;

        for (int i = 0; i < arr.length; i++) {
            root = insert(root, arr[i]);
        }
        return root;
    }

    static Node insert(Node root, int data) {

        if (root == null) {
            root = new Node(data);
            return root;
        }

        if (data < root.data) {
            root.left = insert(root.left, data);
        } else if (data > root.data) {
            root.right = insert(root.right, data);
        }
        return root;
    }

    public static void main(String[] args) {
        System.out.println("");

    }
}
