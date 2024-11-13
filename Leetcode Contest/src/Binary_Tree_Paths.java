import java.util.ArrayList;
import java.util.List;

public class Binary_Tree_Paths {
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

    public List<String> binaryTreePaths(TreeNode root) {
        List<String> list = new ArrayList<>();
        getPaths(root, "", list);
        return list;
    }

    public void getPaths(TreeNode root, String res, List<String> list) {
        if (root == null) return;
        res = res + "" + root.val;
        if (root.left == null && root.right == null) {
            list.add(res);
            return;
        }
        getPaths(root.left, res + "->", list);
        getPaths(root.right, res + "->", list);
    }
}
