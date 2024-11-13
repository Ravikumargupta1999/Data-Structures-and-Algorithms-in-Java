import java.util.ArrayList;
import java.util.Stack;

public class BST_230_Replace_Every_Element_With_The_Least_Greater_Element_On_Its_Right {
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

    // https://practice.geeksforgeeks.org/problems/replace-every-element-with-the-least-greater-element-on-its-right/1/#
    public static ArrayList<Integer> findLeastGreater(int n, int[] arr) {
        Node root = null;
        for (int i = n - 1; i >= 0; i--) {
            root = insert(root, arr[i]);
            Node successor = inorderSuccessor(root, arr[i]);
            if (successor == null)
                arr[i] = -1;
            else
                arr[i] = successor.data;
        }
        ArrayList<Integer> list = new ArrayList<>();
        for (int val : arr)
            list.add(val);
        return list;
    }

    static Node insert(Node root, int data) {

        if (root == null) {
            root = new Node(data);
            return root;
        }
        if (data < root.data) {
            root.left = insert(root.left, data);
        } else if (data > root.data) {
            root.right = insert(root.right, data);
        }
        return root;
    }

    public static Node inorderSuccessor(Node root, int x) {
        Node successor = null;
        while (root != null) {
            if (x >= root.data) {
                root = root.right;
            } else {
                successor = root;
                root = root.left;
            }
        }
        return successor;

    }

    //     https://practice.geeksforgeeks.org/problems/greater-on-right-side4305/1
    //  https://leetcode.com/problems/replace-elements-with-greatest-element-on-right-side/
    // Replace Elements with Greatest Element on Right Side
    void nextGreatest1(int arr[], int n) {
        int prev = arr[n - 1];
        arr[n - 1] = -1;

        for (int i = n - 2; i >= 0; i--) {

            int curr = arr[i];

            arr[i] = prev;

            prev = Math.max(curr, prev);
        }
    }




}
//Input : [8, 58, 71, 18, 31, 32, 63, 92,43, 3, 91, 93, 25, 80, 28]
//Output: [18, 63, 80, 25, 32, 43, 80, 93,80, 25, 93, -1, 28, -1, -1]