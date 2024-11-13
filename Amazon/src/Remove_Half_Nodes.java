
//https://practice.geeksforgeeks.org/problems/remove-half-nodes/1/?company[]=Amazon&company[]=Amazon&difficulty[]=0&page=2&query=company[]Amazondifficulty[]0page2company[]Amazon

public class Remove_Half_Nodes {
    static class Node {
        int data;
        Node left, right;

        Node(int d) {
            data = d;
            left = right = null;
        }
    }

    public static Node RemoveHalfNodes(Node root) {
        if( root == null)
            return null;
        root.left = RemoveHalfNodes(root.left);
        root.right = RemoveHalfNodes(root.right);
        if(root.left == null && root.right == null)
            return root;
        if(root.left == null)
        {
            Node new_root =root.right;
            return new_root;
        }
        if (root.right == null)
        {
            Node new_root = root.left;
            return new_root;
        }
        return root;
    }
}
