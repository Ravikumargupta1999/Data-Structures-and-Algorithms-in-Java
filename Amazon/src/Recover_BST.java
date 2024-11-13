public class Recover_BST {
    static class Node {
        int data;
        Node left, right;

        Node(int d) {
            data = d;
            left = right = null;
        }
    }
    // https://practice.geeksforgeeks.org/problems/fixed-two-nodes-of-a-bst/1/?company[]=Amazon&company[]=Amazon&difficulty[]=2&page=1&query=company[]Amazondifficulty[]2page1company[]Amazon
    //https://www.youtube.com/watch?v=XLFGcZxn0PM&t=297s
    public static Node correctBST(Node root)
    {
        Node curr = root, a = null,b = null,prev = null;
        while (curr != null)
        {
            Node leftnode = curr.left;
            if(leftnode == null)
            {
                if(prev != null && prev.data > curr.data)
                {
                    if(a == null)
                        a = prev;
                    b = curr;
                }
                prev = curr;
                curr = curr.right;
            }
            else
            {
                Node rmn = getRightMostNode(leftnode,curr);
                if(rmn.right == null)
                {
                    rmn.right = curr;
                    curr = curr.left;
                }
                else
                {
                    rmn.right = null;


                    if( prev.data > curr.data )
                    {
                        if(a == null)
                        {
                            a = prev;
                        }
                        b = curr;
                    }
                    prev  = curr;
                    curr = curr.right;
                }
            }
        }
        if(a != null)
        {
            int temp = a.data;
            a.data = b.data;
            b.data = temp;
        }
        return root;
    }
    public static Node getRightMostNode(Node root,Node curr)
    {
        while (root.right != null && root.right != curr)
            root = root.right;
        return root;
    }
}
