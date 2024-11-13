import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
// https://practice.geeksforgeeks.org/problems/serialize-and-deserialize-a-binary-tree/1/?company[]=Amazon&company[]=Amazon&difficulty[]=1&page=1&category[]=Tree&query=company[]Amazondifficulty[]1page1company[]Amazoncategory[]Tree#
public class Serialize_and_Deserialize_a_Binary_Tree {
    public class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
            left = right = null;
        }
    }
    public void serialize(Node root, ArrayList<Integer> res)
    {
        if (root == null)
            return;
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            Node node = queue.poll();
            if (node == null) {
                res.add(-1);
                continue;
            }
            res.add(node.data);
            queue.add(node.left);
            queue.add(node.right);
        }
    }

    // Decodes your encoded data to tree.
    public Node deSerialize(ArrayList<Integer> values) {
        if (values.size() == 0)
            return null;
        Queue<Node> queue = new LinkedList<>();
        Node root = new Node(values.get(0));
        queue.add(root);
        for (int i = 1; i < values.size(); i++) {
            Node parent = queue.poll();
            if (values.get(i) != -1) {
                Node left = new Node(values.get(i));
                parent.left = left;
                queue.add(left);
            }
            if (values.get(++i) != -1) {
                Node right = new Node(values.get(i));
                parent.right = right;
                queue.add(right);
            }
        }
        return root;
    }
}
