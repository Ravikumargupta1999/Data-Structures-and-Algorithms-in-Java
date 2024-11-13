package InterviewQuestion;

import java.util.LinkedList;
import java.util.Queue;

public class Video_15_Maximum_Node_Level {
    // https://practice.geeksforgeeks.org/problems/maximum-node-level/1

    class Node {
        int data;
        Node left, right;

        Node(int item) {
            data = item;
            left = right = null;
        }
    }

    public static int maxNodeLevel(Node root)
    {

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        int level = 0;
        int res = -1;
        int max = 0;

        while (queue.size() > 0) {

            int size = queue.size();
            if (size > max) {
                max = size;
                res = level;
            }
            while (size-- > 0) {
                Node temp = queue.poll();
                if(temp.left != null)
                    queue.add(temp.left);
                if(temp.right != null)
                    queue.add(temp.right);
            }
            level++;
        }
        return res;
    }
}
