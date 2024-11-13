//import sun.awt.image.IntegerComponentRaster;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;

public class BT_209_Kth_Ancestor_Of_A_Node {
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
//    https://practice.geeksforgeeks.org/problems/kth-ancestor-in-a-tree/1/#
    public int kthAncestor(Node root, int k, int node) {
        ArrayList<Integer> list = Ancestors1(root, node);
        return k - 1 > list.size() - 1 ? -1 : list.get(k - 1);
    }

    public static ArrayList<Integer> Ancestors1(Node root, int target) {
        ArrayList<Integer> ans = new ArrayList<>();
        getAncestors(root, target, ans);
        Collections.reverse(ans);
        return ans;
    }

    public static boolean getAncestors(Node root, int target, ArrayList<Integer> arrayList) {
        if (root == null)
            return false;
        if (root.data == target)
            return true;
        arrayList.add(root.data);
        if (getAncestors(root.left, target, arrayList))
            return true;
        boolean val = getAncestors(root.right, target, arrayList);

        //remove from right side only if right side ancestor is not found
        if (!val)
            arrayList.remove(arrayList.size() - 1);
        return val;
    }
}
//    Root of below binary tree:
//                   1
//                  / \
//                 /   \
//                /     \
//               /       \
//              2         3
//             / \      /   \
//            4   5    6     7
//                /   / \     \
//               8   9  10    11
