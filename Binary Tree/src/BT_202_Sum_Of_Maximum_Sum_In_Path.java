public class BT_202_Sum_Of_Maximum_Sum_In_Path {
    class Node {
        int data;
        Node left, right;

        public Node(int data) {
            this.data = data;
        }
    }

    // This is for maximum sum in path to leaf not for longest path sum
    int max = Integer.MIN_VALUE;

    public int sumOfLongRootToLeafPath(Node root) {
        if (root == null)
            return 0;
        solve(root, 0);
        return max;
    }

    public void solve(Node root, int val) {
        if (root == null)
            return;
        if (root.left == null && root.right == null) {
            max = Math.max(root.data + val, max);
            return;
        }
        if (root.left != null)
            solve(root.left, root.data + val);
        if (root.right != null)
            solve(root.right, root.data + val);
    }


}

