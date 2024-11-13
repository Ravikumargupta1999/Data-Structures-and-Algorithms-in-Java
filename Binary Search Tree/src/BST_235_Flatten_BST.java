public class BST_235_Flatten_BST {
    static class TreeNode<T> {
        T data;
        TreeNode<T> left;
        TreeNode<T> right;

        TreeNode(T data) {
            this.data = data;
            left = null;
            right = null;
        }
    }


    static TreeNode<Integer> prev;


    static TreeNode<Integer> flatten(TreeNode<Integer> parent) {
        // Dummy node
        TreeNode<Integer> dummy = new TreeNode<>(-1);
        prev = dummy;

        // Calling in-order
        // traversal
        Inorder(parent);

        prev.left = null;
        prev.right = null;
//         TreeNode<Integer> ret = dummy.right;

        // Delete dummy node
        //delete dummy;
        return dummy.right;
    }

    static void Inorder(TreeNode<Integer> curr) {
        if (curr == null)
            return;
        Inorder(curr.left);
        prev.left = null;
        prev.right = curr;
        prev = curr;
        Inorder(curr.right);
    }

}
