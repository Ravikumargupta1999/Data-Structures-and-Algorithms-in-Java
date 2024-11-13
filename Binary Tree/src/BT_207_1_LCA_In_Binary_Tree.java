public class BT_207_1_LCA_In_Binary_Tree {
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

    // https://www.youtube.com/watch?v=_-QHfMDde90
    // https://practice.geeksforgeeks.org/problems/lowest-common-ancestor-in-a-binary-tree/1
    Node lca(Node root, int n1, int n2) {
        if (root == null)
            return null;
        if (root.data == n1 || root.data == n2)
            return root;
        Node l = lca(root.left, n1, n2);
        Node r = lca(root.right, n1, n2);
        if (l != null && r != null)
            return root;
        if (l != null)
            return l;
        else
            return r;
    }
}
