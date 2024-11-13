import java.util.*;

public class BT_178_Reverse_Level_Order_Traversal {
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

    public static ArrayList<Integer> Level_order(Node root) {
        ArrayList<Integer> al = new ArrayList<>();
        if (root == null)
            return al;
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            Node current = q.peek();
            al.add(current.data);

            // taking right first
            if (current.right != null)
                q.add(current.right);

            // taking left after right
            if (current.left != null)
                q.add(current.left);

            q.poll();
        }
        Collections.reverse(al);
        return al;

    }

    // https://practice.geeksforgeeks.org/problems/reverse-level-order-traversal/1#
    public ArrayList<Integer> reverseLevelOrderTraversal(Node node) {
        ArrayList<ArrayList<Integer>> al = new ArrayList<>();
        Queue<Node> queue = new LinkedList<>();
        queue.add(node);

        while (!queue.isEmpty()) {
            ArrayList<Integer> temp = new ArrayList<>();
            int size = queue.size();
            while (size-- > 0) {
                Node rem = queue.poll();
                if (rem.left != null) {
                    queue.add(rem.left);
                }
                if (rem.right != null) {
                    queue.add(rem.right);
                }
                temp.add(rem.data);
            }
            al.add(temp);
        }
        ArrayList<Integer> ans = new ArrayList<>();
        for (int i = al.size() - 1; i >= 0; i--) {
            for (int j = 0; j < al.get(i).size(); j++) {
                ans.add(al.get(i).get(j));
            }
        }
        return ans;
    }

}
