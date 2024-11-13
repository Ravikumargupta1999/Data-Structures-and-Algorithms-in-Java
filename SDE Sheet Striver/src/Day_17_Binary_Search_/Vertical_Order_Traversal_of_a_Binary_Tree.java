package Day_17_Binary_Search_;

import java.util.*;

public class Vertical_Order_Traversal_of_a_Binary_Tree {
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

    int[] getWidthOfBinaryTree(TreeNode root) {
        if (root == null)
            return null;
        int[] res = new int[2];

        Queue<width> queue = new LinkedList<>();
        queue.add(new width(root, 0));

        while (!queue.isEmpty()) {

            width temp = queue.poll();

            res[0] = Math.min(res[0], temp.width);
            res[1] = Math.max(res[1], temp.width);

            if (temp.node.left != null)
                queue.add(new width(temp.node.left, temp.width - 1));
            if (temp.node.right != null)
                queue.add(new width(temp.node.right, temp.width + 1));
        }
        return res;
    }

    static class Bottom {
        int width;
        TreeNode node;

        public Bottom(TreeNode node, int width) {
            this.node = node;
            this.width = width;
        }
    }

    // Right hai but order is wrong for same level nodes
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        if (root == null)
            return null;
        int[] res = getWidthOfBinaryTree(root);

        int size = res[1] - res[0] + 1;

        List<List<Integer>> arr = new ArrayList<>();
        for (int i = 0; i < size; i++)
            arr.add(new ArrayList<>());

        Queue<Bottom> queue = new LinkedList<>();
        queue.add(new Bottom(root, 0));


        while (!queue.isEmpty()) {

            Bottom rem = queue.poll();

            arr.get(rem.width - res[0]).add(rem.node.val);

            if (rem.node.left != null)
                queue.add(new Bottom(rem.node.left, rem.width - 1));
            if (rem.node.right != null) {
                queue.add(new Bottom(rem.node.right, rem.width + 1));
            }
        }

        return arr;
    }
}
