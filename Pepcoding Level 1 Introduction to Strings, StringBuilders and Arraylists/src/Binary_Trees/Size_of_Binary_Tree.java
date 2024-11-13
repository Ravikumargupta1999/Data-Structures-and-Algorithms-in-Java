package Binary_Trees;

import org.w3c.dom.Node;

public class Size_of_Binary_Tree {
    static class Node{
        int data;
        Node left;
        Node right;
        Node(int data)
        {
            this.data = data;
        }
    }
    // https://practice.geeksforgeeks.org/problems/size-of-binary-tree/1
    public static int getSize(Node root)
    {
        if(root == null)
            return 0;
        return 1 + getSize(root.left)+getSize(root.right);
    }
}
