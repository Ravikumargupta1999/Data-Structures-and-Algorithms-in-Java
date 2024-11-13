import java.util.HashMap;

public class D_Dynamic_Programming_448_Largest_Independent_Set_Problem {

    // https://practice.geeksforgeeks.org/problems/largest-independent-set-problem/1?utm_source=gfg&utm_medium=article&utm_campaign=bottom_sticky_on_article
    // https://www.geeksforgeeks.org/largest-independent-set-problem-using-dynamic-programming/
    class Node {
        int data;
        Node left, right;

        public Node(int data) {
            this.data = data;
        }
    }



    public int LISS(Node node) {
        HashMap<Node, Integer> map = new HashMap<>();
        return liss(node, map);
    }


    static int liss(Node root, HashMap<Node, Integer> map) {
        if (root == null)
            return 0;
        if (map.containsKey(root))
            return map.get(root);
        if (root.left == null && root.right == null) {
            map.put(root, 1);
            return map.get(root);
        }

        int liss_excl = liss(root.left, map) + liss(root.right, map);

        int liss_incl = 1;
        if (root.left != null) {
            liss_incl += (liss(root.left.left, map) + liss(root.left.right, map));
        }
        if (root.right != null) {
            liss_incl += (liss(root.right.left, map) + liss(root.right.right, map));
        }

        map.put(root, Math.max(liss_excl, liss_incl));
        return map.get(root);
    }
}
