package Day_21_Binary_Search_Tree_Part_II;

public class Ceil_From_BST {
    class TreeNode<T> {

        T data;
        TreeNode<T> left;
        TreeNode<T> right;

        TreeNode(T data) {
            this.data = data;
            left = null;
            right = null;
        }
    }
//    https://www.codingninjas.com/codestudio/problems/920464?topList=striver-sde-sheet-problems&utm_source=striver&utm_medium=website&leftPanelTab=1
   // Same as inorder successor
    public static int findCeil(TreeNode<Integer> node, int x) {
        TreeNode<Integer> ceil = inorderSuccessor(node,x);
        if(ceil != null)
            return ceil.data;
        return -1;
    }
    public static TreeNode<Integer> inorderSuccessor(TreeNode<Integer> root, int data) {
        TreeNode<Integer> successor = null;
        while (root != null) {
            if (data > root.data) {
                root = root.right;
            } else {
                successor = root;
                root = root.left;
            }
        }
        return successor;
    }

}
