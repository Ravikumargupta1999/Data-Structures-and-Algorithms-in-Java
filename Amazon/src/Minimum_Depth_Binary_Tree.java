// https://practice.geeksforgeeks.org/problems/minimum-depth-of-a-binary-tree/1/?company[]=Amazon&company[]=Amazon&page=3&query=company[]Amazonpage3company[]Amazon
// https://www.youtube.com/watch?v=hmWhJyz5kqc

public class Minimum_Depth_Binary_Tree {
    static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
            left = null;
            right = null;
        }
    }

    int minDepth(Node root) {
        if (root == null)
            return 0;
        if(root.left == null && root.right == null)
            return 1;
        int leftdepth = 0;
        if(root.left != null)
        {
            leftdepth = minDepth(root.left);
        }
        else
        {
            leftdepth = Integer.MAX_VALUE;
        }
        int rightdepth = 0;
        if(root.right != null)
        {
            rightdepth = minDepth(root.right);
        }
        else
        {
            rightdepth = Integer.MAX_VALUE;
        }
        return  1 + Math.min(leftdepth,rightdepth);

    }

    public static void main(String[] args) {

    }
}
