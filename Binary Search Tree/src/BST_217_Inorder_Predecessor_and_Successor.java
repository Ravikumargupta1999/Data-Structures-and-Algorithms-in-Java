import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BST_217_Inorder_Predecessor_and_Successor {
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

    class Res {
        Node pre = null;
        Node succ = null;
    }

    //    https://www.youtube.com/watch?v=SXKAD2svfmI
    // https://practice.geeksforgeeks.org/problems/predecessor-and-successor/1
    public static void findPreSuc(Node root, Res p, Res s, int key) {
        p.pre = inorderPredecessor(root, key);
        s.succ = inorderSuccessor(root, key);

    }

    //https://practice.geeksforgeeks.org/problems/inorder-successor-in-bst/1
    public static Node inorderSuccessor(Node root, int data) {
        Node successor = null;
        while (root != null) {
            if (data >= root.data) {
                root = root.right;
            } else {
                successor = root;
                root = root.left;
            }
        }
        return successor;
    }

    public static Node inorderPredecessor(Node root, int data) {
        Node predecessor = null;
        while (root != null) {
            if (data <= root.data) {
                root = root.left;
            } else {
                predecessor = root;
                root = root.right;
            }
        }
        return predecessor;
    }
}


