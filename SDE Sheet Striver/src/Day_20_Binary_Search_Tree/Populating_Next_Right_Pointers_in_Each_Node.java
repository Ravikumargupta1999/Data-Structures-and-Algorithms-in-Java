package Day_20_Binary_Search_Tree;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Populating_Next_Right_Pointers_in_Each_Node {
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

    // https://leetcode.com/problems/populating-next-right-pointers-in-each-node/submissions/
    public Node connect(Node root) {

        if(root == null)
            return null;

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()){

            int size = queue.size();
            Node prev = null;
            while (size-- > 0){

                Node rem = queue.poll();
                if(prev != null)
                    prev.next = rem;
                prev = rem;

                if(rem.left != null)
                    queue.add(rem.left);
                if(rem.right != null)
                    queue.add(rem.right);
            }
        }
        return root;
    }
}
