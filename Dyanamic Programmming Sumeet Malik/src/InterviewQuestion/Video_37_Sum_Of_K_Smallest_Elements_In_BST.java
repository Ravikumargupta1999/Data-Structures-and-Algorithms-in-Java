package InterviewQuestion;

import java.util.Collections;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

// https://practice.geeksforgeeks.org/problems/sum-of-k-smallest-elements-in-bst3029/1
public class Video_37_Sum_Of_K_Smallest_Elements_In_BST {
    class Node {
        int data;
        Node left, right;

        Node(int key) {
            this.data = key;
            this.left = this.right = null;
        }
    }

    int sum(Node root, int k) {

        if(root == null)
            return 0;
        Queue<Node> queue = new LinkedList<>();
        PriorityQueue<Integer> queue1 = new PriorityQueue<>(Collections.reverseOrder());

        queue.add(root);

        while (!queue.isEmpty()){

            Node temp = queue.poll();
            if(queue1.size() < k)
                queue1.add(temp.data);
            else if(temp.data < queue1.peek())
            {
                queue1.poll();
                queue1.add(temp.data);
            }
            if(temp.left != null)
                queue.add(temp.left);
            if(temp.right != null)
                queue.add(temp.right);
        }
        int sum = 0;
        while (!queue1.isEmpty())
            sum += queue1.poll();
        return sum;
    }
}
