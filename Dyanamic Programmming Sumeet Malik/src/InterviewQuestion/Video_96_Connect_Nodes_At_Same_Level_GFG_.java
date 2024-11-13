package InterviewQuestion;

import java.util.LinkedList;
import java.util.Queue;

public class Video_96_Connect_Nodes_At_Same_Level_GFG_ {
    class Node {
        int data;
        Node left;
        Node right;
        Node nextRight;

        Node(int data) {
            this.data = data;
            left = null;
            right = null;
            nextRight = null;
        }
    }
    // https://practice.geeksforgeeks.org/problems/connect-nodes-at-same-level/1
    public void connect(Node root) {
        if(root == null)
            return ;
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        while (queue.size() > 0){
            int size = queue.size();
            Node prev = null;
            while (size-- > 0){

                Node temp = queue.poll();
                if(prev != null){
                    prev.nextRight = temp;
                }
                prev = temp;
                if(temp.left != null)
                    queue.add(temp.left);
                if(temp.right != null)
                    queue.add(temp.right);
            }
        }

    }
}
