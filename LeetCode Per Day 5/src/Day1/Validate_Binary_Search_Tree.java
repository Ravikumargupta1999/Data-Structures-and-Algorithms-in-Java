package Day1;

public class Validate_Binary_Search_Tree {
    // https://leetcode.com/problems/validate-binary-search-tree/submissions/
    public static class TreeNode {
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


    public boolean isValidBST(TreeNode root) {
        return checkBST(root,Long.MIN_VALUE,Long.MAX_VALUE);
    }
    public boolean checkBST(TreeNode node,long min,long max){
        if(node == null)
            return true;
        if(node.val <= min || node.val >= max)
            return false;
        return checkBST(node.left,min,node.val) && checkBST(node.right,node.val,max);
    }

//    public static void main(String[] args) {
//        TreeNode node = new TreeNode(5);
//        node.left = new TreeNode(1);
//        node.right = new TreeNode(4);
//        node.right.left = new TreeNode(3);
//        node.right.right = new TreeNode(6);
//        System.out.println(isValidBST(node));
//    }
}
