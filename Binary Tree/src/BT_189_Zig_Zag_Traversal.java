import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

public class BT_189_Zig_Zag_Traversal {
    static class Node {
        int data;
        Node left;
        Node right;

        public Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }
    // https://practice.geeksforgeeks.org/problems/zigzag-tree-traversal/1
    ArrayList<Integer> zigZagTraversal(Node root)
    {
        ArrayList<Integer> al = new ArrayList<>();
        Queue<Node> q = new LinkedList<>();
        if (root == null)
            return al;
        q.add(root);
        boolean f = false;
        while (!q.isEmpty()) {
            ArrayList<Integer> temp = new ArrayList<>();
            int size = q.size();
            while (size-- > 0) {
                Node temp_node = q.poll();
                temp.add(temp_node.data);
                if (temp_node.left != null)
                    q.add(temp_node.left);
                if (temp_node.right != null)
                    q.add(temp_node.right);
            }
            if (f)
                Collections.reverse(temp);
            for (int i = 0; i < temp.size(); i++)
                al.add(temp.get(i));
            f = !f;
        }
        return al;


    }
}
