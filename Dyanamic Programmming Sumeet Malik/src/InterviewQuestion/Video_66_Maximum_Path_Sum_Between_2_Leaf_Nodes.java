package InterviewQuestion;

public class Video_66_Maximum_Path_Sum_Between_2_Leaf_Nodes {
    // Nahi Samjha
    // Aur ye code wrong hai

    static class Node {
        int data;
        Node left, right;

        Node(int item) {
            data = item;
            left = right = null;
        }
    }

//    static class Pair {
//        int maxSum = Integer.MIN_VALUE;
//        int straight;
//        boolean isLeaf;
//    }
//
//    static int maxPathSum(Node root) {
//        return getSum(root).maxSum;
//    }
//
//    static Pair getSum(Node root) {
//        if (root == null)
//            return new Pair();
//        if (root.left == null && root.right == null) {
//            Pair curr = new Pair();
//            curr.isLeaf = true;
//            curr.straight = root.data;
//            curr.maxSum = root.data;
//            return curr;
//        }
//        Pair left = getSum(root.left);
//        Pair right = getSum(root.right);
//
//        Pair curr = new Pair();
//        curr.straight = Math.max(left.straight, right.straight) + root.data;
//
//        if ((left.isLeaf && right.isLeaf) || (root.left == null && root.right == null)) {
//            curr.maxSum = left.maxSum + right.maxSum + root.data;
//        } else if (right.isLeaf || root.right == null) {
//            int a = left.maxSum;
//            int b = left.straight + right.straight + root.data;
//            curr.maxSum = Math.max(a, b);
//        } else if (left.isLeaf || root.left == null ) {
//            int a = right.maxSum;
//            int b = left.straight + right.straight + root.data;
//            curr.maxSum = Math.max(a, b);
//        } else {
//            int a = right.maxSum;
//            int b = left.maxSum;
//            int c = right.straight + left.straight + root.data;
//            curr.maxSum = Math.max(a,Math.max(b,c));
//        }
//        System.out.println(root.data +"   "+curr.maxSum+"  "+curr.straight+"   "+curr.isLeaf);
//        return curr;
//    }

    public static void main(String[] args) {
        Node node = new Node(-10);
        node.left = new Node(-1);
        node.left.left = new Node(3);
        node.right = new Node(0);
//        System.out.println(maxPathSum(node));
    }


}
