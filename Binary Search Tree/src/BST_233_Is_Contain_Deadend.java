import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class BST_233_Is_Contain_Deadend {
    public static class Node {
        int data;
        Node left;
        Node right;

        public Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }

    }

    // Wrong Solution
    public static boolean isDeadEnd(Node root) {
        HashSet<Integer> map = new HashSet<>();
        if (root == null)
            return false;
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {

            Node temp = queue.poll();
            map.add(temp.data);
            if (temp.left != null)
                queue.add(temp.left);
            if (temp.right != null)
                queue.add(temp.right);
        }

        if (map.contains(1))
            return true;
        for (int val : map) {
            if (!map.contains(val - 1) || !map.contains(val + 1))
                continue;
            return true;
        }
        return false;
    }

    // https://practice.geeksforgeeks.org/problems/check-whether-bst-contains-dead-end/1#
    //
    static boolean isDeadEnd1(Node root) {
        return helper(root, 0, Integer.MAX_VALUE);
    }

    static boolean helper(Node root, int min, int max) {
        if (root == null)
            return false;
        if (min == max || (max == 1))
            return true;
        return helper(root.left, min, root.data - 1) || helper(root.right, root.data + 1, max);
    }

    // https://www.codingninjas.com/codestudio/problems/check-for-dead-end-in-a-bst_1169457?leftPanelTab=1
    class TreeNode<T> {
        T data;
        TreeNode<T> left;
        TreeNode<T> right;

        TreeNode(T data) {
            this.data = data;
            left = null;
            right = null;
        }
    }



    public static Boolean isDeadEnd(TreeNode<Integer> root) {
        return helper(root, 0, Integer.MAX_VALUE);
    }

    static boolean helper(TreeNode<Integer> root, int min, int max) {
        if (root == null)
            return false;
        if (min == max || (max == 1))
            return true;
        return helper(root.left, min, root.data - 1) || helper(root.right, root.data + 1, max);

    }

}
