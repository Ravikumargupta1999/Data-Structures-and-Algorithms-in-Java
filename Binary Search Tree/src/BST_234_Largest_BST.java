public class BST_234_Largest_BST {
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

    public static class BSTPair {
        boolean isBST;
        int min;
        int max;
        Node root;
        int size;
    }

    int largestBst(Node root) {
        BSTPair bp = isBST1(root);
        return bp.size;

    }

    BSTPair isBST1(Node root) {
        if (root == null) {
            BSTPair bp = new BSTPair();
            bp.min = Integer.MAX_VALUE;
            bp.max = Integer.MIN_VALUE;
            bp.isBST = true;
            bp.root = null;
            bp.size = 0;
            return bp;
        }

        BSTPair lp = isBST1(root.left);
        BSTPair rp = isBST1(root.right);

        BSTPair mp = new BSTPair();
        mp.isBST = lp.isBST && rp.isBST && (root.data > lp.max) && (root.data < rp.min);
        mp.min = Math.min(root.data, Math.min(lp.min, rp.min));
        mp.max = Math.max(root.data, Math.max(lp.max, rp.max));

        if (mp.isBST) {
            mp.root = root;
            mp.size = lp.size + rp.size + 1;
        } else if (lp.size > rp.size) {
            mp.root = lp.root;
            mp.size = lp.size;
        } else {
            mp.root = rp.root;
            mp.size = rp.size;

        }
        return mp;
    }
}
