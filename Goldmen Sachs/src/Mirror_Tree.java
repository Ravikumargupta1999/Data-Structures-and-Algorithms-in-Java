// https://practice.geeksforgeeks.org/problems/mirror-tree/1/?company[]=Goldman%20Sachs&company[]=Goldman%20Sachs&page=1&query=company[]Goldman%20Sachspage1company[]Goldman%20Sachs#

public class Mirror_Tree {
    class Node
    {
        int data;
        Node left, right;
        Node(int item)
        {
            data = item;
            left = right = null;
        }
    }
    Node mirror(Node node) {
        if(node == null)
            return null;
        Node left = mirror(node.left);
        Node right = mirror(node.right);
        node.left = right;
        node.right = left;
        return node;

    }
}
