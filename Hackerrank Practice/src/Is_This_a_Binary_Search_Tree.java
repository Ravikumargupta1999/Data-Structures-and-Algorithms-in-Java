//https://www.hackerrank.com/challenges/is-binary-search-tree/problem
public class Is_This_a_Binary_Search_Tree {
    class Node {
        int data;
        Node left;
        Node right;
    }

    class BSTPair {
        boolean isBST;
        int min;
        int max;
    }

    boolean checkBST(Node root) {
        if (root == null)
            return true;
        BSTPair bp = isBSt(root);
        return bp.isBST;
    }

    BSTPair isBSt(Node root) {
        if (root == null) {
            BSTPair bp = new BSTPair();
            bp.isBST = true;
            bp.min = Integer.MAX_VALUE;
            bp.max = Integer.MIN_VALUE;
            return bp;
        }
        BSTPair lp = isBSt(root.left);
        BSTPair rp = isBSt(root.right);

        BSTPair mp = new BSTPair();
        mp.isBST = lp.isBST && rp.isBST && (root.data >= lp.max && root.data <= rp.min);
        mp.min = Math.min(root.data, Math.min(lp.min, rp.min));
        mp.max = Math.max(root.data, Math.min(lp.max, rp.max));
        return mp;
    }
}
