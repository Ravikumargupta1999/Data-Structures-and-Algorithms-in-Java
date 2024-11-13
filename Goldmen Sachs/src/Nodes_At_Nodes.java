import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Nodes_At_Nodes {
    static class Node {
        int data;
        Node left, right;
        public Node(int d)
        {
            this.data = d;
            this.left = null;
            this.right = null;
        }
    }
    static Node ifNodeExists( Node node, int key)
    {
        if (node == null)
            return null;

        if (node.data == key)
            return node;
        Node res1 = ifNodeExists(node.left, key);
        if(res1 != null) return res1;
        Node res2 = ifNodeExists(node.right, key);
        return res2;
    }



    public static ArrayList<Integer> KDistanceNodes(Node root1, int target, int k) {
        Node root = ifNodeExists(root1,target);
        Queue<Node> q = new LinkedList<>();
        int i = -1;
        ArrayList<Integer> al = new ArrayList<>();

        q.add(root);
        while (!q.isEmpty()) {
            int size = q.size();
            i++;
            while(size-- >0)
            {
                if(i == k)
                    al.add(q.peek().data);
                Node current = q.peek();
                if (current.left != null)
                    q.add(current.left);
                if (current.right != null)
                    q.add(current.right);
                q.poll();
            }

        }
        return al;


    }

    public static void main(String[] args) {
        Node root = new Node(0);
        root.left = new Node(1);
        root.left.left = new Node(3);
        root.left.left.left = new Node(7);
        root.left.right = new Node(4);
        root.left.right.left = new Node(8);
        root.left.right.right = new Node(9);
        root.right = new Node(2);
        root.right.left = new Node(5);
        root.right.right = new Node(6);
        System.out.println(KDistanceNodes(root,1,2));

    }

}
//20
//        /    \
//        8       22
//        /   \
//        4    12
//        /   \
//        10    14