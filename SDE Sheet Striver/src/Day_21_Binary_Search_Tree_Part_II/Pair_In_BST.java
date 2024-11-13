package Day_21_Binary_Search_Tree_Part_II;

import java.util.HashSet;
import java.util.Stack;

public class Pair_In_BST {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    // https://leetcode.com/problems/two-sum-iv-input-is-a-bst/submissions/
    public boolean findTarget(TreeNode root, int k) {

        HashSet<Integer> set = new HashSet<>();
        Stack<TreeNode> st = new Stack<>();
        while (!st.isEmpty() || root != null) {
            if (root != null) {
                st.push(root);
                root = root.left;
            } else {
                root = st.pop();
                if (set.contains(k - root.val))
                    return true;
                set.add(root.val);
                root = root.right;
            }
        }
        return false;
    }
}
