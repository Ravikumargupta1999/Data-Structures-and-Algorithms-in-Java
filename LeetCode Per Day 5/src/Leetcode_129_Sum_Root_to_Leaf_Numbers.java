import java.util.ArrayList;

public class Leetcode_129_Sum_Root_to_Leaf_Numbers {
    // https://leetcode.com/problems/sum-root-to-leaf-numbers/submissions/
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

    public int sumNumbers(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(0);
        getSum(root, 0, list);
        return list.get(0);
    }

    public void getSum(TreeNode root, int sum, ArrayList<Integer> list) {
        if (root == null)
            return;
        sum = sum * 10 + root.val;
        if (root.left == null && root.right == null)
            list.set(0, list.get(0) + sum);

        if (root.left != null)
            getSum(root.left,sum,list);
        if(root.right != null)
            getSum(root.right,sum,list);
    }
}
