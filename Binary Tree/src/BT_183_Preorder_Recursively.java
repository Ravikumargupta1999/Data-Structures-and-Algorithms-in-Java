import java.util.ArrayList;
import java.util.List;

public class BT_183_Preorder_Recursively {
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
    static ArrayList<Integer> preorder(Node root)
    {
        ArrayList<Integer> al =new ArrayList<>();
        Preorder(root,al);
        return al;
    }
    static void Preorder(Node root,ArrayList<Integer> al) {
        if (root == null)
            return;
        al.add(root.data);
        Preorder(root.left,al);
        Preorder(root.right,al);
    }
}
