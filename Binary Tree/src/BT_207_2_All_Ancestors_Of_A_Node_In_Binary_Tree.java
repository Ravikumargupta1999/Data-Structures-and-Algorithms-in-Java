import java.util.ArrayList;
import java.util.Collections;

public class BT_207_2_All_Ancestors_Of_A_Node_In_Binary_Tree {
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

    // https://practice.geeksforgeeks.org/problems/ancestors-in-binary-tree/1

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
//                  /  \
//                 /    \
//                /      \
//               /        \
//              3         -1
//             / \       /   \
//            2   1     4     5
//                /    / \     \
//               1    1   2     6