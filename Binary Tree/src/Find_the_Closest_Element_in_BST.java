public class Find_the_Closest_Element_in_BST {
    // https://practice.geeksforgeeks.org/problems/find-the-closest-element-in-bst/1/?company[]=Amazon&company[]=Amazon&difficulty[]=1&page=1&category[]=Tree&query=company[]Amazondifficulty[]1page1company[]Amazoncategory[]Tree
    class Node {
        int data;
        Node left, right;

        Node(int key) {
            data = key;
            left = right = null;
        }
    }
    static  int min ;
    static int minDiff(Node  root, int k)
    {
        min = Integer.MAX_VALUE;
        inorder(root,k);
        return min;
    }
    static void inorder(Node root,int k)
    {
        if(root == null)
            return;
        inorder(root.left,k);
        min = Math.min(Math.abs(k-root.data),min);
        inorder(root.right,k);
    }
}
