import java.util.ArrayList;

public class BT_184_Postorder_Recursively {
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
    static ArrayList<Integer> postOrder(Node root)
    {
        ArrayList<Integer> al =new ArrayList<>();
        Postorder(root,al);
        return al;
    }
    static void Postorder(Node root, ArrayList<Integer> al) {
        if (root == null)
            return;

        Postorder(root.left,al);
        Postorder(root.right,al);
        al.add(root.data);
    }
}
