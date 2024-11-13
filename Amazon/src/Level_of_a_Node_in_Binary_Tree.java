import java.util.LinkedList;
import java.util.Queue;
//https://practice.geeksforgeeks.org/problems/level-of-a-node-in-binary-tree/1/?company[]=Amazon&company[]=Amazon&difficulty[]=0&page=3&query=company[]Amazondifficulty[]0page3company[]Amazon#

public class Level_of_a_Node_in_Binary_Tree {
    class Node {
        int data;
        Node left, right;

        Node(int d) {
            data = d;
            left = right = null;
        }
    }

    public int levelNode(Node root,int data) {
        if (root == null)
            return -1;
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        int ans = -1;
        int level = 0;
        int max_nodes = Integer.MIN_VALUE;
        while (!q.isEmpty()) {
            int size = q.size();

            while (size-- > 0) {
                Node current = q.peek();
                if(current.data == data)
                    return level;
                if (current.left != null)
                    q.add(current.left);
                if (current.right != null)
                    q.add(current.right);
                q.poll();
            }
            level++;
        }
        return -1;
    }
}
