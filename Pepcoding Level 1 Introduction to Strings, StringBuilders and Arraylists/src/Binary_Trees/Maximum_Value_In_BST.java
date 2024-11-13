package Binary_Trees;

public class Maximum_Value_In_BST {
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
    int maxValue(Node root)
    {
        if (root == null) {
            return -1;
        } else if (root.right == null) {
            return root.data;
        } else
            return maxValue(root.right);
    }
}
