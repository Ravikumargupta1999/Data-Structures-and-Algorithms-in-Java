public class Maximum_Depth_Of_Binary_Tree {
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
    // https://practice.geeksforgeeks.org/problems/maximum-depth-of-binary-tree/1?page=30&company[]=Amazon&sortBy=submissions
    public static int maxDepth(Node root) {
        if(root == null)
            return 0;
        return  Math.max(maxDepth(root.left),maxDepth(root.right))+1;
    }
}
