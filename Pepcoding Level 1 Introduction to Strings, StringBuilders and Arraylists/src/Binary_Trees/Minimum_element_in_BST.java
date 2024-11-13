package Binary_Trees;

public class Minimum_element_in_BST {
    class Node{
        int data;
        Node left;
        Node right;
        Node(int data){
            this.data = data;
            left=null;
            right=null;
        }
    }
    int minValue(Node root)
    {
        if (root == null) {
            return -1;
        } else if (root.left == null) {
            return root.data;
        } else
            return minValue(root.left);
    }
}
