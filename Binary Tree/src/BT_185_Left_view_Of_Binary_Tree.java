import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BT_185_Left_view_Of_Binary_Tree {
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

    ArrayList<Integer> leftView(Node root) {
        ArrayList<Integer> al = new ArrayList<>();
        if(root == null)
            return al;
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        while (q.size() !=  0)
        {
            int size = q.size();
            al.add(q.peek().data);
            while (size-- > 0)
            {
                Node temp = q.poll();
                if(temp.left != null)
                    q.add(temp.left);
                if(temp.right != null)
                    q.add(temp.right);
            }
        }
        return al;
    }
}
