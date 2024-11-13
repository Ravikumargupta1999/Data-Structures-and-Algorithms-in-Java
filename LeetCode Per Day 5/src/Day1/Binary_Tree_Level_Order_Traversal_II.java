package Day1;

import java.util.*;

public class Binary_Tree_Level_Order_Traversal_II {
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
    // https://leetcode.com/problems/binary-tree-level-order-traversal-ii/submissions/
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        if (root == null)
            return res;
        queue.add(root);

        while (queue.size() > 0) {

            int size = queue.size();

            List<Integer> list = new ArrayList<>();

            while (size-- > 0) {
               TreeNode temp = queue.poll();
                if (temp.left != null)
                    queue.add(temp.left);
                if (temp.right != null)
                    queue.add(temp.right);
                list.add(temp.val);
            }
            res.add(list);
        }
        Collections.reverse(res);
        return res;
    }
}
