public class Expression_Tree {
    static class Node {
        String data;
        Node left, right;

        Node(String data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }

    }

    public static int evalTree(Node root) {
        if (root == null)
            return 0;
        if (root.left == null && root.right == null)
            return Integer.parseInt(root.data);
        int l_val = evalTree(root.left);
        int r_val = evalTree(root.right);
        if (root.data == "+")
            return l_val + r_val;
        if (root.data == "-")
            return l_val - r_val;
        else
            return l_val * r_val;

    }

    public static void main(String[] args) {
        Node root = new Node("+");
        root.left = new Node("*");
        root.right = new Node("-");
        root.left.left = new Node("5");
        root.left.right = new Node("4");
        root.right.left = new Node("100");
        root.right.right = new Node("20");
        System.out.println(evalTree(root));
    }
}
//
//                          +
//                      /       \
//                     *         -
//                    /  \     /   \
//                   5    4   100  20