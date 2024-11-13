package Day_21_Binary_Search_Tree_Part_II;

public class Floor_in_a_BST {
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


    // same as Inorder predecessor
    public static int floorInBST(TreeNode<Integer> root, int X) {

        TreeNode<Integer> predecessor = null;
        while (root != null) {
            if (X < root.data) {
                root = root.left;
            } else {
                predecessor = root;
                root = root.right;
            }
        }
        return predecessor.data;
    }
}
