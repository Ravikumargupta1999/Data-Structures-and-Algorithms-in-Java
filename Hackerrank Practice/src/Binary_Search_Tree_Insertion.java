public class Binary_Search_Tree_Insertion {
    static class Node {

        int data;
        Node left;
        Node right;
        public Node(int data)
        {
            this.data = data;
        }
    }


    public static Node insert(Node root, int data) {
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

}
