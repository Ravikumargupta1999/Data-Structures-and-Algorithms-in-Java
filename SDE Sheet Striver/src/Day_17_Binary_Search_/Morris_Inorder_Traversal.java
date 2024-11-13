package Day_17_Binary_Search_;

import java.util.ArrayList;

public class Morris_Inorder_Traversal {

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

    public Node getRightMostNode(Node leftNode, Node curr) {

        while (leftNode.right != null && leftNode.right != curr)
            leftNode = leftNode.right;
        return leftNode;
    }

}
