package InterviewQuestion;

import java.util.ArrayList;

public class Video_61_Recovery_BST {

    class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
            left = right = null;
        }
    }

    // Normal Approach
    public Node correctBST(Node root) {
        ArrayList<Node> list = new ArrayList<>();
        inorder(root, list);
        Node n1 = null;
        Node n2 = null;

        for (int i = 0; i < list.size(); i++) {
            if (i == 0) {
                if (list.get(i).data > list.get(i + 1).data) {
                    n1 = list.get(i);
                }
            } else if (i == list.size() - 1) {
                if (list.get(i).data < list.get(i - 1).data)
                    n2 = list.get(i);
            } else {

                if (list.get(i).data < list.get(i - 1).data || list.get(i).data > list.get(i + 1).data) {
                    if (n1 == null)
                        n1 = list.get(i);
                    else
                        n2 = list.get(i);
                }
            }
        }

        if (n1 != null && n2 != null) {
            int temp = n1.data;
            n1.data = n2.data;
            n2.data = temp;
        }
        return root;
    }

    public void inorder(Node node, ArrayList<Node> list) {
        if (node == null)
            return;
        inorder(node.left, list);
        list.add(node);
        inorder(node.right, list);
    }

    // Morris Inorder Traversal
    // https://www.youtube.com/watch?v=XLFGcZxn0PM&t=1077s
    // https://practice.geeksforgeeks.org/problems/fixed-two-nodes-of-a-bst/1
    public Node correctBST1(Node root) {

        Node curr = root;
        Node a = null;
        Node b = null;
        Node prev = null;

        while (curr != null) {

            Node leftNode = curr.left;

            if (leftNode == null) {

                if (prev != null && prev.data > curr.data) {
                    if (a == null)
                        a = prev;
                    b = curr;
                }
                prev = curr;

                curr = curr.right;
            } else {

                Node rightMostNode = getRightMostNode(leftNode, curr);

                if (rightMostNode.right == null) {
                    // thread creation
                    rightMostNode.right = curr;
                    curr = curr.left;
                } else {
                    // break thread and process curr node
                    rightMostNode.right = null;
                    if (prev != null && prev.data > curr.data) {
                        if (a == null)
                            a = prev;
                        b = curr;
                    }
                    prev = curr;
                    curr = curr.right;
                }
            }
        }

        if (a != null) {
            int temp = a.data;
            a.data = b.data;
            b.data = temp;
        }
        return root;
    }

    public Node getRightMostNode(Node leftNode, Node curr) {
        while (leftNode.right != null && leftNode.right != curr)
            leftNode = leftNode.right;
        return leftNode;
    }
}
