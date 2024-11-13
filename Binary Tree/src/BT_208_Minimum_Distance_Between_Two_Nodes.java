public class BT_208_Minimum_Distance_Between_Two_Nodes {
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

    int findDist(Node root, int a, int b) {
        if (root == null)
            return 0;
        Node lca = lca(root, a, b);
        int d1 = find_distance(lca, a, 0);
        int d2 = find_distance(lca, b, 0);
        return d1 + d2;
    }

    int find_distance(Node root, int n, int distance) {
        if (root == null)
            return -1;
        if (root.data == n)
            return distance;
        int left = find_distance(root.left, n, distance + 1);
        if (left != -1)
            return left;
        return find_distance(root.right, n, distance + 1);
    }


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
