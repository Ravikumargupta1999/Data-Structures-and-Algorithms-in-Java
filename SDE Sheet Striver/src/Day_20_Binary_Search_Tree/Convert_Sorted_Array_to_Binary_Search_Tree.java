package Day_20_Binary_Search_Tree;

public class Convert_Sorted_Array_to_Binary_Search_Tree {

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
    // https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree/submissions/
    public TreeNode sortedArrayToBST(int[] nums) {
        return formTree(nums, 0, nums.length - 1);
    }

    public TreeNode formTree(int[] arr, int start, int end) {
        if (start < end)
            return null;
        if (start == end)
            return new TreeNode(arr[start]);
        int mid = (start + end) >> 1;
        TreeNode node = new TreeNode(arr[mid]);
        node.left = formTree(arr, start,mid-1);
        node.right = formTree(arr,mid+1,end);
        return node;
    }
}
