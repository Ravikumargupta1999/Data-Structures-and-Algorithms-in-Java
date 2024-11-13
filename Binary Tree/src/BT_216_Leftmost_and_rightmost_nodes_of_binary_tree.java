import java.util.LinkedList;
import java.util.Queue;
// https://practice.geeksforgeeks.org/problems/leftmost-and-rightmost-nodes-of-binary-tree/1/?company[]=Amazon&company[]=Amazon&difficulty[]=1&page=1&category[]=Tree&query=company[]Amazondifficulty[]1page1company[]Amazoncategory[]Tree#
public class BT_216_Leftmost_and_rightmost_nodes_of_binary_tree {
    class Node {
        int data;
        Node left, right;

        Node(int key) {
            data = key;
            left = right = null;
        }
    }

    public static void printCorner(Node root) {
        if (root == null)
            return;
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                Node current = q.peek();
                if (i == 0 || i == size - 1) {
                    System.out.print(current.data + " ");
                }
                if (current.left != null)
                    q.add(current.left);
                if (current.right != null)
                    q.add(current.right);
                q.poll();
            }
        }
    }
}
