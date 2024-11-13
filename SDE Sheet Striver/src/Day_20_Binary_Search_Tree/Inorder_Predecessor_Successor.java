package Day_20_Binary_Search_Tree;

public class Inorder_Predecessor_Successor {
    // https://www.youtube.com/watch?v=SXKAD2svfmI
    // https://practice.geeksforgeeks.org/problems/predecessor-and-successor/1
    class Node {
        int data;
        Node left, right;

        Node(int item) {
            data = item;
            left = right = null;
        }
    }

    class Res {
        Node pre = null;
        Node succ = null;
    }

    public static void findPreSuc(Node root, Res p, Res s, int key) {
        p.pre = inorderPredecessor(root, key);
        s.succ = inorderSuccessor(root, key);
    }

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
