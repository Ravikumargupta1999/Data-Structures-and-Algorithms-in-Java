import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BT_186_Right_View_Of_Binary_Tree {
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

    // https://practice.geeksforgeeks.org/problems/right-view-of-binary-tree/1#
    ArrayList<Integer> rightView(Node node) {
        ArrayList<Integer> ans = new ArrayList<>();
        Queue<Node> queue = new LinkedList<>();
        queue.add(node);
        while (!queue.isEmpty()) {
            int size = queue.size();
            ans.add(queue.peek().data);
            while (size-- > 0) {
                Node rem = queue.poll();
                if (rem.right != null) {
                    queue.add(rem.right);
                }
                if (rem.left != null) {
                    queue.add(rem.left);
                }
            }
        }
        return ans;
    }

    ArrayList<Integer> rightView1(Node root) {
        ArrayList<Integer> al = new ArrayList<>();
        if (root == null)
            return al;
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        while (q.size() != 0) {
            int size = q.size();
            int val = -1;
            while (size-- > 0) {
                Node temp = q.poll();
                val = temp.data;
                if (temp.left != null)
                    q.add(temp.left);
                if (temp.right != null)
                    q.add(temp.right);
            }

            // add last element of each level
            al.add(val);
        }
        return al;
    }


}
