import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

public class S_Stack_Queue_329_Levels_of_two_Trees_are_anagrams_or_not {
    // https://practice.geeksforgeeks.org/problems/check-if-all-levels-of-two-trees-are-anagrams-or-not/1/
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

    public static boolean leverOrder(Node root1, Node root2) {
        ArrayList<Integer> al1 = new ArrayList<>();
        ArrayList<Integer> al2 = new ArrayList<>();
        if (root1 == null && root2 == null)
            return true;
        if (root1 == null || root2 == null)
            return false;

        Queue<Node> q1 = new LinkedList<>();
        Queue<Node> q2 = new LinkedList<>();
        q1.add(root1);
        q2.add(root2);
        while (true) {
            int n1 = q1.size(), n2 = q2.size();

            // If n1 and n2 are different
            if (n1 != n2)
                return false;

            // If level order traversal is over
            if (n1 == 0)
                break;
            ArrayList<Integer> curr_level1 = new ArrayList<>();
            ArrayList<Integer> curr_level2 = new ArrayList<>();
            while (n1 > 0) {
                Node node1 = q1.peek();
                q1.remove();
                if (node1.left != null)
                    q1.add(node1.left);
                if (node1.right != null)
                    q1.add(node1.right);
                n1--;

                Node node2 = q2.peek();
                q2.remove();
                if (node2.left != null)
                    q2.add(node2.left);
                if (node2.right != null)
                    q2.add(node2.right);

                curr_level1.add(node1.data);
                curr_level2.add(node2.data);
            }

            Collections.sort(curr_level1);
            Collections.sort(curr_level2);
            if (!curr_level1.equals(curr_level2))
                return false;
        }
        return true;

    }

}
