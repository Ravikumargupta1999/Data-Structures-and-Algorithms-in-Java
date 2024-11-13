import java.util.*;

public class BT_199_Leaf_at_same_level {
    class Node {
        int data;
        Node left;
        Node right;

        public Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    // https://practice.geeksforgeeks.org/problems/leaf-at-same-level/1#
    boolean check(Node root) {
        Queue<Node> queue = new LinkedList<>();
        if (root == null)
            return true;
        queue.add(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            boolean flag = false;
            while (size-- > 0) {
                Node temp = queue.poll();
                if (temp.left == null && temp.right == null)
                    flag = true;
                if(temp.left != null)
                    queue.add(temp.left);
                if(temp.right != null)
                    queue.add(temp.right);
            }
            // if previous level had leaf node and next level is not empty return false
            if(flag && !queue.isEmpty())
                return false;
        }
        return true;
    }

}
