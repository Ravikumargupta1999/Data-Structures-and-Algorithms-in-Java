package InterviewQuestion;

public class Video_30_Root_To_Leaf_Path_Sum {
    class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
            left = null;
            right = null;
        }
    }

    boolean hasPathSum(Node root, int S) {
        return checkIfSum(root, 0, S);
    }

    boolean checkIfSum(Node node, int currSum, int requiredSum) {
        if (node == null)
            return false;
        if (node.left == null && node.right == null)
            return currSum + node.data == requiredSum;
        if (checkIfSum(node.left, currSum + node.data, requiredSum))
            return true;
        return checkIfSum(node.right, currSum + node.data, requiredSum);
    }
}
