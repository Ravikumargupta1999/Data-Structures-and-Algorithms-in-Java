import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BT_177_Level_Order_Traversal {
    // https://practice.geeksforgeeks.org/problems/level-order-traversal/1
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

    // https://practice.geeksforgeeks.org/problems/level-order-traversal/1
    public static void levelOrder(Node root) {
        ArrayList<Integer> al = new ArrayList<>();
        if (root == null)
            return;
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            Node current = q.peek();
            al.add(current.data);
            if (current.left != null)
                q.add(current.left);
            if (current.right != null)
                q.add(current.right);
            q.poll();
        }

    }

}
