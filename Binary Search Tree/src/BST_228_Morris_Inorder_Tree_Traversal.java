import java.util.ArrayList;

public class BST_228_Morris_Inorder_Tree_Traversal {
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
    // https://www.youtube.com/watch?v=oz17ihxBxgU&t=763s
    // https://practice.geeksforgeeks.org/problems/inorder-traversal-iterative/0/?fbclid=IwAR2_lL0T84DnciLyzMTQuVTMBOi82nTWNLuXjUgahnrtBgkphKiYk6xcyJU#
    public Node getRightMostNode(Node leftNode,Node curr)
    {
        while (leftNode.right != null && leftNode.right != curr)
            leftNode = leftNode.right;
        return leftNode;
    }
    // Return a list containing the inorder traversal of the given tree
    ArrayList<Integer> inOrder(Node root)
    {
        ArrayList<Integer> al = new ArrayList<>();
        Node curr = root;
        while (curr != null) {
            Node leftNode = curr.left;
            if (leftNode == null) {
                al.add(curr.data);
                curr = curr.right;
            }
            else {
                Node rightMostNode = getRightMostNode(leftNode,curr);
                if(rightMostNode.right == null)
                {
                    rightMostNode.right = curr;
                    curr = curr.left;
                }
                else
                {
                    rightMostNode.right = null;
                    al.add(curr.data);
                    curr = curr.right;
                }
            }
        }
        return al;
    }

}
