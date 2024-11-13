import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Largest_Value_In_Each_Level {
    class Node {
        int data;
        Node left, right;

        Node(int d) {
            data = d;
            left = right = null;
        }
    }
    public ArrayList<Integer> largestValues(Node root)
    {
        if (root == null)
            return new ArrayList<>();
        ArrayList<Integer> al = new ArrayList<>();
        Queue<Node> q = new LinkedList<>();
        q.add(root);

        int max = Integer.MIN_VALUE;
        while (!q.isEmpty()) {
            int size = q.size();

            while (size-- > 0) {
               Node current = q.peek();
               if(max < current.data)
                   max = current.data;
                if (current.left != null)
                    q.add(current.left);
                if (current.right != null)
                    q.add(current.right);
                q.poll();
            }
            al.add(max);
            max = Integer.MIN_VALUE;

        }
        return al;
    }
}
