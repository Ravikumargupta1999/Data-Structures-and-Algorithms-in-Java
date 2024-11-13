import java.util.ArrayList;

public class Heap_350_BST_To_Min_Heap {
    // https://www.codingninjas.com/codestudio/problems/convert-bst-to-min-heap_920498?leftPanelTab=1
    static class BinaryTreeNode {

        int data;
        BinaryTreeNode left;
        BinaryTreeNode right;

        BinaryTreeNode(int data) {
            this.data = data;
            left = null;
            right = null;
        }
    }

    public static BinaryTreeNode convertBST(BinaryTreeNode root) {
        if (root == null)
            return null;
        ArrayList<Integer> al = new ArrayList<>();
        inorder(root, al);
        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(0);
        convert_To_BST(root, al, arrayList);
        return root;
    }

    public static void convert_To_BST(BinaryTreeNode node, ArrayList<Integer> al, ArrayList<Integer> arrayList) {
        if (node == null)
            return;
        node.data = al.get(arrayList.get(0));
        arrayList.set(0, arrayList.get(0) + 1);

        convert_To_BST(node.left, al, arrayList);
        convert_To_BST(node.right, al, arrayList);

    }

    static void inorder(BinaryTreeNode node, ArrayList<Integer> arrayList) {
        if (node == null)
            return;
        inorder(node.left, arrayList);
        arrayList.add(node.data);
        inorder(node.right, arrayList);
    }


}
