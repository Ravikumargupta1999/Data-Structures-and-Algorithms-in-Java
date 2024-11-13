package InterviewQuestion;

import java.util.ArrayList;

public class Video_60_Morris_In_Order_Traversal {
    class Node {
        int data;
        Node left, right;

        Node(int item) {
            data = item;
            left = right = null;
        }
    }
    // https://practice.geeksforgeeks.org/problems/inorder-traversal/1
    // https://www.youtube.com/watch?v=oz17ihxBxgU
    ArrayList<Integer> inOrder(Node root) {
        ArrayList<Integer> res = new ArrayList<>();

        Node curr = root;

        while (curr != null) {

            Node leftNode = curr.left;

            if (leftNode == null) {
                res.add(curr.data);
                curr = curr.right;
            } else {
                Node rightMostNode = getRightMostNode(leftNode, curr);

                if (rightMostNode.right == null) {  // create thread
                    rightMostNode.right = curr;
                    curr = curr.left;
                } else {  // print and break thread
                    rightMostNode.right = null;
                    res.add(curr.data);
                    curr = curr.right;
                }
            }
        }
        return res;
    }
    public Node getRightMostNode(Node leftNode,Node curr){

        while (leftNode.right != null && leftNode.right != curr)
            leftNode = leftNode.right;
        return leftNode;
    }
}
