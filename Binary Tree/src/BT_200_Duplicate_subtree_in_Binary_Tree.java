//import jdk.internal.org.objectweb.asm.Handle;

import java.util.HashMap;

public class BT_200_Duplicate_subtree_in_Binary_Tree {
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

    // https://practice.geeksforgeeks.org/problems/duplicate-subtree-in-binary-tree/1
    HashMap<String, Integer> hm = new HashMap<>();

    String solve(Node root) {
        if (root == null)
            return "$";
        String s = "";
        if (root.right == null && root.left == null) {
            s = Integer.toString(root.data);
            return s;
        }
        s = s + Integer.toString(root.data);
        s = s + solve(root.left);
        s = s + solve(root.right);
        hm.put(s, hm.getOrDefault(s,0) + 1);
        return s;
    }

    int duplicate(Node root) {
        solve(root);
        for (int value : hm.values()) {
            if (value >= 2)
                return 1;
        }
        return 0;
    }

}
