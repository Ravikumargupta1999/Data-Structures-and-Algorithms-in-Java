import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Leetcode_95_Unique_Binary_Search_Trees_II {
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

    // https://leetcode.com/problems/unique-binary-search-trees-ii/
    // https://www.youtube.com/watch?v=mhCJgZWJlSI
    public List<TreeNode> generateTrees(int n) {
        return helper(1, n);
    }

    public List<TreeNode> helper(int start, int end) {
        List<TreeNode> list = new ArrayList<>();
        if (start > end) {
            list.add(null);
            return list;
        }
        if (start == end) {
            list.add(new TreeNode(start));
            return list;
        }
        for (int i = start; i <= end; i++) {
            List<TreeNode> left = helper(start, i - 1);
            List<TreeNode> right = helper(i + 1, end);
            for (TreeNode lRoot : left) {
                for (TreeNode rRoot : right) {
                    TreeNode root = new TreeNode(i);
                    root.left = lRoot;
                    root.right = rRoot;
                    list.add(root);
                }
            }
        }
        return list;
    }
}
