public class Searching_Sorting_112_House_Robber_III {
    // https://leetcode.com/problems/house-robber-iii/description/
    // https://practice.geeksforgeeks.org/problems/maximum-sum-of-non-adjacent-nodes/1
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

    public int rob(TreeNode root) {
        return getMaxSum(root);
    }
    static java.util.HashMap<TreeNode,Integer> dp  = new java.util.HashMap<>();
    static int getMaxSum(TreeNode root)
    {
        if(root == null)
            return 0;
        return func(root);
    }
    static int func(TreeNode root)
    {
        if(root  == null)
            return 0;
        if(dp.get(root) != null)
            return dp.get(root);
        int inc =  root.val;
        if(root.left != null)
        {
            inc+=func(root.left.left);
            inc+=func(root.left.right);
        }
        if(root.right != null)
        {
            inc+=func(root.right.left);
            inc+=func(root.right.right);
        }
        int exc = func(root.left) + func(root.right);
        dp.put(root,Math.max(inc,exc));
        return dp.get(root);

    }
}
