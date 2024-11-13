package Day_19_Binary_Tree_III;

public class Binary_Tree_Maximum_Path_Sum {
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
    class Nodes {
        int maximum = Integer.MIN_VALUE;
        int straight = 0;
    }

    public int maxPathSum(TreeNode root) {

        Nodes p = getMaxSum(root);
        return Math.max(p.maximum, p.straight);
    }

    Nodes getMaxSum(TreeNode root) {
        if (root == null) {
            return new Nodes();
        }

        Nodes left = getMaxSum(root.left);
        Nodes right = getMaxSum(root.right);


        Nodes curr = new Nodes();

        curr.straight = Math.max(root.val, Math.max(left.straight, right.straight) + root.val);


        int a = Math.max(left.maximum, right.maximum);
        int b = Math.max(left.straight, right.straight) + root.val;
        int c = Math.max(left.straight + right.straight + root.val, root.val);

        curr.maximum = Math.max(a, Math.max(b, c));


        return curr;
    }
}
