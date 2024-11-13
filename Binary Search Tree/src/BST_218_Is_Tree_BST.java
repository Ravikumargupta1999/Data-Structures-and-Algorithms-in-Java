public class BST_218_Is_Tree_BST {
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
    // Solution 1
    // https://www.youtube.com/watch?v=kMrbTnd5W9U
    public static class BSTPair
    {
        boolean isBST;
        int min;
        int max;
    }
    boolean isBST(Node root)
    {
        BSTPair bp = isBST1(root);
        return bp.isBST;

    }
    BSTPair isBST1(Node root)
    {
        if(root == null)
        {
            BSTPair bp = new BSTPair();
            bp.min = Integer.MAX_VALUE;
            bp.max = Integer.MIN_VALUE;
            bp.isBST = true;
            return bp;
        }

        BSTPair lp = isBST1(root.left);
        BSTPair rp = isBST1(root.right);

        BSTPair mp = new BSTPair();
        mp.isBST = lp.isBST && rp.isBST &&(root.data>lp.max) &&(root.data<rp.min);
        mp.min = Math.min(root.data,Math.min(lp.min,rp.min));
        mp.max = Math.max(root.data,Math.max(lp.max,rp.max));
        return mp;
    }

    // https://www.youtube.com/watch?v=f-sj7I5oXEI
    // https://practice.geeksforgeeks.org/problems/check-for-bst/1
    boolean isBST2(Node root) {
        return checkBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    boolean checkBST(Node root, int min, int max) {
        if (root == null)
            return true;
        if (root.data >= max || root.data <= min)
            return false;
        return checkBST(root.left, min, root.data) && checkBST(root.right, root.data, max);
    }


}
