public class Leetcode_99_Recover_Binary_Search_Tree {
    // https://leetcode.com/problems/recover-binary-search-tree/submissions/
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

    public void recoverTree(TreeNode root) {
        TreeNode curr = root;
        TreeNode a = null;
        TreeNode b = null;
        TreeNode prev = null;

        while (curr != null) {

            TreeNode leftNode = curr.left;

            if (leftNode == null) {

                if (prev != null && prev.val > curr.val) {
                    if (a == null)
                        a = prev;
                    b = curr;
                }
                prev = curr;

                curr = curr.right;
            } else {

                TreeNode rightMostNode = getRightMostNode(leftNode, curr);

                if (rightMostNode.right == null) {
                    // thread creation
                    rightMostNode.right = curr;
                    curr = curr.left;
                } else {
                    // break thread and process curr node
                    rightMostNode.right = null;
                    if (prev != null && prev.val > curr.val) {
                        if (a == null)
                            a = prev;
                        b = curr;
                    }
                    prev = curr;
                    curr = curr.right;
                }
            }
        }

        if (a != null) {
            int temp = a.val;
            a.val = b.val;
            b.val = temp;
        }
    }

    public TreeNode getRightMostNode(TreeNode leftNode, TreeNode curr) {
        while (leftNode.right != null && leftNode.right != curr)
            leftNode = leftNode.right;
        return leftNode;
    }
}
