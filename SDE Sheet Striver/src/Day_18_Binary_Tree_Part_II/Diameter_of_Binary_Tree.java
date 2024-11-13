package Day_18_Binary_Tree_Part_II;

public class Diameter_of_Binary_Tree {
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

    class Diameter {
        int height;
        int diameter;
    }

    public int diameterOfBinaryTree(TreeNode root) {
        return getDiameter(root).diameter;
    }

    public Diameter getDiameter(TreeNode root) {
        if (root == null) {
            Diameter dia = new Diameter();
            dia.height = 0;
            dia.diameter = -1;
            return dia;
        }

        Diameter dp = new Diameter();

        Diameter left = getDiameter(root.left);
        Diameter right = getDiameter(root.right);
        dp.height = Math.max(left.height, right.height) + 1;

        int curr = left.height + right.height ;
        dp.diameter = Math.max(curr,Math.max(left.diameter,right.diameter));
        return dp;
    }
}
