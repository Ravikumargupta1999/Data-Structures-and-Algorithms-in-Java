import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
//https://practice.geeksforgeeks.org/problems/level-order-traversal-in-spiral-form/1/?company[]=Amazon&company[]=Amazon&difficulty[]=0&page=6&query=company[]Amazondifficulty[]0page6company[]Amazon

public class Level_order_traversal_in_spiral_form {
    class Node {
        int data;
        Node left, right;

        Node(int d) {
            data = d;
            left = right = null;
        }
    }
    public ArrayList<Integer> levelNode(Node root) {
        if (root == null)
            return new ArrayList<>();
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        int level = 0;
        ArrayList<Integer> al = new ArrayList<>();
        while (!q.isEmpty()) {
            int size = q.size();

            if(level%2 != 0) {
                while (size-- > 0) {
                    Node current = q.peek();
                    al.add(current.data);
                    if (current.left != null)
                        q.add(current.left);
                    if (current.right != null)
                        q.add(current.right);
                    q.poll();
                }
            }
            else
            {
                ArrayList<Integer> temp = new ArrayList<>();
                while (size-- > 0) {
                    Node current = q.peek();
                    temp.add(current.data);
                    if (current.left != null)
                        q.add(current.left);
                    if (current.right != null)
                        q.add(current.right);
                    q.poll();
                }
                for(int i= temp.size()-1;i>=0;i--)
                    al.add(temp.get(i));
            }

            level++;
        }
        return al;
    }


}
