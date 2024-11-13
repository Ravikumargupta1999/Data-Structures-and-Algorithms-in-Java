//import com.sun.xml.internal.bind.v2.runtime.reflect.Lister;
////
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;


public class BT_191_Diagonal_Sum {
    class Node {
        int data;
        Node left;
        Node right;

        public Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }
    // https://practice.geeksforgeeks.org/problems/diagonal-sum-in-binary-tree/1
    static ArrayList<Integer> diagonalView(Node root) {
        ArrayList<ArrayList<Integer>> al = new ArrayList<>();
        ArrayList<Integer> al1 = new ArrayList<>();
        for (int i = 0; i < al.size(); i++)
            al.add(new ArrayList<>());
        if (root == null)
            return al1;


        Queue<Node> q = new LinkedList<>();
        q.add(root);
        while (q.size() != 0) {
            int size = q.size();
            ArrayList<Integer> ans = new ArrayList<>();
            while (size-- > 0) {
                Node temp = q.poll();
                while (temp != null) {
                    ans.add(temp.data);
                    if (temp.left != null)
                        q.add(temp.left);
                    temp = temp.right;
                }
            }
            al.add(ans);
        }

        int sum =0;
        for (int i = 0; i < al.size(); i++) {
            for (int j = 0; j < al.get(i).size(); j++) {
                sum = sum + al.get(i).get(j);
            }
            al1.add(sum);
            sum = 0;

        }
        return al1;
    }

    public static void main(String[] args) {

    }


}

