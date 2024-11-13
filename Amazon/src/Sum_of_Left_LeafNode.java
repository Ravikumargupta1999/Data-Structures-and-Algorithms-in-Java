import java.util.LinkedList;
import java.util.Queue;
//https://practice.geeksforgeeks.org/problems/sum-of-left-leaf-nodes/1/?company[]=Amazon&company[]=Amazon&difficulty[]=0&page=3&query=company[]Amazondifficulty[]0page3company[]Amazon#

public class Sum_of_Left_LeafNode {
    static class Node {
        int data;
        Node left, right;

        Node(int d) {
            data = d;
            left = right = null;
        }
    }

    public int leftLeavesSum(Node root) {
        if (root == null)
            return 0;
        Queue<Node> q = new LinkedList<>();
        q.add(root);

        int sum = 0;

        while (!q.isEmpty()) {
            int size = q.size();
            while (size-- > 0) {
                Node current = q.peek();
                System.out.println(current.data + "  ");
                if (current.left != null && current.left.left == null && current.left.right == null) {
                    System.out.println("hsahhf " + current.left.data);
                    sum += current.left.data;
                }
                if (current.left != null)
                    q.add(current.left);
                if (current.right != null)
                    q.add(current.right);
                q.poll();
            }
        }
        System.out.println("");
        return sum;
    }

    public static void main(String[] args) {
        Sum_of_Left_LeafNode tree = new Sum_of_Left_LeafNode();
        Node root = new Node(20);
        root.left = new Node(9);
        root.right = new Node(49);
        root.left.right = new Node(12);
        root.left.left = new Node(5);
        root.right.left = new Node(23);
        root.right.right = new Node(52);
        root.left.right.right = new Node(12);
        root.right.right.left = new Node(50);
        System.out.println(tree.leftLeavesSum(root));
    }
}
