package InterviewQuestion;

import java.util.LinkedList;
import java.util.Queue;

public class Video_18_Maximum_Width_Of_Tree {
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
    int getMaxWidth(Node root) {
        int max = 0;

        if(root == null)
            return 0;

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        while (queue.size() > 0)
        {
            int size = queue.size();
            max = Math.max(max,size);

            while (size-- > 0){
                Node temp = queue.poll();

                if(temp.left != null)
                    queue.add(temp.left);
                if(temp.right != null)
                    queue.add(temp.right);
            }
        }
        return max;
    }

}
