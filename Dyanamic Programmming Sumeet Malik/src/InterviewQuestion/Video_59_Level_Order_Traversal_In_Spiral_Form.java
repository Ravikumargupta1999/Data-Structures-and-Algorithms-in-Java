package InterviewQuestion;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Video_59_Level_Order_Traversal_In_Spiral_Form {
    // https://practice.geeksforgeeks.org/problems/level-order-traversal-in-spiral-form/1
    class Node {
        int data;
        Node left, right;

        Node(int item) {
            data = item;
            left = right = null;
        }
    }

    //Function to return a list containing the level order
    //traversal in spiral form.
    ArrayList<Integer> findSpiral(Node root) {
        if (root == null)
            return new ArrayList<>();

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        int level = 0;

        ArrayList<Integer> list = new ArrayList<>();
        list.add(root.data);

        while (queue.size() > 0) {

            int size = queue.size();
            ArrayList<Integer> temp = new ArrayList<>();
            while (size-- > 0) {
                Node rem = queue.poll();
                if (rem.left != null)
                    queue.add(rem.left);
                if (rem.right != null)
                    queue.add(rem.right);
                temp.add(rem.data);
            }
            if (level == 0) {
                level++;
                continue;

            }

            if(level % 2 != 0){
                for (int i=0;i<temp.size();i++)
                    list.add(temp.get(i));
            }else {
                for (int i=temp.size()-1;i>=0;i--)
                    list.add(temp.get(i));
            }
            level++;
        }
        return list;
    }
}
