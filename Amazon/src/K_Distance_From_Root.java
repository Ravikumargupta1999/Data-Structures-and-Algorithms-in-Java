import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

// https://practice.geeksforgeeks.org/problems/k-distance-from-root/1/?company[]=Amazon&company[]=Amazon&page=2&query=company[]Amazonpage2company[]Amazon

public class K_Distance_From_Root {
    static class Node {
        int data;
        Node left, right;

        Node(int item) {
            data = item;
            left = right = null;
        }
    }

   static ArrayList<Integer> Kdistance(Node root, int k) {
        ArrayList<Integer> arrayList = new ArrayList<>();
       Queue<Node> q = new LinkedList<>();
       int i = -1;


       q.add(root);
       while (!q.isEmpty()) {
           int size = q.size();
           i++;
           while(size-- >0)
           {
               if(i == k)
                   arrayList.add(q.peek().data);
               Node current = q.peek();
               //a.add(current.data);
               if (current.left != null)
                   q.add(current.left);
               if (current.right != null)
                   q.add(current.right);
               q.poll();
           }

       }
       return arrayList;

    }
}
