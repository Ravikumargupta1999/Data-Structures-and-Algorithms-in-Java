import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class BT_210_Find_Duplicate_subtree_in_Binary_Tree {
    public class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
        }
    }

    // https://www.youtube.com/watch?v=yP0nNgj8x6o
    // https://practice.geeksforgeeks.org/problems/duplicate-subtrees/1
    public List<Node> findDuplicateSubtrees(Node root) {
        solve(root);
        return ans;
    }

    HashMap<String, Integer> hm = new HashMap<>();
    List<Node> ans = new ArrayList<>();

    String solve(Node root) {
        if (root == null)
            return "$";
        String s = "";
        s = Integer.toString(root.data) + " " +solve(root.left)+" "  + solve(root.right); // adding space is important
        hm.put(s, hm.getOrDefault(s, 0) + 1);
        if (hm.get(s) == 2)
            ans.add(root);
        return s;
    }
}
