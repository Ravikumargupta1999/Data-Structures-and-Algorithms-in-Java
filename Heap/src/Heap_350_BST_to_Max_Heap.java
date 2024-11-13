import java.util.ArrayList;
import java.util.Stack;
import java.util.Vector;

// https://practice.geeksforgeeks.org/problems/bst-to-max-heap/0/#

public class Heap_350_BST_to_Max_Heap {
    static class Node {
        int data;
        Node left;
        Node right;

        public Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }
    public static void convertToMaxHeapUtil(Node root)
    {
        ArrayList<Integer> al = inOrder(root);
        ArrayList<Integer> temp = new ArrayList<>();
        temp.add(al.size() - 1);
        BSTToMaxHeap(root, al, temp);
    }

    static void BSTToMaxHeap(Node root, ArrayList<Integer> arr, ArrayList<Integer> temp) {
        if (root == null)
            return;
        root.data = arr.get(temp.get(0));
        temp.set(0, temp.get(0) - 1);
        BSTToMaxHeap(root.right, arr, temp);
        BSTToMaxHeap(root.left, arr, temp);

    }

    static ArrayList<Integer> inOrder(Node root) {

        ArrayList<Integer> al = new ArrayList<>();
        if (root == null)
            return al;
        Stack<Node> st = new Stack<>();
        while (!st.isEmpty() || root != null) {
            if (root != null) {
                st.push(root);
                root = root.left;
            } else {
                root = st.pop();
                al.add(root.data);
                root = root.right;
            }
        }
        return al;
    }
}
