// https://practice.geeksforgeeks.org/problems/binary-tree-to-cdll/1/?company[]=Amazon&company[]=Amazon&page=2&query=company[]Amazonpage2company[]Amazon#

public class Binary_Tree_To_CDLL {
 class Node{
        int data;
        Node left,right;
        Node(int d){
            data=d;
            left=right=null;
        }
    }
    int f = 0;
    Node head = null;
    Node prev = null;
    Node bTreeToClist(Node root)
    {
        if (root == null)
            return null;
        solve(root);
        Node temp = head;
        while (temp.right != null)
        {
            temp = temp.right;
        }
        temp.right = head;
        return head;
    }
    void solve(Node root)
    {
        if (root == null)
            return;
        solve(root.left);
        if(f == 0)
        {
            f = 1;
            prev = root;
            head = root;
        }
        else
        {
            prev.right = root;
            prev.right.left = prev;
            prev = prev.right;
        }
        solve(root.right);

    }

    public static void main(String[] args) {
        Node root =null;
        root.data = 67;
        root.left.data = 89;
        root.right.data = 84;


    }
}
