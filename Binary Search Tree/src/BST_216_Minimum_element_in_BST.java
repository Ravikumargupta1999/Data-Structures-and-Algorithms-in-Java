public class BST_216_Minimum_element_in_BST {
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

    // https://practice.geeksforgeeks.org/problems/minimum-element-in-bst/1
    int minValue(Node node) {
        if (node == null)
            return -1;
        if (node.left == null)
            return node.data;
        else
            return minValue(node.left);
    }

    // https://practice.geeksforgeeks.org/problems/max-and-min-element-in-binary-tree/1/
    public static int findMax(Node root){
       if(root == null)
           return -1;
       if(root.right == null)
           return root.data;
       else
           return findMax(root.right);
    }
    public static int findMin(Node root){
       if(root == null)
           return -1;
       if(root.left == null)
           return root.data;
       else
           return findMin(root.left);
    }
}
