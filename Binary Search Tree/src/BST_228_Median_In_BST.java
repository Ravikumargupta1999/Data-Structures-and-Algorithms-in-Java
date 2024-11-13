import java.util.ArrayList;

public class BST_228_Median_In_BST {
    public static class Node {
        int data;
        Node left;
        Node right;

        public Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }

    }

    //    If number of nodes are even: then median = (N/2 th node + (N/2)+1 th node)/2
    //    If number of nodes are odd : then median = (N+1)/2th node.
    //    https://practice.geeksforgeeks.org/problems/median-of-bst/1/#
    //    https://www.youtube.com/watch?v=CVXPIRMjO-w
    //    https://www.youtube.com/watch?v=oz17ihxBxgU&t=2418s
    public static float findMedian(Node root) {
        int n = inOrder(root);
        int mid1 = -1;
        int mid2 = -1;
        int mid3 = -1;
        int count = 0;
        Node curr = root;
        while (curr != null) {
            Node leftNode = curr.left;
            if (leftNode == null) {
                count++;
                if (count == n / 2)
                    mid1 = curr.data;
                if (count == n / 2 + 1)
                    mid2 = curr.data;
                if (count == (n + 1) / 2)
                    mid3 = curr.data;
                curr = curr.right;
            } else {
                Node rightMostNode = getRightMostNode(leftNode, curr);
                if (rightMostNode.right == null) {
                    rightMostNode.right = curr;
                    curr = curr.left;
                } else {
                    rightMostNode.right = null;
                    count++;

                    if (count == n / 2)
                        mid1 = curr.data;
                    if (count == n / 2 + 1)
                        mid2 = curr.data;
                    if (count == (n + 1) / 2)
                        mid3 = curr.data;
                    curr = curr.right;
                }
            }
        }
        if (n % 2 != 0)
            return mid3;
        else
            return (float) ((mid1 + mid2) / 2.0);
    }

    public static int inOrder(Node root) {
        int count = 0;
        Node curr = root;
        while (curr != null) {
            Node leftNode = curr.left;
            if (leftNode == null) {
                count++;
                curr = curr.right;
            } else {
                Node rightMostNode = getRightMostNode(leftNode, curr);
                if (rightMostNode.right == null) {
                    rightMostNode.right = curr;
                    curr = curr.left;
                } else {
                    rightMostNode.right = null;
                    count++;
                    curr = curr.right;
                }
            }
        }
        return count;
    }

    public static Node getRightMostNode(Node leftNode, Node curr) {
        while (leftNode.right != null && leftNode.right != curr)
            leftNode = leftNode.right;
        return leftNode;
    }
}
