import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

// https://practice.geeksforgeeks.org/problems/odd-even-level-difference/1/?company[]=Amazon&company[]=Amazon&page=2&query=company[]Amazonpage2company[]Amazon

public class Odd_Even_Level_Difference {
    public static class Node {
        int data;
        Node left;
        Node right;

        public Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }


    static int getDifference(Node root) {
        Queue<Node> q = new LinkedList<>();
        int i = 0;
        int oddsum = 0;
        int evensum = 0;

        q.add(root);
        while (!q.isEmpty()) {
            int size = q.size();
            i++;
            while(size-- >0)
            {
                if(i % 2 == 0)
                    evensum += q.peek().data;
                else
                    oddsum += q.peek().data;
                Node current = q.peek();
                //a.add(current.data);
                if (current.left != null)
                    q.add(current.left);
                if (current.right != null)
                    q.add(current.right);
                q.poll();
            }

        }
        return oddsum-evensum;
    }

    public static void main(String[] args) {

    }
}
