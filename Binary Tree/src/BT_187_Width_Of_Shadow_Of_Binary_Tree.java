public class BT_187_Width_Of_Shadow_Of_Binary_Tree {
    class Node {
        int data;
        Node left;
        Node right;

        public Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    // https://practice.geeksforgeeks.org/problems/vertical-width-of-a-binary-tree/1/#
    public static int verticalWidth(Node root) {
        if (root == null)
            return 0;
        int[] ans = new int[2];
        width(root, 0, ans);
        return ans[1] - ans[0] + 1;
    }

    static void width(Node root, int h1, int[] ans) {
        if (root == null)
            return;
        ans[0] = Math.min(ans[0], h1);
        ans[1] = Math.max(ans[1], h1);
        width(root.left, h1 - 1, ans);
        width(root.right, h1 + 1, ans);
    }
}
