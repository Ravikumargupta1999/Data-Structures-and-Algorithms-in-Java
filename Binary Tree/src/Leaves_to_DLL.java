import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
// https://practice.geeksforgeeks.org/problems/leaves-to-dll/1/?company[]=Amazon&company[]=Amazon&difficulty[]=1&page=1&category[]=Tree&query=company[]Amazondifficulty[]1page1company[]Amazoncategory[]Tree#
public class Leaves_to_DLL {
    class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
            left = null;
            right = null;
        }
    }

    // return the head of the DLL and remove those node from the tree as well.
    public Node convertToDLL(Node root) {
        if (root == null)
            return null;
        else if (root.left == null && root.right == null) {
            int data = root.data;
            root = null;
            return new Node(root.data);
        }
        ArrayList<ArrayList<Integer>> al = levelOrder(root);
        Node dummy = new Node(-1);
        Node temp = dummy;
        for (int i = al.size() - 1; i >= 0; i--) {
            for (int val : al.get(i)) {
                temp.right = new Node(val);
                temp.right.left = temp;
                temp = temp.right;
            }
        }
        // dummy.right.left = null;
        modify(root);
        System.out.println(al);
        return dummy.right;
    }

    void modify(Node root) {
        if (root == null)
            return;
        if (root.left != null) {
            if (root.left.left == null && root.left.right == null) {
                root.left = null;
            } else {
                modify(root.left);
            }
        }
        if (root.right != null) {
            if (root.right.left == null && root.right.right == null) {
                root.right = null;
            } else {
                modify(root.right);
            }
        }
    }

    public static ArrayList<ArrayList<Integer>> levelOrder(Node root) {
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        if (root == null)
            return new ArrayList<>();
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            int size = q.size();
            ArrayList<Integer> al = new ArrayList<>();
            while (size-- > 0) {
                Node current = q.peek();
                if (current.left == null && current.right == null)
                    al.add(current.data);
                if (current.left != null)
                    q.add(current.left);
                if (current.right != null)
                    q.add(current.right);
                q.poll();
            }
            ans.add(al);
        }
        return ans;
    }
}
