package Binary_Trees;

import org.w3c.dom.Node;

public class Construct_Sorted_Array_To_BST {
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
    // https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree/

    public TreeNode sortedArrayToBST(int[] nums) {
        return constructTree(nums, 0, nums.length - 1);
    }

    public TreeNode constructTree(int[] arr, int lo, int hi) {
        if (lo > hi)
            return null;
        int mid = (lo + hi) / 2;
        TreeNode lc = constructTree(arr, lo, mid - 1);
        TreeNode rc = constructTree(arr, mid + 1, hi);
        TreeNode node = new TreeNode(arr[mid]);
        node.left = lc;
        node.right = rc;
        return node;
    }

}
