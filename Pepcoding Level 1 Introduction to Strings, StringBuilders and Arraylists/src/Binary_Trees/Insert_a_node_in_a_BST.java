package Binary_Trees;
// https://practice.geeksforgeeks.org/problems/insert-a-node-in-a-bst/1
public class Insert_a_node_in_a_BST {
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
    Node insert(Node root, int key) {
        if(root == null)
            return new Node(key);
        if(key == root.data){
            return root;
        }
        if(key < root.data)
            root.left = insert(root.left,key);
        else if(key > root.data)
            root.right = insert(root.right,key);
        return root;
    }

}
