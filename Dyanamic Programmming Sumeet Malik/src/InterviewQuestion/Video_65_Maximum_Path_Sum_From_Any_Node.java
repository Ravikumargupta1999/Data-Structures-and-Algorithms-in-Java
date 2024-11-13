package InterviewQuestion;

public class Video_65_Maximum_Path_Sum_From_Any_Node {
    // Khud ke logic ka code hai na ki video ke logic ka
    // https://practice.geeksforgeeks.org/problems/maximum-path-sum-from-any-node/1
    // https://www.youtube.com/watch?v=ArNyupe-XH0&list=PL_z_8CaSLPWekqhdCPmFohncHwz8TY2Go&index=49
    static class Node {
        int data;
        Node left, right;

        Node(int d) {
            data = d;
            left = right = null;
        }
    }

    static class Pair {
        int maximum = Integer.MIN_VALUE;
        int straight = 0;
    }

    static int findMaxSum(Node node) {
        Pair p = getMaxSum(node);
        return Math.max(p.maximum, p.straight);
    }

    static Pair getMaxSum(Node root) {
        if (root == null) {
            return new Pair();
        }

        Pair left = getMaxSum(root.left);
        Pair right = getMaxSum(root.right);


        Pair curr = new Pair();

        curr.straight = Math.max(root.data, Math.max(left.straight, right.straight) + root.data);


        int a = Math.max(left.maximum, right.maximum);
        int b = Math.max(left.straight, right.straight) + root.data;
        int c = Math.max(left.straight + right.straight + root.data, root.data);

        curr.maximum = Math.max(a, Math.max(b, c));


        return curr;
    }

    public static void main(String[] args) {


        Node node = new Node(-4);
        node.left = new Node(3);
        node.left.left = new Node(5);
        node.left.right = new Node(-5);
        System.out.println(findMaxSum(node));
    }

    // Khud Ka logic bahenchod
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

    class Nodes {
        int maximum = Integer.MIN_VALUE;
        int straight = 0;
    }

    public int maxPathSum(TreeNode root) {

        Nodes p = getMaxSum(root);
        return Math.max(p.maximum, p.straight);
    }

    Nodes getMaxSum(TreeNode root) {
        if (root == null) {
            return new Nodes();
        }

        Nodes left = getMaxSum(root.left);
        Nodes right = getMaxSum(root.right);


        Nodes curr = new Nodes();

        curr.straight = Math.max(root.val, Math.max(left.straight, right.straight) + root.val);


        int a = Math.max(left.maximum, right.maximum);
        int b = Math.max(left.straight, right.straight) + root.val;
        int c = Math.max(left.straight + right.straight + root.val, root.val);

        curr.maximum = Math.max(a, Math.max(b, c));


        return curr;
    }

    }
