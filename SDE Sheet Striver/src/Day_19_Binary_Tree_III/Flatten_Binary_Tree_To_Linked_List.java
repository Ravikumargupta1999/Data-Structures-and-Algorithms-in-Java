package Day_19_Binary_Tree_III;

public class Flatten_Binary_Tree_To_Linked_List {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public void flatten(TreeNode root) {

        TreeNode curr = root;

        while (curr != null) {
            if (curr.left != null) {
                TreeNode temp = curr.left;

                while (temp.right != null)
                    temp = temp.right;

                temp.right = curr.right;

                curr.right = curr.left;
            }
            curr = curr.left;
        }
    }
}
