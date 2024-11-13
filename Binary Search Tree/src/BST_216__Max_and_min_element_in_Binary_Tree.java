import java.util.LinkedList;
import java.util.Queue;

public class BST_216__Max_and_min_element_in_Binary_Tree {
    class Node {
        int data;
        Node left, right;

        public Node(int data){
            this.data = data;
        }
    }
    // https://practice.geeksforgeeks.org/problems/max-and-min-element-in-binary-tree/1/#
    public static int findMax(Node root){
        int max = Integer.MIN_VALUE;
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty())
        {
            Node temp = queue.poll();
            max = Math.max(max,temp.data);
            if(temp.left != null)
                queue.add(temp.left);
            if(temp.right != null)
                queue.add(temp.right);
        }
        if(max == Integer.MIN_VALUE)
            return -1;
        return max;
    }
    public static int findMin(Node root){
        int min = Integer.MAX_VALUE;
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty())
        {
            Node temp = queue.poll();
            min= Math.min(min,temp.data);
            if(temp.left != null)
                queue.add(temp.left);
            if(temp.right != null)
                queue.add(temp.right);
        }
        if(min == Integer.MAX_VALUE)
            return -1;
        return min;
    }
}
