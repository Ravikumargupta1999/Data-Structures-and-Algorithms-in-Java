public class BT_193_Construct_String_from_Binary_Tree {

    // https://leetcode.com/problems/construct-string-from-binary-tree/
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


    public String tree2str(TreeNode root) {
        if (root == null)
            return "";
        if (root.left == null && root.right == null)
            return root.val + "";
        String ans = root.val + "";
        if (root.left != null && root.right != null) {
            ans += "(" + tree2str(root.left) + ")(" + tree2str(root.right) + ")";
        } else if (root.left != null) {
            ans += "(" + tree2str(root.left) + ")";
        } else if (root.right != null) {
            ans += "()(" + tree2str(root.right) + ")";
        }
        return ans;

    }
}
