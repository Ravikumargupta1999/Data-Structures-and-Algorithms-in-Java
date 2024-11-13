// https://practice.geeksforgeeks.org/problems/symmetric-tree/1/?company[]=Amazon&company[]=Amazon&difficulty[]=0&page=2&query=company[]Amazondifficulty[]0page2company[]Amazon
//https://www.youtube.com/watch?v=K7LyJTWr2yA
public class Symetric_Tree {
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
    public static boolean isSymmetric(Node root)
    {
        if(root == null)
            return true;
        return isSymmetric(root.left,root.right);
    }
    public static boolean isSymmetric(Node left,Node right)
    {
        if(left == null || right == null)
            return left == right;
        if(left.data != right.data)
            return false;
        return isSymmetric(left.left,right.right) && isSymmetric(left.right,right.left);
    }
}
