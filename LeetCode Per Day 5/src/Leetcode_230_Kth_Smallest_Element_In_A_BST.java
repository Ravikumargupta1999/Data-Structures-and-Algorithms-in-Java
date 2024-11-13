import java.util.ArrayList;

public class Leetcode_230_Kth_Smallest_Element_In_A_BST {
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
    //https://leetcode.com/problems/kth-smallest-element-in-a-bst/
    public int kthSmallest(TreeNode root, int k) {
        TreeNode curr = root;

        while (curr != null) {

            TreeNode leftNode = curr.left;

            if (leftNode == null) {
                k--;
                if(k == 0)
                    return curr.val;
                curr = curr.right;
            } else {
                TreeNode rightMostNode = getRightMostNode(leftNode, curr);

                if (rightMostNode.right == null) {  // create thread
                    rightMostNode.right = curr;
                    curr = curr.left;
                } else {  // print and break thread
                    rightMostNode.right = null;
                    k--;
                    if(k == 0)
                        return curr.val;
                    curr = curr.right;
                }
            }
        }
        return -1;
    }

    public TreeNode getRightMostNode(TreeNode leftNode, TreeNode curr) {

        while (leftNode.right != null && leftNode.right != curr)
            leftNode = leftNode.right;
        return leftNode;
    }
}
