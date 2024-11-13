public class Maximum_sum_leaf_to_root_path {
    static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
        }

    }

    static int max = Integer.MIN_VALUE;

    public static int maxPathSum(Node root) {
        if (root == null)
            return 0;
        if (root.right == null && root.left == null)
            return root.data;

        findMaxSum(root.left, root.data);
        findMaxSum(root.right, root.data);
        return max;
    }

    static void findMaxSum(Node root, int sum) {
        if(root == null)
        {
            if(sum > max)
                max = sum;
            return;
        }
//        System.out.println(sum+"  "+root.data);
        findMaxSum(root.left,sum+root.data);
        findMaxSum(root.right,sum+root.data);
    }

    public static void main(String[] args) {
        Node node = new Node(11);
        node.left = new Node(-1);
        node.right = new Node(7);

        node.left.left = new Node(8);
        node.left.right = new Node(14);

        System.out.println(maxPathSum(node));
    }
}
