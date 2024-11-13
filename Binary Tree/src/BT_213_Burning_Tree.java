import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class BT_213_Burning_Tree {
    static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
            left = null;
            right = null;
        }
    }

    public static int minTime(Node root, int a) {
        HashMap<Node, Node> parent = new HashMap<>();
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        parent.put(root, null);

        Node target = null;
        HashSet<Node> vis = new HashSet<>();
        while (!queue.isEmpty()) {
            Node node = queue.poll();
            vis.add(node);
            if (node.data == a)
                target = node;
            if (node.left != null) {
                queue.add(node.left);
                parent.put(node.left, node);
            }
            if (node.right != null) {
                queue.add(node.right);
                parent.put(node.right, node);
            }
        }
        queue.add(target);
        int timer = 0;
        while (!queue.isEmpty()) {
            int t = queue.size();
            while (t-- > 0) {
                Node curr = queue.poll();
                if (curr.left != null && vis.contains(curr.left)) {
                    queue.add(curr.left);
                    vis.remove(curr.left);
                }
                if (curr.right != null && vis.contains(curr.right)) {
                    queue.add(curr.right);
                    vis.remove(curr.right);
                }
                if (parent.containsKey(curr) && vis.contains(parent.get(curr))) {
                    queue.add(parent.get(curr));
                    vis.remove(parent.get(curr));
                }
            }
            if (!queue.isEmpty())
                timer++;
        }
        return timer;
    }
}
