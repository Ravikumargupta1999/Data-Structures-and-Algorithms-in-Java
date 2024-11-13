import java.util.LinkedList;
import java.util.Queue;

public class Maximum_Node_Level {
    class Node {
        int data;
        Node left, right;

        Node(int d) {
            data = d;
            left = right = null;
        }
    }

    public int maxLevelSum(Node root) {
        if (root == null)
            return -1;
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        int ans = -1;
        int level = 0;
        int max_nodes = Integer.MIN_VALUE;
        while (!q.isEmpty()) {
            int size = q.size();
            if (size > max_nodes) {
                max_nodes = size;
                ans = level;
            }
            while (size-- > 0) {
                Node current = q.peek();
                if (current.left != null)
                    q.add(current.left);
                if (current.right != null)
                    q.add(current.right);
                q.poll();
            }
            level++;
        }
        return ans;
    }
}
