import java.util.ArrayList;

public class BST_to_greater_sum_tree {
    static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
            left = null;
            right = null;
        }
    }
//
//    static ArrayList<Integer> al = new ArrayList<>();
    static int sum = 0;

    public static void transformTree(Node root) {
        if(root == null)
            return;
        transformTree(root.right);
        int temp = root.data;
        root.data = sum;
        sum += temp;
        transformTree(root.left);
    }

    public static void Inorder(Node root) {
        if (root == null)
            return;
        Inorder(root.left);
//        al.add(root.data);
        System.out.print(root.data+" ");
        Inorder(root.right);
    }

//    public static void Inorder1(Node root) {
//        if (root == null)
//            return;
//        Inorder1(root.left);
//        root.data = al.get(i++);
//        System.out.print(root.data+" ");
//        Inorder1(root.right);
//    }

    public static void main(String[] args) {
        Node root = new Node(2);
        root.left = new Node(1);
        root.right = new Node(6);
        root.right.left = new Node(3);
        root.right.right = new Node(7);
        Inorder(root);
        transformTree(root);
        System.out.println("\n");
        Inorder(root);

    }
}
