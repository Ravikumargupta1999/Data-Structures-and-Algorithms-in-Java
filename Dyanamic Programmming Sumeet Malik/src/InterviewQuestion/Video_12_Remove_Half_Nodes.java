package InterviewQuestion;


// https://practice.geeksforgeeks.org/problems/remove-half-nodes/1
public class Video_12_Remove_Half_Nodes {

    static class Node {
        int data;
        Node left;
        Node right;

        Node(int d) {
            this.data = d;
            this.left = this.right = null;
        }
    }

    public static Node RemoveHalfNodes(Node root) {
        if (root == null) {
            return null;
        } else {
            root.left = RemoveHalfNodes(root.left);
            root.right = RemoveHalfNodes(root.right);
            if (root.left == null && root.right == null) {
                return root;
            } else {
                if (root.left == null) {
                    return root.right;
                } else if (root.right == null) {
                    return root.left;
                } else {
                    return root;
                }
            }
        }
    }


}
