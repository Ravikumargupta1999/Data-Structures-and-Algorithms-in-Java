import java.util.LinkedList;
import java.util.Queue;
// https://practice.geeksforgeeks.org/problems/max-level-sum-in-binary-tree/1/?company[]=Amazon&company[]=Amazon&page=3&query=company[]Amazonpage3company[]Amazon

public class Max_Level_Sum_In_BT {
    class Node{
        int data;
        Node left,right;
        Node(int d){
            data=d;
            left=right=null;
        }
    }
    public int maxLevelSum(Node root) {
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        int result = Integer.MIN_VALUE;
        while (!q.isEmpty()) {
            int size = q.size();
            int sum = 0;
            while(size-- >0)
            {
                sum += q.peek().data;
                Node current = q.peek();
                if (current.left != null)
                    q.add(current.left);
                if (current.right != null)
                    q.add(current.right);
                q.poll();
            }
            result = Math.max(result,sum);

        }
        return result;
    }
}
