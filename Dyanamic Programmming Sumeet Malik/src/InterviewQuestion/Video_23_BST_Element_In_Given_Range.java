package InterviewQuestion;

import java.util.ArrayList;

public class Video_23_BST_Element_In_Given_Range {
    static class Node {
        int data;
        Node left, right;

        Node(int data) {
            this.data = data;
            left = right = null;
        }
    }

    public static ArrayList<Integer> printNearNodes(Node root, int low, int high) {
        ArrayList<Integer> list = new ArrayList<>();
        inorder(root, low, high, list);
        return list;
    }

    public static void inorder(Node root, int low, int high, ArrayList<Integer> list) {
        if (root == null)
            return;
        inorder(root.left, low, high, list);
        if(root.data >= low && root.data <= high){
            list.add(root.data);
        }
        inorder(root.right, low, high, list);
    }
}
