import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
// https://practice.geeksforgeeks.org/problems/extreme-nodes-in-alternate-order/1/?company[]=Amazon&company[]=Amazon&difficulty[]=1&page=1&category[]=Tree&query=company[]Amazondifficulty[]1page1company[]Amazoncategory[]Tree#
public class Extreme_nodes_in_alternate_order {
    class Node {
        int data;
        Node left, right;

        Node(int key) {
            data = key;
            left = right = null;
        }
    }

    public ArrayList<Integer> ExtremeNode(Node root) {
        if (root == null)
            return new ArrayList<>();
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        int level = 0;
        ArrayList<Integer> arrayList = new ArrayList<>();
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                Node current = q.peek();
                if (level == 0)
                    arrayList.add(current.data);
                if (level % 2 == 1 && i == 0) {
                    arrayList.add(current.data);
                } else if (level % 2 == 0 && i == size - 1) {
                    arrayList.add(current.data);
                }
                if (current.left != null)
                    q.add(current.left);
                if (current.right != null)
                    q.add(current.right);
                q.poll();
            }
            level++;
        }
        return arrayList;
    }
}
