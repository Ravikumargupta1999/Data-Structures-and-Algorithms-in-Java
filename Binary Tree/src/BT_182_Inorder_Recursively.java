import java.util.HashMap;

public class BT_182_Inorder_Recursively {
    class Node {
        int data;
        Node left;
        Node right;

        public Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    public static void Inorder(Node root) {
        if (root == null)
            return;
        Inorder(root.left);
        System.out.print(root.data + "   ");
        Inorder(root.right);
    }

    public static void main(String[] args) {

    }
}
