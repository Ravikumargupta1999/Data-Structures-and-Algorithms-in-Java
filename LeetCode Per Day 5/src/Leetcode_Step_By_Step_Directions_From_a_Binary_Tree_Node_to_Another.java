public class Leetcode_Step_By_Step_Directions_From_a_Binary_Tree_Node_to_Another {
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

    public String getDirections(TreeNode root, int startValue, int destValue) {
        root = lowestCommonAncestor(root, startValue, destValue);

        StringBuilder p1 = new StringBuilder("");
        StringBuilder p2 = new StringBuilder("");

        path(root, startValue, p1);
        path(root, destValue, p2);
        for (int i = 0; i < p1.length(); i++) {
            p1.setCharAt(i, 'U');
        }
        p1.append(p2);
        return p1.toString();
    }

    int path(TreeNode root, int value, StringBuilder path) {
        if (root == null) {
            return 0;
        }
        if (root.val == value) {
            return 1;
        }
        path.append('L');

        int res = path(root.left, value, path);
        if (res > 0)
            return 1;
        path.deleteCharAt(path.length() - 1);
        path.append('R');
        res = path(root.right, value, path);
        if (res > 0)
            return 1;
        path.deleteCharAt(path.length() - 1);
        return 0;
    }

    public TreeNode lowestCommonAncestor(TreeNode root, int p, int q) {
        if (root == null)
            return null;
        if (root.val == p)
            return root;
        if (root.val == q)
            return root;
        TreeNode l = lowestCommonAncestor(root.left, p, q);
        TreeNode r = lowestCommonAncestor(root.right, p, q);
        if (l != null && r != null)
            return root;
        if (l != null)
            return l;
        return r;
    }
}
