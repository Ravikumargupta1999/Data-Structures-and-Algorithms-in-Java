public class AVL_Tree_Insertion {
    class Node {

        int data;
        Node left;
        Node right;
        int height;

        public Node(int data) {
            this.data = data;
            this.height = 1;
        }
    }

    private Node root;

    public void insert(int item) {
        this.root = insertToAVL(this.root, item);
    }

    public  Node insertToAVL(Node node,int item)
    {
        if (node == null) {
            Node nn = new Node(item);
            return nn;
        }

        if (item > node.data) {
            node.right = insertToAVL(node.right, item);
        } else if (item < node.data) {
            node.left = insertToAVL(node.left, item);
        }

        node.height = Math.max(height(node.left), height(node.right)) + 1;

        int bf = bf(node);

        // LL Case
        if (bf > 1 && item < node.left.data) {
            return rightRotate(node);
        }

        // RR Case
        if (bf < -1 && item > node.right.data) {
            return leftRotate(node);
        }

        // LR Case
        if (bf > 1 && item > node.left.data) {
            node.left = leftRotate(node.left);
            return rightRotate(node);
        }

        // RL Case
        if (bf < -1 && item < node.right.data) {
            node.right = rightRotate(node.right);
            return leftRotate(node);
        }
        return node;

    }

    int height(Node node) {
        if (node == null) {
            return 0;
        }

        return node.height;
    }

    int bf(Node node) {
        if (node == null) {
            return 0;
        }

        return height(node.left) - height(node.right);
    }

    Node rightRotate(Node c) {

        Node b = c.left;
        Node T3 = b.right;

        // rotate
        b.right = c;
        c.left = T3;

        // ht update
        c.height = Math.max(height(c.left), height(c.right)) + 1;
        b.height = Math.max(height(b.left), height(b.right)) + 1;

        return b;
    }

    Node leftRotate(Node c) {

        Node b = c.right;
        Node T2 = b.left;

        // rotate
        b.left = c;
        c.right = T2;

        // ht update
        c.height = Math.max(height(c.left), height(c.right)) + 1;
        b.height = Math.max(height(b.left), height(b.right)) + 1;

        return b;
    }

    public void display() {
        display(this.root);
    }

    private void display(Node node) {

        if (node == null) {
            return;
        }

        // self work
        String str = "";

        if (node.left == null) {
            str += ".";
        } else {
            str += node.left.data;
        }

        str += " => " + node.data + " <= ";

        if (node.right == null) {
            str += ".";
        } else {
            str += node.right.data;
        }

        System.out.println(str);

        display(node.left);
        display(node.right);

    }
}
