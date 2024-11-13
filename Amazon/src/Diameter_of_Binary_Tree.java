public class Diameter_of_Binary_Tree {
    class Node {
        int data;
        Node left,right;

        Node(int d) {
            data = d;
            left = right = null;
        }
    }

    class DiaPair {
        int ht;
        int dia;
    }

    DiaPair diameter1(Node root) {
        if (root == null) {
            DiaPair bp = new DiaPair();
            bp.ht = 0;
            bp.dia = 0;
            return bp;
        }
        DiaPair lp = diameter1(root.left);
        DiaPair rp = diameter1(root.right);

        DiaPair mp = new DiaPair();
        mp.ht = Math.max(lp.ht, rp.ht) + 1;

        int fes = lp.ht + rp.ht + 1;
        mp.dia = Math.max(fes, Math.max(rp.dia, lp.dia));
        return mp;


    }

    int diameter(Node root) {
        DiaPair dp = diameter1(root);
        return dp.dia;
    }

    public static void main(String[] args) {

    }
}