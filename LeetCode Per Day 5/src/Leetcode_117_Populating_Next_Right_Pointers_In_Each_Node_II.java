import java.util.LinkedList;
import java.util.Queue;

public class Leetcode_117_Populating_Next_Right_Pointers_In_Each_Node_II {
    // https://leetcode.com/problems/populating-next-right-pointers-in-each-node-ii/submissions/
    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }

    public Node connect(Node root) {
        if (root == null)
            return root;
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (queue.size() > 0) {

            int size = queue.size();

            Node prev = null;

            while (size-- > 0){

                Node temp = queue.poll();
                if(prev != null)
                    prev.next = temp;
                prev = temp;

                if(temp.left != null)
                    queue.add(temp.left);
                if(temp.right != null)
                    queue.add(temp.right);
            }
        }
        return root;
    }

}
