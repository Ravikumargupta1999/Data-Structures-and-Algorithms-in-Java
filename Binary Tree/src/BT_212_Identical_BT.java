public class BT_212_Identical_BT {
    static class Node {
        int data;
        Node left;
        Node right;

        public Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    boolean isIdentical(Node root1, Node root2) {
        if (root1 == null && root2 == null)
            return true;
        if (root1 == null || root2 == null)
            return false;
        if (root1.data != root2.data)
            return false;

        // a = Ya to dono ka tree1 ka left  tree2  ka left and tree1 ka right tree2 ke right equal hona chahiye
        //  b = ya phir dono ka left1 right2 and right1 && right2 euqal hone chahiye
        boolean a = isIdentical(root1.left, root2.left);
        boolean b = isIdentical(root1.right, root2.right);
        return a && b;
    }


}
