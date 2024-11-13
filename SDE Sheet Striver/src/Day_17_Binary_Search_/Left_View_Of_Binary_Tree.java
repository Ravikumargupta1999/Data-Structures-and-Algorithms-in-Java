package Day_17_Binary_Search_;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Left_View_Of_Binary_Tree {
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
    ArrayList<Integer> leftView(Node root)
    {
        // ArrayList<Integer> al = new ArrayList<>();
        // Queue<Node> q = new LinkedList<>();
        // q.add(root);
        // while (!q.isEmpty()) {
        //     int size = q.size();
        //     if(q.peek() != null)
        //       al.add(q.peek().data);
        //     while (size-- > 0) {
        //         Node temp = q.poll();
        //         if (temp.left != null)
        //             q.add(temp.left);
        //         if (temp.right != null)
        //             q.add(temp.right);
        //     }
        // }
        // return al;
        ArrayList<Integer> al = new ArrayList<>();
        if(root == null)
            return al;
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        while (q.size() !=  0)
        {
            int size = q.size();
            al.add(q.peek().data);
            while (size-- > 0)
            {
                Node temp = q.poll();
                if(temp.left != null)
                    q.add(temp.left);
                if(temp.right != null)
                    q.add(temp.right);
            }
        }
        return al;
    }

}
