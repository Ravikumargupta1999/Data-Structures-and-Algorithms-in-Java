package Day_17_Binary_Search_;

import java.util.LinkedList;
import java.util.Queue;

public class Maximum_Width_of_Binary_Tree {
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

    class width {
        int width;
        TreeNode node;

        public width(TreeNode node, int width) {
            this.node = node;
            this.width = width;
        }
    }
    // https://leetcode.com/problems/maximum-width-of-binary-tree/submissions/
    // https://www.youtube.com/watch?v=R9qiY7OK9JQ&t=476s
    public int widthOfBinaryTree(TreeNode root) {
        if (root == null)
            return 0;

        Queue<width> queue = new LinkedList<>();
        queue.add(new width(root, 0));
        int res = 0;

        while (!queue.isEmpty()) {

            int size = queue.size();
            int max = Integer.MIN_VALUE;
            int min = Integer.MAX_VALUE;
            while (size-- > 0) {

                width rem = queue.poll();

                max = Math.max(max, rem.width);
                min = Math.min(min, rem.width);

                if (rem.node.left != null)
                    queue.add(new width(rem.node.left, 2 * rem.width + 1));
                if (rem.node.right != null)
                    queue.add(new width(rem.node.right, 2 * rem.width + 2));
            }

            res = Math.max(res, max - min + 1);

        }
        return res;
    }
}
