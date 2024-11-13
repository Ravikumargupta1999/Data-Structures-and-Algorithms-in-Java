package Day_17_Binary_Search_;

import java.util.LinkedList;
import java.util.Queue;

public class Width_Of_Shadow_Of_A_Binary_Tree {
    static class Node {
        int data;
        Node left, right;

        Node(int item) {
            data = item;
            left = right = null;
        }
    }

    static class width {
        int width;
        Node node;

        public width(Node node, int width) {
            this.node = node;
            this.width = width;
        }
    }

    static int[] getWidthOfBinaryTree(Node root) {
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

}
