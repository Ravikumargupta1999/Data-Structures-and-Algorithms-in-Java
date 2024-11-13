public class BST_214_Search_In_BST {
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
    // https://practice.geeksforgeeks.org/problems/search-a-node-in-bst/1
    boolean search(Node root, int x) {
        if(root == null)
            return false;
        if(root.data == x)
            return true;
        if(x < root.data)
            return search(root.left,x);
        return search(root.right,x);
    }
}
