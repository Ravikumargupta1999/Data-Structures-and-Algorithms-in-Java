public class BT_189_Longest_Zig_Zag_Leet_Code {
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

    static class Pair {
        int forward_slope = -1;
        int backward_slope = -1;
        int max_len = 0;
    }
    // https://leetcode.com/problems/longest-zigzag-path-in-a-binary-tree/
    // https://www.youtube.com/watch?v=7aqHhENUbkQ
    public static Pair longest_ZigzagPath(TreeNode root) {
        if (root == null)
            return new Pair();
        Pair left = longest_ZigzagPath(root.left);
        Pair right = longest_ZigzagPath(root.right);

        Pair myAns = new Pair();
        myAns.max_len = Math.max(Math.max(left.max_len, right.max_len), (Math.max(left.backward_slope, right.forward_slope) + 1));
        myAns.forward_slope = left.backward_slope + 1;
        myAns.backward_slope = right.forward_slope + 1;
        return myAns;
    }

    public int longestZigZag(TreeNode root) {
        Pair abc = longest_ZigzagPath(root);
        return abc.max_len;
    }
}

