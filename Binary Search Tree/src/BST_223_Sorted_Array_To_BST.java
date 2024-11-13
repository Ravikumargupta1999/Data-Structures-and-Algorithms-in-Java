import java.util.ArrayList;

// https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree/submissions/
// https://practice.geeksforgeeks.org/problems/array-to-bst4443/1#
public class BST_223_Sorted_Array_To_BST {
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

    Node temp_root = null;

    public int[] sortedArrayToBST(int[] al1) {
        temp_root = Array_To_B_BST(al1, 0, al1.length - 1);
        ArrayList<Integer> al = new ArrayList<>();

        Preorder(temp_root, al);
        int[] arr = new int[al.size()];
        for (int i = 0; i < al.size(); i++) {
            arr[i] = al.get(i);
        }
        return arr;
    }

    public Node Array_To_B_BST(int[] al, int start, int end) {
        if (start > end)
            return null;
        int mid = (start + end) / 2;
        Node node = new Node(al[mid]);
        node.left = Array_To_B_BST(al, start, mid - 1);
        node.right = Array_To_B_BST(al, mid + 1, end);

        return node;
    }

    public void Preorder(Node root, ArrayList<Integer> al) {
        if (root == null)
            return;
        al.add(root.data);
        Preorder(root.left, al);
        Preorder(root.right, al);
    }

}
