import java.util.LinkedList;
import java.util.Queue;

// https://practice.geeksforgeeks.org/problems/full-binary-tree/1/?company[]=Amazon&company[]=Amazon&page=3&query=company[]Amazonpage3company[]Amazon

public class Full_Binary_Tree {
    static class Node {
        int data;
        Node left, right;

        Node(int item) {
            data = item;
            left = right = null;
        }
    }

    boolean isFullTree(Node root) {
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        int result = Integer.MIN_VALUE;
        while (!q.isEmpty()) {

            Node current = q.peek();
            if (current.left == null && current.right != null)
                return false;
            else if (current.left != null && current.right == null)
                return false;

            if (current.left != null)
                q.add(current.left);
            if (current.right != null)
                q.add(current.right);
            q.poll();
        }
        return true;

    }


    public static void main(String[] args) {

    }
}
