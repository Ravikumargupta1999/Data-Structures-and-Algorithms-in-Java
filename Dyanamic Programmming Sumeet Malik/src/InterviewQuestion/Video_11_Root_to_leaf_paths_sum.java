package InterviewQuestion;

public class Video_11_Root_to_leaf_paths_sum {
    // https://practice.geeksforgeeks.org/problems/root-to-leaf-paths-sum/1
    static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
            left = null;
            right = null;
        }
    }

    public static long treePathsSum(Node root) {
        return sum(root, 0);
    }

    public static long sum(Node node, long val) {
        if (node == null)
            return 0;
        val = (val * 10 + node.data);
        if (node.left == null && node.right == null)
            return val;
        return sum(node.left, val) + sum(node.right, val);

    }
}
