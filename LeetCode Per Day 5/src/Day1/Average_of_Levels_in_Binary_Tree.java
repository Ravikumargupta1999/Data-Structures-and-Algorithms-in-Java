package Day1;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Average_of_Levels_in_Binary_Tree {
    // https://leetcode.com/problems/average-of-levels-in-binary-tree/submissions/
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

    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> list = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        if (root == null)
            return list;
        queue.add(root);

        while (queue.size() > 0) {

            int size = queue.size();
            int count = size;
            Double val = 0.0;
            while (size-- > 0) {
                TreeNode temp = queue.poll();
                if (temp.left != null)
                    queue.add(temp.left);
                if (temp.right != null)
                    queue.add(temp.right);
                val += temp.val;

            }
            list.add(val / count);

        }

        return list;
    }

}
