package InterviewQuestion;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Video_27_Largest_Value_In_Each_Level {
    class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
            left = right = null;
        }
    }

    public ArrayList<Integer> largestValues(Node root) {
        if (root == null)
            return new ArrayList<>();

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        ArrayList<Integer> res = new ArrayList<>();

        while (queue.size() > 0){

            int size = queue.size();
            int max = Integer.MIN_VALUE;
            while (size-- > 0){

                Node temp = queue.poll();
                max = Math.max(max,temp.data);
                if(temp.left != null)
                    queue.add(temp.left);
                if(temp.right != null)
                    queue.add(temp.right);
            }
            res.add(max);

        }
        return res;
    }
}
