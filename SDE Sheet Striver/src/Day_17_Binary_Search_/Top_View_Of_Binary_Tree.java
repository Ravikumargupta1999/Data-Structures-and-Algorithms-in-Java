package Day_17_Binary_Search_;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Top_View_Of_Binary_Tree {
    // https://practice.geeksforgeeks.org/problems/top-view-of-binary-tree/1
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

    static class Bottom {
        int width;
        Node node;

        public Bottom(Node node, int width) {
            this.node = node;
            this.width = width;
        }
    }

    static ArrayList<Integer> topView(Node root) {
        if (root == null)
            return null;
        int[] res = getWidthOfBinaryTree(root);
        // System.out.println(Arrays.toString(res));
        int[] arr = new int[res[1] - res[0] + 1];
        Arrays.fill(arr, -1);

        Queue<Bottom> queue = new LinkedList<>();
        queue.add(new Bottom(root, 0));


        while (!queue.isEmpty()) {

            Bottom rem = queue.poll();
            if (arr[rem.width - res[0]] == -1)
                arr[rem.width - res[0]] = rem.node.data;

            if (rem.node.left != null)
                queue.add(new Bottom(rem.node.left, rem.width - 1));
            if (rem.node.right != null) {
                queue.add(new Bottom(rem.node.right, rem.width + 1));
            }
        }
        ArrayList<Integer> list = new ArrayList<>();
        for (int num : arr)
            list.add(num);
        return list;
    }
}
