public class BT_180_Diameter_Of_Binary_Tree {
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


    // https://www.youtube.com/watch?v=S0Bwgtn32uI
    int diameter(Node root) {
        if (root == null)
            return 0;
        int ld = diameter(root.left);
        int rd = diameter(root.right);
        int f = height(root.left) + height(root.right) + 1;
        return Math.max(f, Math.max(ld, rd));
    }
    int height(Node root) {
        if (root == null)
            return 0;
        int left_height = height(root.left);
        int right_height = height(root.right);
        return Math.max(left_height, right_height) + 1;
    }



    // Method - 2
    // https://www.youtube.com/watch?v=S0Bwgtn32uI
    class DiaPair {
        int ht;
        int dia;
    }
    int diameter12(Node root) {
        DiaPair dp = diameter13(root);
        return dp.dia;
    }
    DiaPair diameter13(Node root) {
        if (root == null) {
            DiaPair bp = new DiaPair();
            bp.ht = 0;
            bp.dia = 0;
            return bp;
        }
        DiaPair lp = diameter13(root.left);
        DiaPair rp = diameter13(root.right);

        DiaPair mp = new DiaPair();
        mp.ht = Math.max(lp.ht, rp.ht) + 1;

        int fes = lp.ht + rp.ht + 1;
        mp.dia = Math.max(fes, Math.max(rp.dia, lp.dia));
        return mp;

    }


}
