import java.util.HashMap;
import java.util.logging.Handler;

// https://practice.geeksforgeeks.org/problems/maximum-sum-of-non-adjacent-nodes/1#
public class BT_205_Maximum_Sum_Of_Non_Adjacent_Nodes {
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

    static HashMap<Node, Integer> dp = new HashMap<>();

    static int getMaxSum(Node root) {
        if (root == null)
            return 0;
        return func(root);
    }

    static int func(Node root) {
        if (root == null)
            return 0;
        if (dp.get(root) != null)
            return dp.get(root);
        int inc = root.data;
        if (root.left != null) {
            inc += func(root.left.left);
            inc += func(root.left.right);
        }
        if (root.right != null) {
            inc += func(root.right.left);
            inc += func(root.right.right);
        }
        int exc = func(root.left) + func(root.right);
        dp.put(root, Math.max(inc, exc));
        return dp.get(root);

    }

}
// https://www.codingninjas.com/codestudio/problems/maximum-sum-of-nodes-in-a-binary-tree-such-that-no-two-nodes-are-adjacent_1118112?leftPanelTab=1