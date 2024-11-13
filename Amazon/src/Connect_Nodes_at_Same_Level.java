import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
//https://practice.geeksforgeeks.org/problems/connect-nodes-at-same-level/1
public class Connect_Nodes_at_Same_Level {
    class Node {
        int data;
        Node left;
        Node right;
        Node nextRight;

        Node(int data) {
            this.data = data;
            left = null;
            right = null;
            nextRight = null;
        }
    }

    //Function to connect nodes at same level.
    public void connect(Node root) {

        if (root == null)
            return;
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            int size = q.size();
            Node current = q.peek();
            if (current.left != null)
                q.add(current.left);
            if (current.right != null)
                q.add(current.right);
            q.poll();
            size--;

            while (size-- > 0) {
                Node temp = q.peek();
                if (temp.left != null)
                    q.add(temp.left);
                if (temp.right != null)
                    q.add(temp.right);
                current.nextRight = temp;
                current = temp;
                q.poll();

            }
        }
        return ;
    }
}
