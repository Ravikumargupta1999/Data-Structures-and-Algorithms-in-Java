public class BT_202_Sum_Of_Longest_Bloodline_of_a_Tree {
    class Node {
        int data;
        Node left, right;


        public Node(int data) {

            this.data = data;
        }
    }

    // https://practice.geeksforgeeks.org/problems/sum-of-the-longest-bloodline-of-a-tree/1#

    // Method - 1
    int max = Integer.MIN_VALUE;
    int maxLen = 0;
    public int sumOfLongRootToLeafPath(Node root) {
        if (root == null)
            return 0;
        solve(root, 0, 1);
        return max;
    }

    public void solve(Node root, int val, int len) {
        if (root == null)
            return;
        if (root.left == null && root.right == null) {
            if (len > maxLen) {
                maxLen = len;
                max = root.data + val;
            } else if (len == maxLen) {
                max = Math.max(root.data + val, max);
            }
            return;
        }
        if (root.left != null)
            solve(root.left, root.data + val, len + 1);
        if (root.right != null)
            solve(root.right, root.data + val, len + 1);
    }


    // Method - 2
    class Pair {
        int height;
        int sum;

        Pair(int height, int sum) {
            this.height = height;
            this.sum = sum;
        }
    }

    int sumOfLongestPathToLeafPathSum(BT_202_Sum_Of_Maximum_Sum_In_Path.Node root) {
        if (root == null)
            return 0;
        Pair pair = height(root);
        return pair.sum;
    }

    public Pair height(BT_202_Sum_Of_Maximum_Sum_In_Path.Node root) {
        if (root == null) {
            return new Pair(0, 0);
        }
        Pair lp = height(root.left);
        Pair rp = height(root.right);

        int height = Math.max(lp.height, rp.height) + 1;
        int sum;
        if (lp.height > rp.height)
            sum = lp.sum + root.data;
        else
            sum = rp.sum + root.data;

        return new Pair(height,sum);
    }
}
